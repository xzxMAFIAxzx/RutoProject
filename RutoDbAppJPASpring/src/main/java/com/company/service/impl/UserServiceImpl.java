package com.company.service.impl;


import at.favre.lib.crypto.bcrypt.BCrypt;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {


    @Autowired
    private UserRepositoryCustom userRepository;

    @Override
    public List<User> getUserSimple(String name, String surname, String email, String adress, String phone, Integer nationality)  {
       return userRepository.getUserSimple(name, surname, email, adress, phone, nationality);
    }

    @Override
    public List<User> getAll(String name, String surname, String phone, String email, String adress, String profilDesc, Integer nationality, Integer birthplace, Date birthDate) {

        return userRepository.getAll(name,surname,phone,email,adress,profilDesc,nationality,birthplace,birthDate);
    }
    @Override
    public User getById(int userId) {
        return userRepository.getById(userId);
    }

    @Override

    public boolean updateUser(User u) {
        return userRepository.updateUser(u);
    }

    private static  BCrypt.Hasher crypte = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        return userRepository.addUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userRepository.removeUser(id);
    }

    @Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Override
    public User findByNameAndSurname(String name, String surname) {
      return userRepository.findByNameAndSurname(name, surname);
    }


}








