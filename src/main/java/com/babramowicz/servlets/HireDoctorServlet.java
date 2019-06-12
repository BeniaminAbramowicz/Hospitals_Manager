package com.babramowicz.servlets;

import com.babramowicz.dao.DoctorsRepositoryDao;
import com.babramowicz.dao.HireRepositoryDao;
import com.babramowicz.dao.HospitalsRepositoryDao;
import com.babramowicz.entities.Doctor;
import com.babramowicz.entities.HospitalDoctors;
import com.babramowicz.entities.Hospital;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/hiredoctor")
public class HireDoctorServlet extends HttpServlet {

    @EJB
    HireRepositoryDao hiredDao;

    @EJB
    HospitalsRepositoryDao hospitalDao;

    @EJB
    DoctorsRepositoryDao doctorDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String idHospital = req.getParameter("idHospital");
        String idDoctor = req.getParameter("idDoctor");
        String contractStartDate = req.getParameter("contractStartDate");
        String contractEndDate = req.getParameter("contractEndDate");
        String position = req.getParameter("position");
        String supervisor = req.getParameter("supervisor");
        String partTime = req.getParameter("partTime");

        List<Hospital> tempListHos;
        tempListHos = hospitalDao.getHospitalsList();
        int cnt = 0;
        for (int counter = 0; counter < tempListHos.size(); counter++) {
            if(tempListHos.get(counter).getId() == Integer.parseInt(idHospital)){
                cnt++;
            }
        }
        List<Doctor> tempListDoc;
        tempListDoc = doctorDao.getDoctorsList();
        int cnt2 = 0;
        for (int counter = 0; counter < tempListDoc.size(); counter++) {
            if(tempListDoc.get(counter).getId() == Integer.parseInt(idDoctor)){
                cnt2++;
            }
        }
        if(cnt == 0){
            req.setAttribute("errorhospitalnotexists", "Szpital o tym identyfikatorze nie istnieje");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if(cnt2 == 0){

        }

        HospitalDoctors hospitalDoctorsTemp = hiredDao.getHiredByIds(Integer.parseInt(idHospital), Integer.parseInt(idDoctor));

        Hospital hospital = hospitalDao.getHospitalById(Integer.parseInt(idHospital));
        Doctor doctor = doctorDao.getDoctorById(Integer.parseInt(idDoctor));

        LocalDate today = LocalDate.now();
        LocalDate start = LocalDate.parse(contractStartDate);
        LocalDate end = LocalDate.parse(contractEndDate);

        if (hospital == null){
            req.setAttribute("errorhospitalnotexists", "Szpital o tym identyfikatorze nie istnieje");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if(doctor == null){
            req.setAttribute("errordoctornotexists", "Lekarz o tym identyfikatorze nie istnieje");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(idHospital) == false || idHospital == null){
            req.setAttribute("erroridhospital", "Identyfikator szpitala musi być liczbą i nie może byc pusty");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(idDoctor) == false || idDoctor == null){
            req.setAttribute("erroriddoctor", "Identyfikator lekarza musi być liczbą i nie może byc pusty");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (start.compareTo(today) < 0 || contractStartDate == null){
            req.setAttribute("errorstartdate", "Data zawarcia kontraktu nie może być wcześniejsza niż data obecna i nie może być pusta");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (end.compareTo(today) < 0 || contractStartDate == null){
            req.setAttribute("errorenddate", "Data zakończenia kontraktu nie może być wcześniejsza niż data obecna i nie może być pusta");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (contractStartDate.compareTo(contractEndDate) > 0){
            req.setAttribute("errorswitchdate", "Data zakończenia kontraktu nie może być wcześniejsza niż data zawarcia kontraktu");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (position.length() > 20 || position == null ){
            req.setAttribute("errorposition", "Pozycja może mieć maksymalnie 20 znaków i nie może być pusta");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (supervisor == null){
            req.setAttribute("errorsupervisor", "Należy zaznaczyć jedną z opcji dla 'Posiada przełożonego' ");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if (partTime == null){
            req.setAttribute("errorparttime", "Należy zaznaczyć jedną z opcji dla 'Na pół etatu' ");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else if(hospitalDoctorsTemp != null) {
            req.setAttribute("errordoctorexists", "W tym szpitalu już zatrudniono podanego lekarza ");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        } else {
            HospitalDoctors hospitalDoctor = new HospitalDoctors(hospital, doctor, LocalDate.parse(contractStartDate), LocalDate.parse(contractEndDate), position, Boolean.valueOf(supervisor), Boolean.valueOf(partTime));
            hiredDao.hireDoctor(hospitalDoctor);
            resp.sendRedirect("hiredoctor");
            req.getRequestDispatcher("hiredoctor.jsp").forward(req, resp);
        }
    }
}
