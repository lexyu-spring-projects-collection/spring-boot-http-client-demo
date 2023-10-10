package com.lex.practice.service;

import com.lex.practice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author : Lex Yu
 */
@Service
public class WebClientService {

    @Qualifier("local")
    private final WebClient webClient;

    @Autowired
    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }


    public Flux<Users> findUsers(){


        return null;
    }
}
