package com.restapi.RestfullAPIDB.mapper;

import com.restapi.RestfullAPIDB.dto.UserDto;
import com.restapi.RestfullAPIDB.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

  AutoUserMapper MAPPERs= Mappers.getMapper(AutoUserMapper.class);


    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
