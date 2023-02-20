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
@Table(name ="_user")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	@Column(unique = true,nullable = false)
	private String email;
	private String address;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Product> products;
}
