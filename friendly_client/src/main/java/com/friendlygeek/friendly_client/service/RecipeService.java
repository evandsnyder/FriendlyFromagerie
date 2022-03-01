package com.friendlygeek.friendly_client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendlygeek.friendly_client.application.ResourceNotFoundException;
import com.friendlygeek.friendly_client.dto.RecipeWrapper;
import com.friendlygeek.friendly_client.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    EndpointBuilderFactory endpointFactory;

    Logger logger = LoggerFactory.getLogger(RecipeService.class);

    /**
     * Validates that a recipe is valid
     *
     * @param recipe - recipe to validate
     * @return boolean
     */
    public boolean isValidRecipe(Recipe recipe) {
        return !recipe.getCheeseType().isEmpty()
                && !recipe.getHardness().isEmpty()
                && !recipe.getMilkType().isEmpty()
                && !recipe.getIngredients().isEmpty()
                && !recipe.getWarmTheMilk().isEmpty()
                && !recipe.getCultureAndCoagulate().isEmpty()
                && !recipe.getLadleTheCurd().isEmpty()
                && !recipe.getDrainTheCurd().isEmpty()
                && !recipe.getTargetFlavorAndTexture().isEmpty()
                && !recipe.getStorage().isEmpty();
    }

    private RestTemplate restTemplate(){
        ObjectMapper mapper = new ObjectMapper();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
        converter.setObjectMapper(mapper);
        List<HttpMessageConverter<?>> converterList = new ArrayList<>();
        converterList.add(converter);
        return new RestTemplate(converterList);
    }

    public List<Recipe> getAllRecipes() {
        RecipeWrapper recipes = (new RestTemplate()).getForObject(endpointFactory.getFindAllRecipes(), RecipeWrapper.class);
        return recipes.getEmbedded().getRecipe();

    }

    public String saveRecipe(Recipe recipe) {

        if (recipe.getId() == null) {
            logger.info("Saving new recipe");
            RestTemplate request = new RestTemplate();
            ResponseEntity<Recipe> response = request.postForEntity(endpointFactory.getRecipeEndpoint(), recipe, Recipe.class);

            // The post request doesn't return the entire new entity (meaning we have no id)
            // but it does return the address of the new resource which does have the Id on it
            // So we do some string manipulation to extract that and set it on the cheese recipe that gets returned
            String producedResource = String.valueOf(response.getHeaders().get("Location"));
            return producedResource.substring(producedResource.lastIndexOf('/')+1, producedResource.length()-1);
        }
        logger.info("updating recipe");
        // Despite providing the patchForObject method, the default HttpClient used by RestTemplate doesn't actually support
        // PATCH requests. Given that PATCH was officially adopted back in 2010 (https://datatracker.ietf.org/doc/html/rfc5789),
        // it seems silly that now, over a decade later, it's not inherently supported. Instead, we have to use a separate
        // client to actually gain access to the Patch request
        (new RestTemplate(new HttpComponentsClientHttpRequestFactory())).patchForObject(endpointFactory.getRecipeEndpoint() + "/" + recipe.getId(), recipe, Recipe.class);
        return recipe.getId();
    }

    public Recipe getRecipe(String id) {
        Recipe recipe = null;

        try {
            recipe = (new RestTemplate()).getForObject(endpointFactory.getRecipeEndpoint() + "/" + id, Recipe.class);
            recipe.setId(extractId(recipe));
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
                throw new ResourceNotFoundException();
            }
        }

        return recipe;
    }

    // Since the API doesn't include the ID by default, we have to extract if from the HRef provided by the object
    private String extractId(Recipe recipe){
        return recipe.getHref().substring(recipe.getHref().lastIndexOf('/')+1);
    }
}
