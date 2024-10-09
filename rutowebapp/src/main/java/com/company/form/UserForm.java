package com.company.form;

import java.sql.Date;

public class UserForm {
    private String name;
    private String surname;
    private String phone;
    private String email;
    public String  profileDesc;
    private String adress;
    private String password;
    private Date birthDate;
    private Integer nationalityId;
    private Integer birthplaceId;

    public UserForm() {
    }

    public UserForm(String name, String surname, String phone, String email, String profileDesc, String adress, String password, Date birthDate, Integer nationalityId, Integer birthplaceId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.profileDesc = profileDesc;
        this.adress = adress;
        this.password = password;
        this.birthDate = birthDate;
        this.nationalityId = nationalityId;
        this.birthplaceId = birthplaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public String getAdress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Integer getBirthplace() {
        return birthplaceId;
    }

    public void setBirthplaceId(Integer birthplaceId) {
        this.birthplaceId = birthplaceId;
    }
}
