package com.example.UserLogInVerfication.service;

import com.example.UserLogInVerfication.binding.UserBinding;
import com.example.UserLogInVerfication.repo.UserRepository;
import com.example.UserLogInVerfication.user.UserLogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository repository;


    @Override
    public Boolean logInChecking(UserBinding binding) {

      UserLogIn LOGIN= repository.findByUserNameAndPassword(binding.getUserName(),binding.getPassword());

      if(LOGIN!=null){
          return true;
      }
      else{
          return false;
      }
    }
}
