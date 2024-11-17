package com.contactmanager.smartcontactmanager.dao;

// import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactmanager.smartcontactmanager.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

// public interface UserRepository extends CrudRepository<User, Integer> {

// }
