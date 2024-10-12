package com.restapi.RestfullAPIDB.mapper;

import com.restapi.RestfullAPIDB.dto.UserDto;
import com.restapi.RestfullAPIDB.entity.User;

public class UserMapper {

    // Here we are converting User JPA entity into UserDTO
    public static UserDto mapToUserDto(User user){

        UserDto userssDto=new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userssDto;

    }


    //Converting User Dto into User JPA entity,,,
    public static User mapToUser(UserDto usersssDto){
        User usersmap=new User(
                usersssDto.getId(),
                usersssDto.getFirstName(),
                usersssDto.getLastName(),
                usersssDto.getEmail()


        );

        return usersmap;
    }
}
