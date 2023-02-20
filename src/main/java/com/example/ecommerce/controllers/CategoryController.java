package com.example.ecommerce.controllers;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/")
    public CategoryDto save(@RequestBody CategoryDto dto){
        return service.save(dto);
    }

    @GetMapping("/{idcategory}")
    public CategoryDto findById(@PathVariable("idcategory") Integer id){
        return service.findById(id);
    }

    @GetMapping("/")
    public List<CategoryDto> findAll(){
        return service.findAll();
    }
}
