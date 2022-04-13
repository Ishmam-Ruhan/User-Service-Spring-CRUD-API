package com.ishmamruhan.UserService.Services;

import com.ishmamruhan.UserService.DTO.User;
import com.ishmamruhan.UserService.ExceptionManagement.CustomError;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    /*
    *  Performing CRUD Operation
    */

    //Create User/Users
    String addUser(User user) throws CustomError;

    String addusers(List<User> users) throws CustomError;

    //Read User details
    User getUserByUserId(String userId) throws CustomError;

    User getUserByUserEmail(String email) throws CustomError;

    User getUserByPhoneNo(String phoneNo) throws CustomError;

    List<User> getUserByCatagory(String catagory) throws CustomError;

    List<User> getAllUsers() throws CustomError;

    List<User> getAllActiveUsers(String status) throws CustomError;

    //Update User
    String updateUser(User user) throws CustomError;

    //Delete User
    String deleteUser(User user) throws CustomError;

}
