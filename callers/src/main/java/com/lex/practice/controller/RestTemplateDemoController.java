package com.lex.practice.controller;

import com.lex.practice.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Lex Yu
 */
@Slf4j
@RestController
public class RestTemplateDemoController {
    @GetMapping("/rest")
    public List<Product> getProductsRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        long start = System.nanoTime();
        ResponseEntity<Product[]> resEntity = restTemplate.getForEntity("http://127.0.0.1:8080/products?type=rest", Product[].class);
        long end = System.nanoTime();
        log.info(Thread.currentThread().getName() + " restTemplate cost:" + ((end - start) / 1_000_000_000) + "s");
        log.info("Block 5 Seconds");
        List<Product> products = Arrays.asList(resEntity.getBody());
        return products;
    }
}
