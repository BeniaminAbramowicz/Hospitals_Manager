<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">

  <!-- Head -->
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Dodawanie szpitali">
  	<meta name="keywords" content="szpital, dodawanie">
    <meta name="author" content="BA">
  	<meta http-equiv="X-Ua-Compatible" content="IE=edge">

    <title>Dodawanie szpitala</title>

    <!-- Styles -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
	  <script type="text/javascript">
	  window.onload = function(){
      var a = document.getElementById("inputname").value;
      var b = document.getElementById("inputsurname").value;
      var c = document.getElementById("inputtitle").value;
      var d = document.getElementById("inputlicensenumber").value;
      var e = document.getElementById("inputphone").value;
      var f = document.getElementById("inputemail").value;
      var g = document.getElementById("inputnationality").value;
      var h = document.getElementById("inputspeciality").value;
      var i = document.getElementById("inputdateofbirth").value;
      if(a == "null"){
            document.getElementById("inputname").value = "";
      }
      if(b == "null"){
            document.getElementById("inputsurname").value = "";
      }
      if(c == "null"){
            document.getElementById("inputtitle").value = "";
      }
      if(d == "null"){
            document.getElementById("inputlicensenumber").value = "";
      }
      if(e == "null"){
            document.getElementById("inputphone").value = "";
      }
      if(f == "null"){
            document.getElementById("inputemail").value = "";
      }
      if(g == "null"){
            document.getElementById("inputnationality").value = "";
      }
      if(h == "null"){
            document.getElementById("inputspeciality").value = "";
      }
      if(i == "null"){
            document.getElementById("inputdateofbirth").value = "";
      }
      }
      </script>
  </head>

  <body>
  <wrapper class="d-flex flex-column">

    <!-- Navbar -->
        <%@include file="incl/nav.app"%>

    <!-- Content -->
    <main class="container-fluid py-3 flex-fill">
      <div class="container">


<div class="col-md-8 offset-2">
<div class="card border-primary">
<h4 class="card-header">Dodaj nowy szpital</h4>
<div class="card-body">
    <form action="adddoctor" method="post" id="add">
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

                    <% String name =  request.getParameter("name");
                       String surname =  request.getParameter("surname");
                       String title =  request.getParameter("title");
                       String licenseNumber =  request.getParameter("licenseNumber");
                       String phone =  request.getParameter("phone");
                       String email =  request.getParameter("email");
                       String nationality =  request.getParameter("nationality");
                       String speciality =  request.getParameter("speciality");
                       String dateOfBirth =  request.getParameter("dateOfBirth");
                     %>
        <div class="form-group">
            <label for="inputname">Imię lekarza</label>
            <input type="text" name="name" value="<%= name %>" class="form-control" id="inputname" placeholder="Imię" required>

		</div>
		<div class="form-group">
			<label for="inputsurname">Nazwisko lekarza</label>
			<input type="text" name="surname" value="<%= surname %>" class="form-control" id="inputsurname" placeholder="Nazwisko" required>
		</div>
		<div class="form-group">
			<label for="inputtitle">Tytuł</label>
			<input type="text" name="title" value="<%= title %>" class="form-control" id="inputtitle" placeholder="Tytuł" required>
        </div>
		<div class="form-group">
			<label for="inputlicensenumber">Numer licencji</label>
			<input type="text" name="licenseNumber" value="<%= licenseNumber %>" class="form-control" id="inputlicensenumber" placeholder="Numer licencji" required>
        </div>
		<div class="form-group">
			<label for="inputphone">Telefon</label>
			<input type="text" name="phone" value="<%= phone %>" max="6" class="form-control" id="inputphone" placeholder="Numer telefon" required>
        </div>
		<div class="form-group">
			<label for="inputemail">Adres e-mail</label>
			<input type="text" name="email" value="<%= email %>"class="form-control" id="inputemail" placeholder="Adres e-mail" required>
        </div>
		<div class="form-group">
			<label for="inputnationality">Narodowość</label>
			<input type="text" name="nationality" value="<%= nationality %>" class="form-control" id="inputnationality" placeholder="Narodowość">
        </div>
		<div class="form-group">
			<label for="inputspeciality">Specjalizacja</label>
			<input type="text" name="speciality" value="<%= speciality %>" class="form-control" id="inputspeciality" placeholder="Specjalizacja" required>
        </div>
        <div class="form-group">
        	<label for="inputdateofbirth">Specjalizacja</label>
        	<input type="date" name="dateOfBirth" value="<%= dateOfBirth %>" class="form-control" id="inputdateofbirth" placeholder="Specjalizacja" required>
        </div>

		<div class="form-group form-check-inline">
			<label for="inputisateacher">Nauczyciel</label>&nbsp
			<input type="radio" name="isATeacher" value="true" class="form-check-input" autocomplete="off" required>Tak
			&nbsp
			<input type="radio" name="isATeacher" value="false" class="form-check-input" autocomplete="off" required>Nie
        </div>

		<div class="mb-3">
		<br>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Dodaj Lekarza</button>
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
