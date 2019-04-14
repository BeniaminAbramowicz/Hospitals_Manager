package com.babramowicz.servlets;

import com.babramowicz.dao.DoctorsRepositoryDao;
import com.babramowicz.entities.Doctors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/adddoctor")
public class AddDoctorServlet extends HttpServlet {

    @EJB
    DoctorsRepositoryDao doctorsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String title = req.getParameter("title");
        String licenseNumber = req.getParameter("licenseNumber");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String nationality = req.getParameter("nationality");
        String speciality = req.getParameter("speciality");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String isATeacher = req.getParameter("isATeacher");

        Doctors doctor = new Doctors(name, surname, title, licenseNumber, phone, email, nationality, speciality, LocalDate.parse(dateOfBirth), Boolean.valueOf(isATeacher));

        doctorsDao.addNewDoctor(doctor);
        req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        resp.sendRedirect("doctors");
    }
}

