package com.restapi.RestfullAPIDB.service.ServiceImplementation;


import com.restapi.RestfullAPIDB.dto.UserDto;
import com.restapi.RestfullAPIDB.entity.User;
import com.restapi.RestfullAPIDB.exception.EmailAlreadyExistsException;
import com.restapi.RestfullAPIDB.exception.ResourceNotFoundException;
import com.restapi.RestfullAPIDB.mapper.AutoUserMapper;
import com.restapi.RestfullAPIDB.repository.UserRepository;
import com.restapi.RestfullAPIDB.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

       Optional<User> optionallUser= userRepoository.findByEmail(userdo.getEmail());

       if(optionallUser.isPresent()){
           throw new EmailAlreadyExistsException("Email Already exists in the database");
       }
     User userref= AutoUserMapper.MAPPERs.mapToUser(userdo);

        User userdtoref=  userRepoository.save(userref);


        UserDto userref1=AutoUserMapper.MAPPERs.mapToUserDto(userdtoref);
      return userref1;


    }

    @Override
    public UserDto getUserById(Long id) {
      User gettingUsersData= userRepoository.findById(id).orElseThrow(()->
             new ResourceNotFoundException("User","id",id)
        );
        return AutoUserMapper.MAPPERs.mapToUserDto(gettingUsersData);

    }

    @Override
    public List<UserDto> getAllUserDetails() {
        List<User>  suere= userRepoository.findAll();

        return suere.stream().map((user)
                ->AutoUserMapper.MAPPERs.mapToUserDto(user)).collect(Collectors.toList());

        // Here in the above code we are doing by the help of Auto USER Mapper and we are storing the data by the help of using dto.
    }




    @Override
    public UserDto updatingUserDetails(@Valid UserDto user) {

        User updatingUserDetailsss= userRepoository.findById(user.getId()).orElseThrow(
                ()->new ResourceNotFoundException("User","id",user.getId())
        );

        // So here in the above code we have thrown our own custom exception if the data is not available
        // in the data base ....


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

     User user=   userRepoository.findById(id).orElseThrow(
        ()-> new ResourceNotFoundException("User","id",id));

     // So here in the above source code we have thrown an exception ,
        // firstly we are checking the data in the data base before deleting if the data is not available from the database,
        // then it will thrown the custom  exception what we have been declared...



       userRepoository.deleteById(id);
    }


}
