package com.example.ecommerce.controllers;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.model.Role;
import com.example.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/")
    public UserDto save(@RequestBody UserDto dto) {
        return service.save(dto);
    }

    @GetMapping("/")
    public List<UserDto> findAll() {
        return service.findAll();
    }

    @PatchMapping("/{iduser}")
    public UserDto changeRole(@PathVariable("iduser") Integer iduser,
                              @RequestParam("role") Role role) {
        return service.changeRole(iduser, role);
    }

    @GetMapping("/{iduser}")
    public UserDto findById(@PathVariable("iduser")Integer iduser) {
        return service.findById(iduser);
    }
}
