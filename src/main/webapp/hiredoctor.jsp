<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Zatudnienie lekarza">
  	<meta name="keywords" content="lekarz, zatrudnianie">
    <meta name="author" content="BA">
  	<meta http-equiv="X-Ua-Compatible" content="IE=edge">

<title>Zatrudnij lekarza</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
<script type="text/javascript">
          window.onload = function(){
          var a = document.getElementById("inputidh").value;
          var b = document.getElementById("inputidd").value;
          var c = document.getElementById("inputcontractstartdate").value;
          var d = document.getElementById("inputcontractenddate").value;
          var e = document.getElementById("inputposition").value;
          if(a == "null"){
                document.getElementById("inputidh").value = "";
          }
          if(b == "null"){
                document.getElementById("inputidd").value = "";
          }
          if(c == "null"){
                document.getElementById("inputcontractstartdate").value = "";
          }
          if(d == "null"){
                document.getElementById("inputcontractenddate").value = "";
          }
          if(e == "null"){
                document.getElementById("inputposition").value = "";
          }

          }
      </script>

</head>
<body>
<wrapper class="d-flex flex-column">

<%@include file="incl/nav.app"%>

<main class="container-fluid py-3 flex-fill">
<div class="container">
<div class="col-md-8 offset-2">
<div class="card border-danger rounded-0">
<h4 class="card-header bg-danger">Zatrudnij lekarza</h4>
<div class="card-body">
    <form action="hiredoctor" method="post" id="add">
            <p style="color:red">${errorhospitalnotexists}</p>
            <p style="color:red">${errordoctornotexists}</p>
            <p style="color:red">${erroridhospital}</p>
            <p style="color:red">${erroriddoctor}</p>
            <p style="color:red">${errorstartdate}</p>
            <p style="color:red">${errorenddate}</p>
            <p style="color:red">${errorswitchdate}</p>
            <p style="color:red">${errorposition}</p>
            <p style="color:red">${errorsupervisor}</p>
            <p style="color:red">${errorparttime}</p>
            <p style="color:red">${errordoctorexists}</p>

            <% String idHospital =  request.getParameter("idHospital");
               String idDoctor =  request.getParameter("idDoctor");
               String contractStartDate =  request.getParameter("contractStartDate");
               String contractEndDate =  request.getParameter("contractEndDate");
               String position =  request.getParameter("position");
            %>
        <div class="form-group">
            <label for="inputidh">Identyfikator szpitala</label>
            <input type="number" name="idHospital" value="<%= idHospital %>" class="form-control" id="inputidh" placeholder="Identyfikator szpitala" required>

		</div>
		<div class="form-group">
			<label for="inputidd">Identyfikator lekarza</label>
			<input type="number" name="idDoctor" value="<%= idDoctor %>"class="form-control" id="inputidd" placeholder="Identyfikator lekarza" required>
		</div>
		<div class="form-group">
			<label for="inputcontractstartdate">Data podpisania kontraktu</label>
			<input type="date" name="contractStartDate" value="<%= contractStartDate %>" class="form-control" id="inputcontractstartdate" placeholder="Data podpisania kontraktu" required>
        </div>
		<div class="form-group">
			<label for="inputcontractenddate">Data wygaśnięcia kontraktu</label>
			<input type="date" name="contractEndDate" value="<%= contractEndDate %>" class="form-control" id="inputcontractenddate" placeholder="Data wygaśnięcia kontraktu" required>
        </div>
		<div class="form-group">
			<label for="inputposition">Stanowisko</label>
			<input type="text" name="position" value="<%= position %>" class="form-control" id="inputposition" placeholder="Stanowisko" required>
        </div>
		<div class="form-group form-check-inline">
			<label for="inputsupervisor">Posiada przełożonego</label>&nbsp
			<input type="radio" name="supervisor" value="true" class="form-check-input" autocomplete="off" required>Tak
			&nbsp
			<input type="radio" name="supervisor" value="false" class="form-check-input" autocomplete="off" required>Nie
        </div>
        <br>
        <div class="form-group form-check-inline">
        	<label for="inputparttime">Na pół etatu</label>&nbsp
        	<input type="radio" name="partTime" value="true" class="form-check-input" autocomplete="off" required>Tak
        	&nbsp
        	<input type="radio" name="partTime" value="false" class="form-check-input" autocomplete="off" required>Nie
        </div>

		<div class="mb-3">
        <button class="btn btn-danger btn-lg btn-block" type="submit">Zatrudnij Lekarza</button>
		</div>

    </form>
</div>
</div>
</div>
</div>
</main>

<footer class="container-fluid w-100 py-2 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Zarządzanie szpitalami</p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</wrapper>
</body>
</html>