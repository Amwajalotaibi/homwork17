package com.example.homwork17.Service;

import com.example.homwork17.Model.User;
import com.example.homwork17.Repository.UserRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepsitory userRepsitory;

   public List<User> getAllUser(){
       return userRepsitory.findAll();
   }
   public void addUser(User user){
       userRepsitory.save(user);
   }

   public boolean updateUser(Integer id ,User user){
       User oldUser=userRepsitory.getById(id);
       if (oldUser==null){
           return false;
       }

       oldUser.setId(user.getId());
       oldUser.setAge(user.getAge());
       oldUser.setName(user.getName());
       oldUser.setUsername(user.getUsername());
       oldUser.setPassword(user.getPassword());
       oldUser.setRole(user.getRole());
       oldUser.setEmail(user.getEmail());

       userRepsitory.save(oldUser);
       return true;
   }

   public boolean deleteUser (Integer id){
       User oldUser=userRepsitory.getById(id);
       if(oldUser==null){
           return false;
       }
       userRepsitory.delete(oldUser);
       return true;
   }

}
