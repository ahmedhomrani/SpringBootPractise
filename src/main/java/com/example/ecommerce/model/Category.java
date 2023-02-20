package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
}
