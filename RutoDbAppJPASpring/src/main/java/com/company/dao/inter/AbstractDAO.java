//package com.company.dao.inter;
//
//
//import com.company.entity.Country;
//import com.company.entity.EmploymentHistory;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.List;
//
//public abstract class AbstractDAO {
//    public Connection connect() throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:1320/ruto";
//        String username = "root";
//        String password = "12345";
//        Connection c = DriverManager.getConnection(url, username, password);
//        return c;
//    }
//    private static EntityManagerFactory emf = null;
//
//    public static EntityManagerFactory emfac(){
//        if(emf == null){
//            emf = Persistence.createEntityManagerFactory("rutodbapp");
//        }
//        return emf;
//    }
//
//    public static EntityManager em(){
//        return emfac().createEntityManager();
//    }
//    public static void closeEm(EntityManager em){
//        if(em != null && em.isOpen()){
//            em.close();
//
//        }
//    }
//
//    public void close(EntityManager em){
//            em.close();
//
//    }
//
//    public abstract Country getById(int countyrID);
//
//    public abstract List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);
//}
