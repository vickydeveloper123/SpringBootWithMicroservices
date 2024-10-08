package com.example.UserLogInVerfication.controller;
import com.example.UserLogInVerfication.binding.UserBinding;
import com.example.UserLogInVerfication.service.UserService;
import com.example.UserLogInVerfication.user.UserLogIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {

    private UserService service;

    @PostMapping("login")
    public ResponseEntity<Boolean> createUserData(@RequestBody UserBinding binding){

       Boolean data= service.logInChecking(binding);
       return new ResponseEntity<>(data, HttpStatus.OK);
    }


}
