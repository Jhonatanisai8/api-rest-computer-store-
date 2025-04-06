package com.isai.democomputerstore.app.repository;

import com.isai.democomputerstore.app.models.entitys.User;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository
        extends CrudRepository<User, Integer> {

    Optional<User> findUserByUserName(@NotEmpty String userName);
}


