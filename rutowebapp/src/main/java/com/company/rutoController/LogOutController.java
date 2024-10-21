//package com.company.rutoController;
//
//import dao.inter.UserDaoInter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import main.Context;
//
//import java.io.IOException;
//
//@WebServlet(name = "LogOutController", urlPatterns = {"/logout"})
//public class LogOutController extends HttpServlet {
//    private UserDaoInter userDao = Context.instanceUserDao();
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        request.getRequestDispatcher("login.jsp").forward(request, response);
//    }
//
//}
