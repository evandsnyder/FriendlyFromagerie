package com.friendlygeek.friendly_client.service;

import com.friendlygeek.friendly_client.dto.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(EndpointBuilderFactory.class);

    @Autowired
    public EndpointBuilderFactory(@Value("${API_ADDRESS}") String apiAddress){
        baseAddress = apiAddress;
        logger.info("Base Address: {}", baseAddress);
    }

    public String getSubmitLoginEndpoint(LoginRequest request){
        return String.format("%s%s/findFirstByUsername?username=%s", getUserEndpoint(), SEARCH, request.getUsername());
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
