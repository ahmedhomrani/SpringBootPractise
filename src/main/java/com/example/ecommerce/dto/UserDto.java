package com.example.ecommerce.dto;

import com.example.ecommerce.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private Role role;
}
