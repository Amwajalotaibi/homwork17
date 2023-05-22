package com.example.homwork17.Controller;

import com.example.homwork17.Model.User;
import com.example.homwork17.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControl {

    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getUser(){
        List<User> userList=userService.getAllUser();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("user Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user, @PathVariable Integer id , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        boolean isUpdate=userService.updateUser(id,user);

        if(isUpdate){

            return ResponseEntity.status(200).body("user update");

        }
        return ResponseEntity.status(400).body("user not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isDelete= userService.deleteUser(id);
        if(isDelete){
            return ResponseEntity.status(200).body("user delete");

        }
        return ResponseEntity.status(400).body("user not found");
    }
}
