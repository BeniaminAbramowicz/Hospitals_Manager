<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Wyświetlanie listy lekarzy">
  	<meta name="keywords" content="lekarz, dodawanie">
    <meta name="author" content="BA">
  	<meta http-equiv="X-Ua-Compatible" content="IE=edge">

    <title>Lista lekarzy</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
</head>
<body>
<wrapper class="d-flex flex-column">

<%@include file="incl/nav.app"%>

<div class="container">
<table class="table table-responsive table-sm">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Surname</th>
                    <th scope="col">Title</th>
                    <th scope="col">License Number</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Email</th>
                    <th scope="col">Nationality</th>
                    <th scope="col">Speciality</th>
                    <th scope="col">Date of birth</th>
                    <th scope="col">Is a teacher</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="doctor" items="${doctorsList}">
                    <tr>
                        <td>${doctor.name}</td>
                        <td>${doctor.surname}</td>
                        <td>${doctor.title}</td>
                        <td>${doctor.licenseNumber}</td>
                        <td>${doctor.phone}</td>
                        <td>${doctor.email}</td>
                        <td>${doctor.nationality}</td>
                        <td>${doctor.speciality}</td>
                        <td>${doctor.dateOfBirth}</td>
                        <td>
                        <c:choose>
                           <c:when test="${doctor.isATeacher == true}">
                            YES
                           </c:when>
                           <c:otherwise>
                            NO
                           </c:otherwise>
                         </c:choose>
                        </td>
                        <td>
                         <form method="get" action="editdoctor">
                         <input type="hidden" name="id" value="${doctor.id}">
                         <button type="submit" class="btn btn-success">Edit</button>
                         </form>
                         </td>
                        <td>
                        <form method="post" action="deletedoctor">
                        <input type="hidden" name="id" value="${doctor.id}">
                        <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
</table>
</div>

<footer class="container-fluid w-100 py-2 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Hospitals Management</p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>