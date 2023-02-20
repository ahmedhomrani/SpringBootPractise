package com.example.ecommerce.services;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.mapper.ObjectMapper;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final ObjectMapper mapper;

    public CategoryDto save(CategoryDto dto){
        Category categoryToSave = mapper.toCategory(dto);
        Category SavedCategory = repository.save(categoryToSave);
        return mapper.toCategoryDto(SavedCategory);
    }

    public CategoryDto findById(Integer id){
       return repository.findById(id)
               .map(mapper::toCategoryDto)
               .orElseThrow(() -> new EntityNotFoundException("No Category found"));
    }

    public List<CategoryDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toCategoryDto)
                .collect(Collectors.toList());
    }

}
