package com.lex.caller.service;

import com.lex.caller.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(Users.class);
    }

    public Mono<Users> findUserById(Long id){
        return webClient.get()
                .uri("/user/{id}", id)
                .retrieve()
                .bodyToMono(Users.class);
    }

    public Mono<ClientResponse> saveUser(Users user){
        return this.webClient.post().uri("/save")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(user), Users.class)
                .exchangeToMono(res -> {
                    if (res.statusCode().is2xxSuccessful()){
                        return Mono.just(res);
                    }else {
                        return res.createException().flatMap(Mono::error);
                    }
                });
    }

    public Mono<Users> updateUser(Users user){
        return this.webClient.put().uri("/update")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(user), Users.class)
                .retrieve()
                .bodyToMono(Users.class);
    }

    public Mono<Void> deleteUser(Long id){
        return this.webClient.delete().uri("/user/{id}")
                .retrieve()
                .bodyToMono(Void.class);
    }
}
