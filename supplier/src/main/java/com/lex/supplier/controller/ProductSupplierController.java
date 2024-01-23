package com.lex.supplier.controller;

import com.lex.supplier.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lex Yu
 */
@RestController
public class ProductSupplierController {

    private static final Logger log = LoggerFactory.getLogger(ProductSupplierController.class);

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam String type) throws InterruptedException {
        log.info("{} Request Coming", type);
        List<Product> products = new ArrayList<>();
        Product a = new Product(type + "-A", "1", 100.70);
        Product b = new Product(type + "-B", "2", 200.50);
        Product c = new Product(type + "-C", "3", 300.90);
        products.add(a);
        products.add(b);
        products.add(c);
        Thread.sleep(5_000);
        return ResponseEntity.ok(products);
    }
}
