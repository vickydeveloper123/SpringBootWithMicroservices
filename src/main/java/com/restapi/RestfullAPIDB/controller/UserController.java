package com.restapi.RestfullAPIDB.controller;

import com.restapi.RestfullAPIDB.dto.UserDto;
import com.restapi.RestfullAPIDB.entity.User;
import com.restapi.RestfullAPIDB.exception.ErrorDetails;
import com.restapi.RestfullAPIDB.exception.ResourceNotFoundException;
import com.restapi.RestfullAPIDB.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.bytebuddy.build.Plugin;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Tag(
        name = "CURD REST API For user Resource",
        description = "C= Create, U=Update , R= Read , D= Delete [CURD OPERATIONS]."
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")

public class UserController {


    private UserService userServiceee;

    @Operation(

            summary = "CREATING USER REST API",
            description = "Creting a rest api and updating data into the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS  201 CREATED"
    )

    @PostMapping
    public ResponseEntity<UserDto> createUserData(@RequestBody @Valid UserDto userContriller){
     UserDto usersCreatedData=   userServiceee.createUser(userContriller);

        return new ResponseEntity<>(usersCreatedData, HttpStatus.CREATED);
    }


    // Getting all records..


    @Operation(

            summary = "Getting All User Destails of  USER REST API",
            description = "Geting all User dtails of rest api from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS  200 CREATED"
    )

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getAllDetailsss(@PathVariable("id") Long id){

        UserDto getAllData=userServiceee.getUserById(id);

        return new ResponseEntity<>(getAllData,HttpStatus.OK);
    }


    // create a REST API of acessing all the data available from the database.
// http://localhost:80
    @Operation(

            summary = "CREATING ALL USER REST API",
            description = "Retrieveing all User details from the rest api and updating data into the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS  200 CREATED"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> gettingAllUserDetails(){
        List<UserDto> allUserDetails= userServiceee.getAllUserDetails();

        return new ResponseEntity<>(allUserDetails,HttpStatus.OK);
    }

    //Building REST API of updating all user details based on id.
    @Operation(

            summary = "Updating the details of USER REST API",
            description = "Updating  a rest api  data into the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS  200 CREATED sucessfully into the database"
    )

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updatingUser(@PathVariable("id")Long userId,
                                             @RequestBody @Valid UserDto user){

        user.setId(userId);
        UserDto updated=userServiceee.updatingUserDetails(user);

        return new ResponseEntity<>(updated,HttpStatus.OK);
    }


    @Operation(

            summary = "Deleting a data from USER REST API",
            description = "Deleting  a rest api and Deleting  data into the database permanenetly"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS  201 CREATED"
    )

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletingData(@PathVariable("id") Long id){
         userServiceee.deletingUserDetails(id);

         return new ResponseEntity<>("User sucesfully deleted from the data base sucessfully",HttpStatus.OK);
    }


//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException exception,
//                                                                  WebRequest webrequest){
//        ErrorDetails errorDetails=new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webrequest.getDescription(false),
//                "User_Not_Found"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }

}
