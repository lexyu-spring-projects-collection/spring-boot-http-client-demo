package com.lex.supplier.model;

/**
 * @author : Lex Yu
 */
public class Product {
    private String name;
    private String id;
    private Double value;

    public Product() {
    }

    public Product(String name, String id, Double value) {
        this.name = name;
        this.id = id;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}
