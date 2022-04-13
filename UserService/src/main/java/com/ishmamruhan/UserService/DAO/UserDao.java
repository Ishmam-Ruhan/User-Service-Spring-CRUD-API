package com.ishmamruhan.UserService.DAO;

import com.ishmamruhan.UserService.DTO.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<User, UUID> {
    Optional<User> findByemail(String email);

    Optional<User> findByphoneNo(String phoneNo);
}
