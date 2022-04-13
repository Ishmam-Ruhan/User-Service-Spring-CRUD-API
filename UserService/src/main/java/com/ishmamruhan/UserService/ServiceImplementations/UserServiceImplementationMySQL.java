package com.ishmamruhan.UserService.ServiceImplementations;

import com.ishmamruhan.UserService.DAO.UserDao;
import com.ishmamruhan.UserService.DTO.User;
import com.ishmamruhan.UserService.ExceptionManagement.CustomError;
import com.ishmamruhan.UserService.Helpers.DateGenerator;
import com.ishmamruhan.UserService.Services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
public class UserServiceImplementationMySQL implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public String addUser(User user) throws CustomError {
        try{
            userDao.save(user).getId();
        }catch (Exception ex){
            throw new CustomError(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(),"User Save Failed");
        }

        return "User Added Successfully!";
    }

    @Override
    public String addusers(List<User> users) throws CustomError{

        try{
            userDao.saveAll(users);
        }catch (Exception ex){
            throw new CustomError(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Users Save Failed");
        }

        return "All Users Added Successfully!";
    }

    @Override
    public User getUserByUserId(String userId) throws CustomError{
        User user = null;
        try{
            user = userDao.findById(UUID.fromString(userId)).orElseThrow();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"User Not Found!");
        }
        return user;
    }

    @Override
    public User getUserByUserEmail(String email) throws CustomError{
        User user = null;
        try{
            user = userDao.findByemail(email).orElseThrow();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"User Not Found!");
        }
        return user;
    }

    @Override
    public User getUserByPhoneNo(String phoneNo) throws CustomError{
        User user = null;
        try{
            user = userDao.findByphoneNo(phoneNo).orElseThrow();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"User Not Found!");
        }
        return user;
    }

    @Override
    public List<User> getUserByCatagory(String catagory) throws CustomError{
        List<User> users = new LinkedList<>();
        try{
            users = userDao.findAll();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"Users Not Found!");
        }

        return users.stream()
                .filter(user -> user.getUserType().toString().toLowerCase().equals(catagory.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsers() throws CustomError{
        List<User> users = new LinkedList<>();
        try{
            users = userDao.findAll();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"Users Not Found!");
        }

        return users;
    }

    @Override
    public List<User> getAllActiveUsers(String status) throws CustomError{
        List<User> users = new LinkedList<>();
        try{
            users = userDao.findAll();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"Users Not Found!");
        }

        return users.stream()
                .filter(user -> user.getIsActive().toString().toLowerCase().equals(status.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public String updateUser(User user) throws CustomError{

        User myUser = null;
        try{
            myUser = userDao.findById(user.getId()).orElseThrow();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"User Not Found!");
        }

        BeanUtils.copyProperties(user,myUser);
        myUser.setUpdatedAt(new DateGenerator().getDate());

        try{
            userDao.save(myUser).getId();
        }catch (Exception ex){
            throw new CustomError(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(),"User Save Failed");
        }

        return "User Updated Successfully!";
    }

    @Override
    public String deleteUser(User user) throws CustomError{

        try{
            userDao.findById(user.getId()).orElseThrow();
        }catch (Exception ex){
            throw new CustomError(404, HttpStatus.NOT_FOUND.toString(),"User Not Found!");
        }

        try{
            userDao.deleteById(user.getId());
        }catch (Exception ex){
            throw new CustomError(500, HttpStatus.INTERNAL_SERVER_ERROR.toString(),"Something Went Wrong while removing!");
        }

        return "User Deleted Successfully";
    }
}
