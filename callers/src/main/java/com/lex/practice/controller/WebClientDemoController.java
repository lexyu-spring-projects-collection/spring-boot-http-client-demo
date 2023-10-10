package com.lex.practice.controller;

import com.lex.practice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author : Lex Yu
 */
@Slf4j
@RestController
public class WebClientDemoController {
    @GetMapping("/webclient")
    public ResponseEntity<Flux<Product>> getProductsWebclient() {
        long start = System.nanoTime();
        Flux<Product> productFlux = WebClient.create("http://127.0.0.1:8080/products?type=webclient")
                .get()
                .retrieve()
                .bodyToFlux(Product.class)
                .doOnNext(res -> log.info("Json Response = {}", res));
        long end = System.nanoTime();
        log.info(Thread.currentThread().getName() + " webclient cost:" +  ((end - start) / 1_000_000_000) + "s");
        return ResponseEntity.ok(productFlux);
    }

}