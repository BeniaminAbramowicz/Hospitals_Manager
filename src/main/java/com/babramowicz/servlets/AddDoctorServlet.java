package com.babramowicz.servlets;

import com.babramowicz.dao.DoctorsRepositoryDao;
import com.babramowicz.entities.Doctors;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        LocalDate docyear = LocalDate.now().minusYears(25);

        Doctors doctor = new Doctors(name, surname, title, licenseNumber, phone, email, nationality, speciality, LocalDate.parse(dateOfBirth), Boolean.valueOf(isATeacher));

        Doctors doctorTemp = doctorsDao.getDoctorByLicenseNumber(licenseNumber);

        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$");
        Matcher m = p.matcher(doctor.getEmail());
        Boolean i = m.matches();

        if (doctor.getName().length() > 30 || doctor.getName() == null) {
            req.setAttribute("errorname", "Imię może mieć maksymalnie 30 znaków nie może być puste");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctor.getSurname().length() > 40 || doctor.getSurname() == null) {
            req.setAttribute("errorsurname", "Nazwisko może mieć maksymalnie 40 znaków i nie może być puste");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctor.getTitle().length() > 100 || doctor.getTitle() == null) {
            req.setAttribute("errortitle", "Nazwa tytułu może mieć maksymalnie 100 znaków i nie może być pusta");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(licenseNumber) == false || doctor.getLicenseNumber().length() != 5 || doctor.getLicenseNumber() == null) {
            req.setAttribute("errorlicensenumber", "Numer licencji musi mieć dokładnie 5 cyfr i nie może być pusta");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(phone) == false || phone.length() != 9 || doctor.getPhone() == null) {
            req.setAttribute("errorphone", "Numer telefonu musi mieć dokładnie 9 cyfr i nie może być pusty");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctor.getEmail().length() > 50 || doctor.getEmail() == null) {
            req.setAttribute("erroremail", "Email może zawierać maksymalnie 50 znaków w formacie xxxx@xxxx.xx i nie może być pusty");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctor.getNationality().length() > 30 || doctor.getNationality() == null) {
            req.setAttribute("errornationality", "Narodowość może zawierać maksymalnie 30 znaków i nie może być pusta");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctor.getSpeciality().length() > 30 || doctor.getSpeciality() == null) {
            req.setAttribute("errorspeciality", "Specjalizacja może zawierać maksymalnie 30 znaków nie może być pusta");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctor.getDateOfBirth().compareTo(docyear) > 0 || doctor.getDateOfBirth() == null ) {
            req.setAttribute("errordateofbirth", "Data urodzenia nie może wskazywać na wiek mniejszy od 25 i nie może być pusta");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctor.getIsATeacher() == null) {
            req.setAttribute("errorisateacher", "Należy zaznaczyć jedną z opcji dla nauczyciela");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else if (doctorTemp != null) {
            req.setAttribute("errordoctorexists", "Lekarz o tym numerze licencji już istnieje");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        } else {
            doctorsDao.addNewDoctor(doctor);
            resp.sendRedirect("doctors");
            req.getRequestDispatcher("adddoctor.jsp").forward(req, resp);
        }

    }
}

