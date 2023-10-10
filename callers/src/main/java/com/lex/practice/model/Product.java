package com.lex.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lex Yu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private String id;
    private Double value;
}
