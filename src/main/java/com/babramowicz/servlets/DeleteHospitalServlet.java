package com.babramowicz.servlets;

import com.babramowicz.dao.HospitalsRepositoryDao;
import com.babramowicz.entities.Hospitals;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deletehospital")
public class DeleteHospitalServlet extends HttpServlet {

    @EJB
    HospitalsRepositoryDao hospitalsDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");

        hospitalsDao.deleteHospitalById(Integer.parseInt(id));

        resp.sendRedirect("hospitals");
    }
}
