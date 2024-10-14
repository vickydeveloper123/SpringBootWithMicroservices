package com.restapi.RestfullAPIDB.service;

import com.restapi.RestfullAPIDB.dto.UserDto;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUserDetails();

    UserDto updatingUserDetails( UserDto user);


    void deletingUserDetails(Long id);

}
