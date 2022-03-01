package com.friendlygeek.friendly_client.service;

import com.friendlygeek.friendly_client.dto.LoginRequest;
import com.friendlygeek.friendly_client.dto.RegisterRequest;
import com.friendlygeek.friendly_client.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    EndpointBuilderFactory endpointFactory;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private User getUserByUsername(LoginRequest request){
        User user = null;
        try{
            user = (new RestTemplate()).getForObject(endpointFactory.getSubmitLoginEndpoint(request), User.class);
        } catch (HttpClientErrorException ex){
            logger.error("Exception thrown will handling login");
            ex.printStackTrace();
            if(ex.getStatusCode() != HttpStatus.NOT_FOUND){
                throw ex;
            }
        }

        return user;
    }

    public User authenticate(LoginRequest loginRequest){
        User user = getUserByUsername(loginRequest);
        return (user != null && user.getPassword().equals(loginRequest.getPassword())) ? user : null;
    }

    public User register(RegisterRequest registrationRequest){
        return (new RestTemplate()).postForObject(endpointFactory.getUserEndpoint(), registrationRequest, User.class);
    }
}
