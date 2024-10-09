package com.company.dao.impl;


import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

import static javax.management.remote.JMXConnectorFactory.connect;

@Repository
public class SkillDaoImpl implements SkillDaoInter {
    @PersistenceContext
    EntityManager em;

    private Skill getSkill(ResultSet rs) throws Exception {
        int skillId = rs.getInt("id");
        String name = rs.getString("name");

        return new Skill(skillId, name);
    }

    @Override
    public List<Skill> getAllSkill(String id,String name) {

        String jpql = "select s.id as id, s.name from Skill s where  1=1";

        if (id != null && !id.trim().isEmpty()) {
            jpql += "and s.id= :id ";
        }
        if (name != null && !name.trim().isEmpty()) {
            jpql += "and s.name= :name  ";
        }


        Query query = em.createQuery(jpql, User.class);

        if (id != null && !id.trim().isEmpty()) {
            query.setParameter("id", id);
        }
        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        return query.getResultList();
    }

    @Override
    public Skill getById(int id) {
        Skill s = em.find(Skill.class, id);
        return s;
    }

    @Override
    public boolean updateSkill(Skill s) {
        em.merge(s);
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        Skill s = em.find(Skill.class, id);
        em.remove(s);
        return true;
    }

    @Override
    public List<Skill> getByName(String name) {

        String jpql = "select s. from Skill s where  1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += "and s.name= :name ";
        }

        Query query = em.createQuery(jpql, Skill.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        return query.getResultList();
    }

    @Override
    public boolean insertSkill(Skill skl) {
        em.persist(skl);
        return true;
    }
}
