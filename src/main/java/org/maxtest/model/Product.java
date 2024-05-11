package org.maxtest.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {

    @Id
    private String id;
    private String name;
    private Double price;

    public Product(String name, Double price) {
        super();
        this.name = name;
        this.price = price;
    }
}
