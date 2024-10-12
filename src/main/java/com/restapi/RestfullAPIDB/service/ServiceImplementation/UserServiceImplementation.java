package com.restapi.RestfullAPIDB.service.ServiceImplementation;


import com.restapi.RestfullAPIDB.dto.UserDto;
import com.restapi.RestfullAPIDB.entity.User;
import com.restapi.RestfullAPIDB.mapper.AutoUserMapper;
import com.restapi.RestfullAPIDB.mapper.UserMapper;
import com.restapi.RestfullAPIDB.repository.UserRepository;
import com.restapi.RestfullAPIDB.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {


    private ModelMapper modelMapperr;

    private UserRepository userRepoository;
    @Override
    public UserDto createUser(UserDto userdo) {

        // Here we are retrieving our data into userjpa entity into UserDto.
       // User userref= UserMapper.mapToUser(userdto);

      //  User userref=modelMapperr.map(userdto,User.class);
     User userref= AutoUserMapper.MAPPERs.mapToUser(userdo);

        User userdtoref=  userRepoository.save(userref);

     // UserDto userref1=modelMapperr.map(userdtoref,UserDto.class);

        UserDto userref1=AutoUserMapper.MAPPERs.mapToUserDto(userdtoref);
      return userref1;


    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User>  gettingUsersData= userRepoository.findById(id);
        User optoonalUser= gettingUsersData.get();

    //    return UserMapper.mapToUserDto(optoonalUser);
       // return modelMapperr.map(optoonalUser,UserDto.class);

        // here in the above source code we have done modification on the source code model mapper.

        // This is by the Auto User Mapper.

        return AutoUserMapper.MAPPERs.mapToUserDto(gettingUsersData.get());

        // Here this optional data will convert into user JPA entity that is the reason we have done by using user mapper.
    }

    @Override
    public List<UserDto> getAllUserDetails() {
        List<User>  suere= userRepoository.findAll();
   //    return suere.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
// by using model mapper.
     //   return suere.stream().map((users) -> modelMapperr.map(users,UserDto.class)).collect(Collectors.toList());
    // here in the above source code we have added our value by using lambda expressions....

        // by using Auto User Mapper.

        return suere.stream().map((user)
                ->AutoUserMapper.MAPPERs.mapToUserDto(user)).collect(Collectors.toList());

        // Here in the above code we are doing by the help of Auto USER Mapper and we are storing the data by the help of using dto.
    }




    @Override
    public UserDto updatingUserDetails(User user) {

        User updatingUserDetailsss= userRepoository.findById(user.getId()).get();


        updatingUserDetailsss.setFirstName(user.getFirstName());

        updatingUserDetailsss.setLastName(user.getLastName());
        updatingUserDetailsss.setEmail(user.getEmail());
        User updatedUserDetails= userRepoository.save(updatingUserDetailsss);
       // return UserMapper.mapToUserDto(updatedUserDetails);

      //  return modelMapperr.map(updatedUserDetails,UserDto.class);

        return AutoUserMapper.MAPPERs.mapToUserDto(updatedUserDetails);

    }



    @Override
    public void deletingUserDetails(Long id) {

       userRepoository.deleteById(id);
    }


}
