package com.friendlygeek.friendly_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
public class FriendlyRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendlyRestApplication.class, args);
    }
}
