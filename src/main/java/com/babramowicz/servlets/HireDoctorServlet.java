package com.babramowicz.servlets;

import com.babramowicz.dao.HireRepositoryDao;
import com.babramowicz.entities.HospitalDoctors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/hiredoctor")
public class HireDoctorServlet extends HttpServlet {

    @EJB
    HireRepositoryDao hiredDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String idH = req.getParameter("idH");
        String idD = req.getParameter("idD");
        String contractStartDate = req.getParameter("contractStartDate");
        String contractEndDate = req.getParameter("contractEndDate");
        String position = req.getParameter("position");
        String supervisor = req.getParameter("supervisor");
        String partTime = req.getParameter("partTime");

        HospitalDoctors hospitalDoctor = new HospitalDoctors(Integer.parseInt(idH), Integer.parseInt(idD), LocalDate.parse(contractStartDate), LocalDate.parse(contractEndDate), position, Boolean.valueOf(supervisor), Boolean.valueOf(partTime));
        hiredDao.hireDoctor(hospitalDoctor);
        resp.sendRedirect("hiredlist");
        req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
    }
}
