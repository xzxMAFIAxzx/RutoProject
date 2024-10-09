package com.company.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToMany( mappedBy = "nationality")
    private List<User> nationality ;

   @OneToMany( mappedBy = "birthplace")
    private List<User> birthplace;


    public Country() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country(List<User> birthplace, List<User> nationality, Integer id) {
        this.birthplace = birthplace;
        this.nationality = nationality;
        this.id = id;

    }

    public List<User> getNationality() {
        return nationality;
    }

    public void setNationality(List<User> nationality) {
        this.nationality = nationality;
    }

    public List<User> getBirthPlace() {
        return birthplace;
    }

    public void setBirthPlace(List<User> birthplace) {
        this.birthplace = birthplace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id)&& Objects.equals(nationality, country.birthplace) && Objects.equals(birthplace, country.birthplace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nationality, birthplace);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                 '\'' +
                ", nationality=" + nationality +
                ", birthplace=" + birthplace +
                '}';
    }
}