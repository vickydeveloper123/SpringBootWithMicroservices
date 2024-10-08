package com.restapi.RestfullAPIDB.service;

import com.restapi.RestfullAPIDB.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUserDetails();

    User updatingUserDetails(User user);


    void deletingUserDetails(Long id);

}
