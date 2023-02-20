package com.example.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int id;

	private String name;
	private String description;
	private byte[] image;
	private float price;
	
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

}
