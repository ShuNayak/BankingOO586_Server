package com.api.comp586.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.comp586.entity.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer> {

}
