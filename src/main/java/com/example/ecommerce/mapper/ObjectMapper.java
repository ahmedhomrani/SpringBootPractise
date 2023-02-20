package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import org.springframework.stereotype.Component;


@Component
public class ObjectMapper {


    public Category toCategory(CategoryDto dto){
        if (dto == null){
            return null;
        }
         return Category.builder()
                    .id(dto.getId())
                    .name(dto.getName())
                    .description(dto.getDescription())
                    .build();

    }

    public CategoryDto toCategoryDto(Category category){
        if (category == null){
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();

    }

    public Product toProduct(ProductDto dto){
        if (dto == null){
            return null;
        }
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .price(dto.getPrice())
                .category(
                        Category.builder()
                                .id(dto.getIdcategory())
                                .build()
                )
                .user(
                        User.builder()
                                .id(dto.getIduser())
                                .build()
                )
                .build();

    }

    public ProductDto toProductDto(Product product){
        if (product == null){
            return null;
        }
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .price(product.getPrice())
                .idcategory(product.getUser().getId())
                .iduser(product.getCategory().getId())
                .build();

    }

    public User toUser (UserDto dto)
    {
        if (dto == null)
        {
            return null;
        }
        return User.builder()
                .id(dto.getId())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();
    }

    public UserDto toUserDto (User user)
    {
        if (user == null)
        {
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .address(user.getAddress())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
