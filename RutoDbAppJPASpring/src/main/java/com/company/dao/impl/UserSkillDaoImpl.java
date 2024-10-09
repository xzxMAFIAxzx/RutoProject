package com.company.dao.impl;

import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.UserSkill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class UserSkillDaoImpl implements UserSkillDaoInter {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserSkill>  getUserSkill (String skilId,String power){

        String jpql = "select s.id as id , s.power from UserSkill s where  1=1";

        if (skilId != null && !skilId.trim().isEmpty()) {
            jpql += "and s.id=:skilId ";
        }
        if (power != null && !power.trim().isEmpty()) {
            jpql += "and s.power= :power  ";
        }

        Query query = em.createQuery(jpql, UserSkill.class);

        if (skilId != null && !skilId.trim().isEmpty()) {
            query.setParameter("skilId", skilId);
        }
        if (power != null && !power.trim().isEmpty()) {
            query.setParameter("power", power);
        }

        return query.getResultList();
    }
    @Override
    public boolean insertUserSkill (UserSkill id){
        UserSkill uSkill = em.find(UserSkill.class, id);
        em.persist(uSkill);
        return true;

    }
    @Override
    public boolean updateUserSkill(UserSkill s) {
        em.merge(s);
        return true;
    }
    @Override
    public boolean removeUserSkill (int id){
       UserSkill uSkill=em.find(UserSkill.class,id);
       em.remove(uSkill);
       return true;
    }

}


