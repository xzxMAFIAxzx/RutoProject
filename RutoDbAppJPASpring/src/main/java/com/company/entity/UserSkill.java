package com.company.entity;


import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "user_skill")
public class UserSkill {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "power", nullable = false)
    private Integer power;

    public UserSkill() {
    }

    public UserSkill(Integer id, User user, Skill skill, Integer power) {
        this.id = id;
        this.user = user;
        this.skill = skill;
        this.power = power;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSkill userSkill = (UserSkill) o;
        return Objects.equals(id, userSkill.id) && Objects.equals(user, userSkill.user) && Objects.equals(skill, userSkill.skill) && Objects.equals(power, userSkill.power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, skill, power);
    }

    @Override
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                ", user=" + user +
                ", skill=" + skill +
                ", power=" + power +
                '}';
    }
}