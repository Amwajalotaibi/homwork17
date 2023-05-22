package com.example.homwork17.Repository;

import com.example.homwork17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepsitory extends JpaRepository<User,Integer> {

}
