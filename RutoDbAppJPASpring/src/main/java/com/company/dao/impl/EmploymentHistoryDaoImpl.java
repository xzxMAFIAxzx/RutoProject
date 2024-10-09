package com.company.dao.impl;


import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.List;


@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {
    @PersistenceContext
    EntityManager em;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        String header = rs.getString("header");
        String jobDescription = rs.getString("job_description");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        int userId = rs.getInt("user_id");
        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));

        return emp;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(String header, String beginDate, String endDate, String jobDescription) {


        String jpql = "select eh from EmploymentHistory eh where 1=1";

        if (header != null && !header.trim().isEmpty()) {
            jpql += "and eh.header=:header ";
        }
        if (beginDate != null && !beginDate.trim().isEmpty()) {
            jpql += "and eh.beginDate= :beginDate ";
        }
        if (endDate != null && !endDate.trim().isEmpty()) {
            jpql += "and eh.endDate = :endDate ";
        }
        if (jobDescription != null && !jobDescription.trim().isEmpty()) {
            jpql += "and eh.jobDescription = :jobDescription ";
        }
        if (jobDescription != null && !jobDescription.trim().isEmpty()) {
            jpql += "and eh.jobDescription = :jobDescription ";
        }

        Query query = em.createQuery(jpql, User.class);

        if (header != null && !header.trim().isEmpty()) {
            query.setParameter("header", header);
        }
        if (beginDate != null && !beginDate.trim().isEmpty()) {
            query.setParameter("beginDate", beginDate);
        }
        if (endDate != null && !endDate.trim().isEmpty()) {
            query.setParameter("endDate", endDate);
        }
        if (jobDescription != null && !jobDescription.trim().isEmpty()) {
            query.setParameter("jobDescription", jobDescription);
        }


        return query.getResultList();
    }

}


