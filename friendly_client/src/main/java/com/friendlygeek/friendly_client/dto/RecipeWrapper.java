package com.friendlygeek.friendly_client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.friendlygeek.friendly_client.model.Recipe;

import java.util.List;

/**
 * This is an incredible bad approach to take with correcting this problem. So, I think its important to
 * document how we ended up in this situation. On the API side of things, we leverage Spring Boot Start Rest
 * which incorporates HATEOAS to make a truly restful service. This works fine for single-entity requests, but doesn't
 * work as well with lists or collections. By default, Spring Rest works using the HAL format for JSON messages
 * When querying for a collection, all elements get tucked into an `_embedded` object inside the JSON. When it comes to
 * deserializing the list, the built-in Jackson 2 deserializer can't process the elements since they don't actually
 * match the domain models (thanks to the _embedded piece). To account for that, we've got a Wrapper DTO class here
 * that contains an embedded object.
 *
 * In an ideal world, we would create customer parser, or, better yet, Spring would inherently support a convenient way
 * of consuming their own REST Api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeWrapper {
    public class Embedded{
        @JsonProperty("recipes")
        private List<Recipe> recipe;

        public Embedded(){}

        public List<Recipe> getRecipe() {
            return recipe;
        }

        public void setRecipe(List<Recipe> recipe) {
            this.recipe = recipe;
        }
    }

    @JsonProperty("_embedded")
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public RecipeWrapper(){}
}
