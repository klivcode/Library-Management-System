package com.librarymanagementsystem.librarymanagementsystem.services;

import com.librarymanagementsystem.librarymanagementsystem.dto.UserDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.UserSaveDto;
import com.librarymanagementsystem.librarymanagementsystem.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    void addUser(UserSaveDto userSaveDto);

    List<UserDto> getALlUsers();

    void updateUser(UserUpdateDto userUpdateDto);

    boolean deleteUser(Integer id);
}
