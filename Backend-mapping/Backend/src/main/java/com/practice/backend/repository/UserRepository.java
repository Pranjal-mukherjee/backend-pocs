package com.practice.backend.repository;

import com.practice.backend.dto.UserDto;
import com.practice.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
