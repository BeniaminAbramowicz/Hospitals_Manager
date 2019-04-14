package com.babramowicz.servlets;

import com.babramowicz.dao.DoctorsRepositoryDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletedoctor")
public class DeleteDoctorServlet extends HttpServlet {

    @EJB
    DoctorsRepositoryDao doctorsDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");

        doctorsDao.deleteDoctorById(Integer.parseInt(id));

        resp.sendRedirect("doctors");
    }
}
