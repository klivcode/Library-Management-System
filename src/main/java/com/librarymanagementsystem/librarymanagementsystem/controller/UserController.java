package com.librarymanagementsystem.librarymanagementsystem.controller;


import com.librarymanagementsystem.librarymanagementsystem.dto.*;
import com.librarymanagementsystem.librarymanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/save")
    public ResponseEntity<String> saveUser(@RequestBody UserSaveDto userSaveDto) {
        userService.addUser(userSaveDto);
        return ResponseEntity.ok("User saved successfully");
    }


    @GetMapping(path = "/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllAuthors() {
        List<UserDto> getAuthors= userService.getALlUsers();
        return ResponseEntity.ok(getAuthors);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateAuthor(@RequestBody UserUpdateDto userUpdateDto) {
        userService.updateUser(userUpdateDto);
        return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(value = "id") Integer id) {
        boolean userDeleted=userService.deleteUser(id);
        if(userDeleted){
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.badRequest().build();
    }

}
