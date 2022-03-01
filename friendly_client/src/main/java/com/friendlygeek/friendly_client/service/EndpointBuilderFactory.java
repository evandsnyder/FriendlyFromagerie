package com.friendlygeek.friendly_client.service;

import com.friendlygeek.friendly_client.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EndpointBuilderFactory {
    private final String baseAddress;

    public static final String SEARCH ="/search";

    public static final String USERS = "/user";
    public static final String ROLES = "/role";
    public static final String RECIPE = "/recipes";

    @Autowired
    public EndpointBuilderFactory(@Value("${API_SERVER}") String apiAddress, @Value("${API_PORT}") String apiPort){
        baseAddress = apiAddress + ":" + apiPort;
    }

    public String getSubmitLoginEndpoint(LoginRequest request){
        return String.format("%s%s/findFirstByUsername?username=%s", getRecipeEndpoint(), SEARCH, request.getUsername());
    }

    public String getFindAllRecipes(){
        return String.format("%s%s/findAllByPublishIsTrue", getRecipeEndpoint(), SEARCH);
    }

    public String getRecipeEndpoint(){
        return String.format("%s%s", baseAddress, RECIPE);
    }

    public String getUserEndpoint(){
        return String.format("%s%s", baseAddress, USERS);
    }
}
