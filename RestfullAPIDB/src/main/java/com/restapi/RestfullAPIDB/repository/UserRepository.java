package com.restapi.RestfullAPIDB.repository;

import com.restapi.RestfullAPIDB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
