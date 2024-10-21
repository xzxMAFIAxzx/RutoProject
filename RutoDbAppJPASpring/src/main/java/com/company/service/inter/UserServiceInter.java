package com.company.service.inter;

import com.company.entity.User;

import java.util.Date;
import java.util.List;

public interface UserServiceInter  {
    public List<User> getUserSimple(String name, String surname, String email, String adress, String phone, Integer nationality);
    public List<User> getAll(String name, String surname, String phone, String email, String adress, String profilDesc , Integer nationality, Integer birthplace, Date birthDate);
    public User findByNameAndSurname(String name, String surname);
    public User findByPhone(String phone);
    public User getById(int id);
    public boolean updateUser (User u);
    public boolean addUser (User u);
    public boolean removeUser(int id);

}
