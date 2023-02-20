package com.example.ecommerce.services;

import com.example.ecommerce.dto.UserDto;
import com.example.ecommerce.mapper.ObjectMapper;
import com.example.ecommerce.model.Role;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final ObjectMapper mapper;

    public UserDto save(UserDto dto)
    {
        User userToSave = mapper.toUser(dto);
        User savedUser = repository.save(userToSave);
        return  mapper.toUserDto(userToSave);
    }

    public List<UserDto> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UserDto changeRole(Integer iduser, Role role){
        User user = repository.findById(iduser)
                .orElseThrow(() -> new EntityNotFoundException("No user found"));
        user.setRole(role);
        repository.save(user);
        return mapper.toUserDto(user);
    }

    public UserDto findById(Integer iduser)
    {
        return repository.findById(iduser)
                .map(mapper::toUserDto)
                .orElseThrow(() -> new EntityNotFoundException("No user was found"));
    }
}
