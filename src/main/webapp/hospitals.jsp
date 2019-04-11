<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
 <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="Hospital">
        <meta name="keywords" content="hospital">
        <meta name="author" content="BA">
        <meta http-equiv="X-Ua-Compatible" content="IE=edge">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<div class="container">
<table class="table table-responsive table-sm">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Country</th>
                <th scope="col">Town</td>
                <th scope="col">Street</td>
                <th scope="col">Postal Code</td>
                <th scope="col">Phone Number</td>
                <th scope="col">Fax Number</td>
                <th scope="col">Number of ambulances</td>
                <th scope="col">Helicopter Access</td>
                <th scope="col">Teaching Hospital</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hospital" items="${hospitalsList}">
                <tr>
                    <td>${hospital.id}</td>
                    <td>${hospital.name}</td>
                    <td>${hospital.country}</td>
                    <td>${hospital.town}</td>
                    <td>${hospital.street}</td>
                    <td>${hospital.postalCode}</td>
                    <td>${hospital.phoneNumber}</td>
                    <td>${hospital.faxNumber}</td>
                    <td>${hospital.numberOfAmbulances}</td>
                    <td>
                    <c:choose>
                       <c:when test="${hospital.helicopterAccess == true}">
                        YES
                       </c:when>
                       <c:otherwise>
                        NO
                       </c:otherwise>
                     </c:choose>
                    </td>
                    <td>
                    <c:choose>
                        <c:when test="${hospital.helicopterAccess == true}">
                         YES
                        </c:when>
                        <c:otherwise>
                         NO
                        </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>