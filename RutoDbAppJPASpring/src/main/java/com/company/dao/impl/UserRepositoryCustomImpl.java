package com.company.dao.impl;


import at.favre.lib.crypto.bcrypt.BCrypt;


import com.company.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;


@Repository
@Transactional
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Override
    public List <User> getUserSimple(String name, String surname, String email, String adress, String phone, Integer nationalityId) {
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname  ";
        }
        if (email != null && !email.trim().isEmpty()) {
            jpql += " and u.email=:email ";
        }
        if (adress != null && !adress.trim().isEmpty()) {
            jpql += " and u.adress=:adress  ";
        }
        if (phone != null && !phone.trim().isEmpty()) {
            jpql += " and u.phone=:phone  ";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality.id=:nid";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (email != null && !email.trim().isEmpty()) {
            query.setParameter("email", email);
        }
        if (adress != null && !adress.trim().isEmpty()) {
            query.setParameter("adress", adress);
        }
        if (phone != null && !phone.trim().isEmpty()) {
            query.setParameter("phone", phone);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }


        return query.getResultList();
    }


    @Override
    @Cacheable(value = "users")
    public List<User> getAll(String name, String surname, String phone, String email, String adress, String profilDesc, Integer nationalityId, Integer birthplaceId, Date birthDate) {
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname  ";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality.id=:nid ";
        }


        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }

        return query.getResultList();
    }

    @Override
    @Cacheable(value = "users")
    public User getById(int userId) {
        User u = em.find(User.class, userId);
        return u;
    }

    @Override
    @Transactional
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    private static  BCrypt.Hasher crypte = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypte.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }

    @Override
//    @CacheEvict(value = "users", allEntries = true)
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    @Override
    public User findByPhone(String phone) {
        Query query=em.createNamedQuery("User.findByPhone", User.class);
        query.setParameter("phone", phone);

        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public User findByNameAndSurname(String name, String surname) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q1 = cb.createQuery(User.class);
        Root<User> postRoot = q1.from(User.class);
        CriteriaQuery<User> q2 = q1
                .where(cb.equal(postRoot.get("name"), name), cb.equal(postRoot.get("surname"), surname));

        Query query = em.createQuery(q2);

        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }


}








