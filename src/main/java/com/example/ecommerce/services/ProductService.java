package com.example.ecommerce.services;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.mapper.ObjectMapper;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repositories.CategoryRepository;
import com.example.ecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final ObjectMapper mapper;

    public ProductDto save(ProductDto dto) {
        Product productToSave = mapper.toProduct(dto);
        Product savedProduct = repository.save(productToSave);
        return mapper.toProductDto(savedProduct);
    }

    public ProductDto assignToCategory(Integer idprodcut, Integer idcategory) {
        Product product = repository.findById(idprodcut)
                .orElseThrow(() -> new EntityNotFoundException("No product was found"));
        Category category = categoryRepository.findById(idcategory)
                .orElseThrow(() -> new EntityNotFoundException("No category was found"));
        product.setCategory(category);
        Product savedProduct = repository.save(product);
        return mapper.toProductDto(savedProduct);
    }

    public List<ProductDto> findAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findAllProductsByCategory(Integer idcategory) {
        return repository.findAllByCategoryId(idcategory)
                .stream()
                .map(mapper::toProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toProductDto)
                .orElseThrow(() -> new EntityNotFoundException("No product was found"));
    }

    public List<ProductDto> findProductsByName(String name) {
        return repository.findAllByName(name)
                .stream()
                .map(mapper::toProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> searchProductsByDescription(String description) {
        return repository.findAllByDescription(description)
                .stream()
                .map(mapper::toProductDto)
                .collect(Collectors.toList());
    }


}
