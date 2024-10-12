package com.restapi.RestfullAPIDB.controller;

import com.restapi.RestfullAPIDB.dto.UserDto;
import com.restapi.RestfullAPIDB.entity.User;
import com.restapi.RestfullAPIDB.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")

public class UserController {


    private UserService userServiceee;

    @PostMapping
    public ResponseEntity<UserDto> createUserData(@RequestBody UserDto userContriller){
     UserDto usersCreatedData=   userServiceee.createUser(userContriller);

        return new ResponseEntity<>(usersCreatedData, HttpStatus.CREATED);
    }


    // Getting all records..

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getAllDetailsss(@PathVariable("id") Long id){

        UserDto getAllData=userServiceee.getUserById(id);

        return new ResponseEntity<>(getAllData,HttpStatus.OK);
    }


    // create a REST API of acessing all the data available from the database.
// http://localhost:80

    @GetMapping
    public ResponseEntity<List<UserDto>> gettingAllUserDetails(){
        List<UserDto> allUserDetails= userServiceee.getAllUserDetails();

        return new ResponseEntity<>(allUserDetails,HttpStatus.OK);
    }

    //Building REST API of updating all user details based on id.


    @PutMapping("{id}")
    public ResponseEntity<UserDto> updatingUser(@PathVariable("id")Long userId,
                                             @RequestBody User user){

        user.setId(userId);
        UserDto updated=userServiceee.updatingUserDetails(user);

        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
    


    @DeleteMapping("{id}")
    public ResponseEntity<String> deletingData(@PathVariable("id") Long id){
         userServiceee.deletingUserDetails(id);

         return new ResponseEntity<>("User sucesfully deleted from the data base sucessfully",HttpStatus.OK);
    }



}
