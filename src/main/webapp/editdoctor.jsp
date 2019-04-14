<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Edycja lekarza">
  	<meta name="keywords" content="lekarz, edycja">
    <meta name="author" content="BA">
  	<meta http-equiv="X-Ua-Compatible" content="IE=edge">

    <title>Edycja lekarza</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
</head>
<body>
<wrapper class="d-flex flex-column">


<%@include file="incl/nav.app"%>

<main class="container-fluid py-3 flex-fill">
<div class="container">

<div class="col-md-8 offset-2">
<div class="card border-primary">
<h4 class="card-header">Edytuj szpital</h4>
<div class="card-body">
    <form action="editdoctor" method="post" id="add">
            <p style="color:red">${errorname}</p>
            <p style="color:red">${errorsurname}</p>
            <p style="color:red">${errortitle}</p>
            <p style="color:red">${errorlicensenumber}</p>
            <p style="color:red">${errorphone}</p>
            <p style="color:red">${erroremail}</p>
            <p style="color:red">${errornationality}</p>
            <p style="color:red">${errorspeciality}</p>
            <p style="color:red">${errordateofbirth}</p>
            <p style="color:red">${errorisateacher}</p>
            <p style="color:red">${errordoctorexists}</p>
    <input type="hidden" name="id" value="${doctor.id}">

        <div class="form-group">
            <label for="inputname">Imię</label><br>
            <input type="text" name="name" value="${doctor.name}" class="form-control" id="inputname" placeholder="Imię" required>

		</div>
		<div class="form-group">
			<label for="inputsurname">Nazwisko</label>
			<input type="text" name="surname" value="${doctor.surname}" class="form-control" id="inputsurname" placeholder="Kraj" required>
		</div>
		<div class="form-group">
			<label for="inputtitle">Tytuł</label>
			<input type="text" name="title" value="${doctor.title}" class="form-control" id="inputtitle" placeholder="Tytuł" required>
        </div>
		<div class="form-group">
			<label for="inputlicensenumber">Numer licencji</label>
			<input type="text" name="licenseNumber" value="${doctor.licensenumber}" class="form-control" id="inputlicensenumber" placeholder="Numer licencji" required>
        </div>
		<div class="form-group">
			<label for="inputphone">Telefon</label>
			<input type="text" name="phone" value="${doctor.phone}" class="form-control" id="inputphone" placeholder="Telefon" required>
        </div>

		<div class="form-group">
			<label for="inputemail">Adres e-mail</label>
			<input type="text" name="email" value="${doctor.email}" class="form-control" id="inputemail" placeholder="Adres e-mail" required>
        </div>
		<div class="form-group">
			<label for="inputnationality">Narodowość</label>
			<input type="text" name="nationality" value="${doctor.nationality}" class="form-control" id="inputnationality" placeholder="Narodowość" >
        </div>
		<div class="form-group">
			<label for="inputspeciality">Specjalizacja</label>
			<input type="text" name="speciality" value="${doctor.speciality}" class="form-control" id="inputspeciality" placeholder="Specjalizacja" required>
        </div>

		<div class="form-group">
            <label for="inputdateofbirth">Data urodzenia</label>
            <input type="date" name="dateOfBirth" value="${doctor.dateOfBirth}" class="form-control" id="inputdateofbirth" placeholder="Data urodzenia" required>
        </div>

		<div class="form-group form-check-inline">
			<label for="inputisateacher">Szpital prowadzący praktyki</label>&nbsp;
			<input type="radio" name="isATeacher" value="true" class="form-check-input"  <c:if test="${doctor.isATeacher == true}">checked</c:if>>Tak
			&nbsp
			<input type="radio" name="isATeacher" value="false" class="form-check-input" <c:if test="${doctor.isATeacher == false}">checked</c:if> >Nie
        </div>

		<div class="mb-3">
		<br>
        <button class="btn btn-primary btn-lg btn-block" id="editdoctor" type="submit">Edit Hospital</button>
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
