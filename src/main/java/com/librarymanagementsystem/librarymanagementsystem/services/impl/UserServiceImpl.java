package com.librarymanagementsystem.librarymanagementsystem.services.impl;

import com.librarymanagementsystem.librarymanagementsystem.dto.UserDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.UserSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.UserUpdateDto;
import com.librarymanagementsystem.librarymanagementsystem.entity.Author;
import com.librarymanagementsystem.librarymanagementsystem.entity.User;
import com.librarymanagementsystem.librarymanagementsystem.repo.UserRepo;
import com.librarymanagementsystem.librarymanagementsystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo  userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addUser(UserSaveDto userSaveDto) {
        userRepo.save(modelMapper.map(userSaveDto,User.class));
    }

    @Override
    public List<UserDto> getALlUsers() {
        List<User> users = userRepo.findAll();
        if(users.isEmpty()) throw new RuntimeException("Users not found");
        return users.stream()
                .map(user -> modelMapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserUpdateDto userUpdateDto) {
        //Checks the author exists by {id}
        User user = userRepo.findById(userUpdateDto.getUserId())
                .orElseThrow(() -> new ResourceAccessException("AUTHOR NOT FOUND"));
        // Mapp the updated Dto to Author Entity
        modelMapper.map(userUpdateDto,user);
        userRepo.save(user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        if(!userRepo.existsById(id)) return false;
        userRepo.deleteById(id);
        return true;
    }
}
