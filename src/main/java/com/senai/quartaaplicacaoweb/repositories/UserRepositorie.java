package com.senai.quartaaplicacaoweb.repositories;

import com.senai.quartaaplicacaoweb.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositorie extends JpaRepository<UserModel,Integer> {
}
