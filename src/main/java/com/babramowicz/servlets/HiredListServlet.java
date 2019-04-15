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
import java.util.List;

@WebServlet("/hiredlist")
public class HiredListServlet extends HttpServlet {

    @EJB
    HireRepositoryDao hiredDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<HospitalDoctors> hiredList = hiredDao.getHiredList();
        req.setAttribute("hiredList", hiredList);
        req.getRequestDispatcher("hiredlist.jsp").forward(req, resp);
    }
}
