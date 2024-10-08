package com.restapi.RestfullAPIDB.service.ServiceImplementation;


import com.restapi.RestfullAPIDB.entity.User;
import com.restapi.RestfullAPIDB.repository.UserRepository;
import com.restapi.RestfullAPIDB.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {


    private UserRepository userRepoository;
    @Override
    public User createUser(User user) {
        return userRepoository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User>  gettingUsersData= userRepoository.findById(id);
        return gettingUsersData.get();
    }

    @Override
    public List<User> getAllUserDetails() {
        return userRepoository.findAll();
    }

    @Override
    public User updatingUserDetails(User user) {

        User updatingUserDetailsss= userRepoository.findById(user.getId()).get();


        updatingUserDetailsss.setFirstName(user.getFirstName());

        updatingUserDetailsss.setLastName(user.getLastName());
        updatingUserDetailsss.setEmail(user.getEmail());
        User updatedUserDetails= userRepoository.save(updatingUserDetailsss);
        return updatedUserDetails;
    }

    @Override
    public void deletingUserDetails(Long id) {

       userRepoository.deleteById(id);
    }


}
