package com.example.UserLogInVerfication.repo;

import com.example.UserLogInVerfication.user.UserLogIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogIn,Long> {

    UserLogIn findByUserNameAndPassword(String user_Name, String password);


}
