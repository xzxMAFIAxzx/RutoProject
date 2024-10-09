package com.company.service.impl;


import at.favre.lib.crypto.bcrypt.BCrypt;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {


    @Autowired
    private UserRepositoryCustom userRepository;

    @Override
    public List<User> getUserSimple(String name, String surname, String email, String adress, String phone, Integer nationalityId)  {
       return userRepository.getUserSimple(name, surname, email, adress, phone, nationalityId);
    }

    @Override
    public List<User> getAll(String name, String surname, String phone, String email, String adress, String profilDesc, Integer nationalityId, Integer birthplaceId, Date birthDate) {

        return userRepository.getAll(name,surname,phone,email,adress,profilDesc,nationalityId,birthplaceId,birthDate);
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








