package com.intertec.model.repository;

import com.intertec.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Userpc on 13/05/2018.
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    User findUserByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.userName like ?1")
    List<User> findUsersByName(String name);
}
