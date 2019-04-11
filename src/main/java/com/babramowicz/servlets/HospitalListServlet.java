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

@WebServlet("/hospitals")
public class HospitalListServlet extends HttpServlet {

    @EJB
    HospitalsRepositoryDao hospitalsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        List<Hospitals> hospitalsList = hospitalsDao.getHospitalsList();
        req.setAttribute("hospitalsList", hospitalsList);
        req.getRequestDispatcher("hospitals.jsp").forward(req, resp);


    }
}
