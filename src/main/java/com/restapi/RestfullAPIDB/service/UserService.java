package com.restapi.RestfullAPIDB.service;

import com.restapi.RestfullAPIDB.dto.UserDto;
import com.restapi.RestfullAPIDB.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<UserDto> getAllUserDetails();

    UserDto updatingUserDetails(User user);


    void deletingUserDetails(Long id);

}
