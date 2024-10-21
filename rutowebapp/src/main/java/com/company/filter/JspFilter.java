//package com.company.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "JSPFileFilter", urlPatterns = {"*.jsp"})
//public class  JspFilter implements Filter {
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
//        HttpServletResponse resp = (HttpServletResponse) response;
//        try {
//            resp.sendRedirect("error?msg=not found");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
