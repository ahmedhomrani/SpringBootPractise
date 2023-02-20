package com.example.ecommerce.repositories;

import com.example.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer> {
   // List<Category> findAllByName(String name);
   // List<Category> findAllByPartName(String p);
   // Category FindByDescription(String Desc);
}
