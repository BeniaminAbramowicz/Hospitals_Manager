<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Wyświetlanie zatrudnonych lekarzy">
  	<meta name="keywords" content="zatrudnieni lekarze, lista, wyświetlanie">
    <meta name="author" content="BA">
  	<meta http-equiv="X-Ua-Compatible" content="IE=edge">

    <title>Lista zatrudnionych lekarzy</title>


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
                <th scope="col">Nazwa szpitala</th>
                <th scope="col">Numer licencji lekarza</th>
                <th scope="col">Data podpisania kontraktu</th>
                <th scope="col">Data wygaśnięcia kontraktu</th>
                <th scope="col">Stanowisko</th>
                <th scope="col">Posiada przełożonego</th>
                <th scope="col">Na pół etatu</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hospitaldoctor" items="${hiredList}">
                <tr>
                    <td>${hospitaldoctor.hospital}</td>
                    <td>${hospitaldoctor.doctor}</td>
                    <td>${hospitaldoctor.contractStartDate}</td>
                    <td>${hospitaldoctor.contractEndDate}</td>
                    <td>${hospitaldoctor.position}</td>
                    <td>
                    <c:choose>
                       <c:when test="${hospitaldoctor.supervisor == true}">
                          Tak
                       </c:when>
                       <c:otherwise>
                           Nie
                       </c:otherwise>
                       </c:choose></td>
                    <td>
                    <c:choose>
                       <c:when test="${hospitaldoctor.partTime == true}">
                        Tak
                       </c:when>
                       <c:otherwise>
                        Nie
                       </c:otherwise>
                     </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>

<footer class="container-fluid w-100 py-2 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">Zarządzanie szpitalami</p>
        </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>