package com.senai.quartaaplicacaoweb.services;

import com.senai.quartaaplicacaoweb.models.UserModel;
import com.senai.quartaaplicacaoweb.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@EnableJpaRepositories
@Service
public class LoginService {

    @Autowired(required = true)
     UserRepositorie userRepositorie;



    public UserModel logar(UserModel userModel){
        return userRepositorie.login(userModel.getEmail(), userModel.getPassword());
    }
}
