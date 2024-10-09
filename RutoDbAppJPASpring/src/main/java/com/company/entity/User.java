package com.company.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findByPhone",query = "select u from User u where u.phone = :phone")
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "email", nullable = false, length = 90)
    private String email;

    @Column(name = "phone", length = 15)
    private String phone;

    @Lob
    @Column(name = "profile_description",columnDefinition = "TEXT")
    private String profileDesc;

    @Column(name = "adress", length = 200)
    private String adress;

    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
//    private List<UserSkill> userSkillList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "birthplace_id",referencedColumnName = "id")
    private Country birthplace ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationality_id",referencedColumnName = "id")
    private Country nationality ;

    @Column(name = "password", nullable = false, length = 200)
    private String password;


    public User() {

    }

    public User(Integer id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String phone, String email, String adress, String profileDesc, Date birthDate, Country nationality, Country birthplace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.birthplace = birthplace;
        this.profileDesc = profileDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<UserSkill> getUserSkillList() {
//        return userSkillList;
//    }
//
//    public void setUserSkillList(List<UserSkill> userSkillList) {
//        this.userSkillList = userSkillList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(phone, user.phone) && Objects.equals(profileDesc, user.profileDesc) && Objects.equals(adress, user.adress) && Objects.equals(birthDate, user.birthDate) &&  Objects.equals(birthplace, user.birthplace) && Objects.equals(nationality, user.nationality) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, phone, profileDesc, adress, birthDate, birthplace, nationality, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", profileDesc='" + profileDesc + '\'' +
                ", adress='" + adress + '\'' +
                ", birthDate=" + birthDate +
//                ", userSkillList=" + userSkillList +
                ", birthplace=" + birthplace +
                ", nationality=" + nationality +
                ", password='" + password + '\'' +
                '}';
    }
}