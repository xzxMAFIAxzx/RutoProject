//package com.company.rutoController;
//
//import com.company.dao.impl.CountryDaoImpl;
//import com.company.dao.inter.CountryDaoInter;
//import com.company.service.impl.UserServiceImpl;
//import com.company.service.inter.UserServiceInter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//
//
//
//@WebServlet(name = "UserDetailController", value = "/userdetail")
//public class UserDetailController extends HttpServlet {
//    private UserServiceInter userDao = new UserServiceImpl();
//    private CountryDaoInter countryDao = new CountryDaoImpl();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if(action.equals("back")){
//            response.sendRedirect("mainpage");
//        }
//        int id = Integer.valueOf(request.getParameter("id"));
//
//
//        if (action.equals("update")) {
//
//            String name = request.getParameter("name");
//            String surname = request.getParameter("surname");
//            String email = request.getParameter("email");
//            String adress = request.getParameter("adress");
//            String phone = request.getParameter("phone");
//            String birthdate = request.getParameter("birthdate");
//
//
//            sdf.format(Date.valueOf(birthdate));
//
//            System.out.println("User=  " + name + " " + surname + " " + email + " " + adress + " " + phone + " " + birthdate);
//
//            User user = userDao.getById(id);
//            user.setName(name);
//            user.setSurname(surname);
//            user.setEmail(email);
//            user.setAdress(adress);
//            user.setPhone(phone);
//            user.setBirthDate(Date.valueOf(birthdate));
//
//            userDao.updateUser(user);
//
//        } else if (action.equals("delete")) {
//            userDao.removeUser(id);
//        }
//
//        response.sendRedirect("mainpage");
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            String userIdStr = request.getParameter("id");
//            if (userIdStr == null || userIdStr.trim().isEmpty()) {
//                throw new IllegalArgumentException("id is not specified");
//            }
//
//            Integer userId = Integer.parseInt(userIdStr);
//
//
//            User u = userDao.getById(userId);
//            if (u == null) {
//                throw new IllegalArgumentException("There is no user with this id");
//            }
//
//            request.setAttribute("owner", true);
//            request.setAttribute("user", u);
//            request.getRequestDispatcher("userdetail.jsp").forward(request, response);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            response.sendRedirect("error?msg=" + ex.getMessage());
//        }
//
//    }
//}
