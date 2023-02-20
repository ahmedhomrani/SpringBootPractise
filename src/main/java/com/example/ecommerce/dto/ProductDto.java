package com.example.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private int id;

    private String name;
    private String description;
    private byte[] image;
    private float price;
    private int idcategory;

    private int iduser;
}
