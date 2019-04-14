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
import java.util.List;

@WebServlet("/doctors")
public class DoctorListServlet extends HttpServlet {

    @EJB
    DoctorsRepositoryDao doctorsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<Doctors> doctorsList = doctorsDao.getDoctorsList();
        req.setAttribute("doctorsList", doctorsList);
        req.getRequestDispatcher("doctors.jsp").forward(req, resp);
    }
}
