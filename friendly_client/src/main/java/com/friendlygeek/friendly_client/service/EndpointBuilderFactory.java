package com.friendlygeek.friendly_client.service;

import com.friendlygeek.friendly_client.Endpoints;
import com.friendlygeek.friendly_client.dto.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class EndpointBuilderFactory {
    public String getSubmitLoginEndpoint(LoginRequest request){
        return String.format("%s%s/findFirstByUsername?username=%s", Endpoints.USERS_ENDPOINT, Endpoints.SEARCH, request.getUsername());
    }

    public String getFindAllRecipes(){
        return String.format("%s%s/findAllByPublishIsTrue", Endpoints.RECIPE_ENDPOINT, Endpoints.SEARCH);
    }
}
