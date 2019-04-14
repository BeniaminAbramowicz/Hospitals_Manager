package com.babramowicz.servlets;

import com.babramowicz.dao.DoctorsRepositoryDao;
import com.babramowicz.entities.Doctors;
import com.babramowicz.entities.Hospitals;
import org.apache.commons.lang3.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


@WebServlet("/editdoctor")
public class EditDoctorServlet extends HttpServlet {

    @EJB
    DoctorsRepositoryDao doctorsDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Doctors doctorById = doctorsDao.getDoctorById(Integer.parseInt(id));

        req.setAttribute("doctor", doctorById);

        req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
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

        Doctors doctorTemp = doctorsDao.getDoctorByLicenseNumber(licenseNumber);

        if (name.length() > 30 || name == null) {
            req.setAttribute("errorname", "Imię może mieć maksymalnie 30 znaków nie może być puste");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (surname.length() > 40 || surname == null) {
            req.setAttribute("errorsurname", "Nazwisko może mieć maksymalnie 40 znaków i nie może być puste");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (title.length() > 100 || title == null) {
            req.setAttribute("errortitle", "Nazwa tytułu może mieć maksymalnie 100 znaków i nie może być pusta");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(licenseNumber) == false || licenseNumber.length() != 5 || licenseNumber == null) {
            req.setAttribute("errorlicensenumber", "Numer licencji musi mieć dokładnie 5 cyfr i nie może być pusta");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (StringUtils.isNumeric(phone) == false || phone.length() != 9 || phone == null) {
            req.setAttribute("errorphone", "Numer telefonu musi mieć dokładnie 9 cyfr i nie może być pusty");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (email.length() > 50 || email == null) {
            req.setAttribute("erroremail", "Email może zawierać maksymalnie 50 znaków w formacie xxxx@xxxx.xx i nie może być pusty");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (nationality.length() > 30 || nationality == null) {
            req.setAttribute("errornationality", "Narodowość może zawierać maksymalnie 30 znaków i nie może być pusta");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (speciality.length() > 30 || speciality == null) {
            req.setAttribute("errorspeciality", "Specjalizacja może zawierać maksymalnie 30 znaków nie może być pusta");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (LocalDate.parse(dateOfBirth).compareTo(docyear) > 0 || dateOfBirth == null ) {
            req.setAttribute("errordateofbirth", "Data urodzenia nie może wskazywać na wiek mniejszy od 25 i nie może być pusta");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (isATeacher == null) {
            req.setAttribute("errorisateacher", "Należy zaznaczyć jedną z opcji dla nauczyciela");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else if (doctorTemp != null) {
            req.setAttribute("errordoctorexists", "Lekarz o tym numerze licencji już istnieje");
            req.getRequestDispatcher("editdoctor.jsp").forward(req, resp);
        } else {
            doctorsDao.updateDoctor(Integer.parseInt(id), name, surname, title, licenseNumber, phone, email,nationality, speciality, LocalDate.parse(dateOfBirth), Boolean.valueOf(isATeacher));
            resp.sendRedirect("doctors");
        }

    }
}
