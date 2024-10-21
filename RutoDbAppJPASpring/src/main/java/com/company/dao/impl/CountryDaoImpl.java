package com.company.dao.impl;


import com.company.dao.inter.CountryDaoInter;

import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CountryDaoImpl  implements CountryDaoInter {
    @PersistenceContext
    EntityManager em;


    @Override
    public Country getById(int countyrId) {
        Country c = em.find(Country.class, countyrId);
        return c;
    }

    @Override
    public List<Country> getAllCountry(String birthplace, String nationality) {


        String jpql = "select u from Country u where 1=1";


        if (nationality != null) {
            jpql += " and nationality = :nid  ";
        }
        if (birthplace != null) {
            jpql += " and  birthplace = :birt ";
        }

        Query query = em.createQuery(jpql, Country.class);


        if (birthplace != null) {
            query.setParameter("birt", birthplace);
        }
        if (nationality != null ) {
            query.setParameter("nid", nationality);
        }

        return query.getResultList();
    }

    @Override
    public boolean updateCountry(Country con) {
        em.merge(con);
        return true;

    }

    @Override
    public boolean removeCountry(int id) {
        Country c = em.find(Country.class, id);
        em.remove(c);
        return true;
    }
}

