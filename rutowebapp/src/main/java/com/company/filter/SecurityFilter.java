//package com.company.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//@WebFilter(filterName = "SecurityFilter", urlPatterns = {"*"})
//public class SecurityFilter implements Filter {
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  {
//        try {
//            HttpServletRequest req = (HttpServletRequest) request;
//            HttpServletResponse res = (HttpServletResponse) response;
//
//            if (!req.getRequestURI().contains("/login") && req.getSession().getAttribute("loggedInUser") == null) {
//                res.sendRedirect("login");
//            } else {
//                chain.doFilter(request, response);
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }
//}
//
