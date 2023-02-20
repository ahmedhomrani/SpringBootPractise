package com.example.ecommerce.controllers;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/")
    public ProductDto save(@RequestBody ProductDto dto) {
        return service.save(dto);
    }

    @PatchMapping("/{idproduct}/{idcategory}")
    public ProductDto assignToCategory(
            @PathVariable("idproduct") Integer idprodcut,
            @PathVariable("idcategory") Integer idcategory) {
        return service.assignToCategory(idprodcut,idcategory);
    }

    @GetMapping("/")
    public List<ProductDto> findAllProducts() {
        return service.findAllProducts();
    }

    @GetMapping("/category/{idcategory}")
    public List<ProductDto> findAllProductsByCategory(@PathVariable("idcategory") Integer idcategory) {
        return service.findAllProductsByCategory(idcategory);
    }

    @GetMapping("/{idproduct}")
    public ProductDto findById(@PathVariable("idproduct") Integer id) {
        return service.findById(id);
    }

    @GetMapping("/find")
    public List<ProductDto> findProductsByName( @RequestParam("name")  String name) {
        return service.findProductsByName(name);
    }

    @GetMapping("/serach")
    public List<ProductDto> searchProductsByDescription(@RequestParam("description") String description) {
        return service.searchProductsByDescription(description);
    }
}
