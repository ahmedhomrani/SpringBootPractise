package com.example.ecommerce.repositories;

import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {

    List<Product> findAllByCategoryId(Integer idcategory);
    List<Product> findAllByName(String name);
    List<Product> findAllByDescription(String description);
}
