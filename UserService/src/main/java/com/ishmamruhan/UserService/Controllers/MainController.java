package com.ishmamruhan.UserService.Controllers;

import com.ishmamruhan.UserService.DTO.User;
import com.ishmamruhan.UserService.ExceptionManagement.CustomError;
import com.ishmamruhan.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public String addUser(@Valid @RequestBody User user) throws CustomError {
        return userService.addUser(user);
    }

    @PostMapping("/user/add/all")
    public String addAllUser(@Valid @RequestBody List<User> users) throws CustomError {
        return userService.addusers(users);
    }

    @GetMapping("/user/get/id-{id}")
    public User getUserById(@PathVariable String id) throws CustomError{
        return userService.getUserByUserId(id);
    }

    @GetMapping("/user/get/email-{email}")
    public User getUserByEmail(@PathVariable String email) throws CustomError{
        return userService.getUserByUserEmail(email);
    }

    @GetMapping("/user/get/phone-{phone}")
    public User getUserByPhoneNumber(@PathVariable String phone) throws CustomError{
        return userService.getUserByPhoneNo(phone);
    }

    @GetMapping("/user/get/all/catagory-{catagory}")
    public List<User> getUserByCatagory(@PathVariable String catagory) throws CustomError{
        return userService.getUserByCatagory(catagory);
    }

    @GetMapping("/user/get/all/status-{status}")
    public List<User> getUserByActiveStatus(@PathVariable String status) throws CustomError{
        return userService.getAllActiveUsers(status);
    }

    @GetMapping("/user/get/all")
    public List<User> getUAllUsers() throws CustomError{
        return userService.getAllUsers();
    }

    @PutMapping("/user/update")
    public String updateUser(@Valid @RequestBody User user) throws CustomError {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/delete")
    public String deleteUser(@RequestBody User user) throws CustomError {
        return userService.deleteUser(user);
    }
}
