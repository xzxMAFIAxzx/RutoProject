package com.company.dao.impl;


import com.company.entity.User;

import java.sql.Date;
import java.util.List;

public interface UserRepositoryCustom {
    public List<User> getUserSimple(String name,String surname ,String email , String adress, String phone ,Integer nationalityId);
    public List<User> getAll(String name, String surname, String phone, String email, String adress, String profilDesc , Integer nationalityId, Integer birthplaceId, Date birthDate);
    public User findByNameAndSurname(String name, String surname);
    public User findByPhone(String phone);
    public User getById(int id);
    public boolean updateUser (User u);
    public boolean addUser (User u);
    public boolean removeUser(int id);
}


