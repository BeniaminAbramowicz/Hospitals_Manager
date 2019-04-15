package com.babramowicz.servlets;

import com.babramowicz.dao.HospitalsRepositoryDao;
import com.babramowicz.entities.Hospitals;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/addhospital")
public class AddHospitalServlet extends HttpServlet {



    @EJB
    HospitalsRepositoryDao hospitalsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String town = req.getParameter("town");
        String street = req.getParameter("street");
        String postalCode = req.getParameter("postalCode");
        String phoneNumber = req.getParameter("phoneNumber");
        String faxNumber = req.getParameter("faxNumber");
        String numberOfAmbulances = req.getParameter("numberOfAmbulances");
        String helicopterAccess = req.getParameter("helicopterAccess");
        String teachingHospital = req.getParameter("teachingHospital");


        Hospitals hospitalTemp = hospitalsDao.getHospitalByName(name);

        Pattern p = Pattern.compile("[0-9]{2}-[0-9]{3}");
        Matcher m = p.matcher(postalCode);
        Boolean i = m.matches();

        if (name.length() > 100 || name == null) {
            req.setAttribute("errorname", "Nazwa szpitala może mieć maksymalnie 100 znaków nie może być pusta");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (country.length() > 30 || country == null) {
            req.setAttribute("errorcountry", "Nazwa państwa może mieć maksymalnie 30 znaków i nie może być pusta");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (town.length() > 50 || town == null) {
            req.setAttribute("errortown", "Nazwa miasta może mieć maksymalnie 50 znaków i nie może być pusta");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (street.length() > 80 || street == null) {
            req.setAttribute("errorstreet", "Nazwa ulicy może mieć maksymalnie 80 znaków i nie może być pusta");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (!i || postalCode.length() != 6 || postalCode == null) {
            req.setAttribute("errorpostalcode", "Kod pocztowy musi mieć dokładnie 6 cyfr w formacie 00-000 i nie może być pusty");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(phoneNumber) == false || phoneNumber.length() != 9 || phoneNumber == null) {
            req.setAttribute("errorphonenumber", "Numer telefonu musi zawierać dokładnie 9 cyfr i nie być pusty");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(faxNumber) == false || faxNumber.length() != 9 || faxNumber == null) {
            req.setAttribute("errorfaxnumber", "Numer faksu musi zawierać dokładnie 9 cyfr i nie być pusty");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (numberOfAmbulances == null) {
            req.setAttribute("errornumberofambulances", "Liczba karetek nie może być pusta");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (helicopterAccess == null) {
            req.setAttribute("errorhelicopteraccess", "Należy zaznaczyć jedną z opcji dla dostępu do helikopterów");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (teachingHospital == null) {
            req.setAttribute("errorteachinghospital", "Należy zaznaczyć jedną z opcji dla szpitala prowadzącego praktyki");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else if (hospitalTemp != null) {
            req.setAttribute("errorhospitalexists", "Szpital o tej nazwie już istnieje");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);
        } else {
            Hospitals hospital = new Hospitals(name, country, town, street, postalCode, phoneNumber, faxNumber, Integer.parseInt(numberOfAmbulances), Boolean.valueOf(helicopterAccess), Boolean.valueOf(teachingHospital));
            hospitalsDao.addNewHospital(hospital);
            resp.sendRedirect("hospitals");
            req.getRequestDispatcher("addhospital.jsp").forward(req, resp);

        }


    }
}
