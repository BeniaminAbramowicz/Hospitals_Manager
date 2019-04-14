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

    <title>Hospitals Management</title>

    <!-- Styles -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	  <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
	  <script type="text/javascript">
	  document.addEventListener("DOMContentLoaded", function(){
      var a = document.getElementById("inputname").value;
      var b = document.getElementById("inputcountry").value;
      var c = document.getElementById("inputtown").value;
      var d = document.getElementById("inputstreet").value;
      var e = document.getElementById("inputpostalcode").value;
      var f = document.getElementById("inputphonenumber").value;
      var g = document.getElementById("inputfaxnumber").value;
      var h = document.getElementById("inputnumberofambulances").value;
      if(a == "null"){
            document.getElementById("inputname").value = "";
      }
      if(b == "null"){
            document.getElementById("inputcountry").value = "";
      }
      if(c == "null"){
            document.getElementById("inputtown").value = "";
      }
      if(d == "null"){
            document.getElementById("inputstreet").value = "";
      }
      if(e == "null"){
            document.getElementById("inputpostalcode").value = "";
      }
      if(f == "null"){
            document.getElementById("inputphonenumber").value = "";
      }
      if(g == "null"){
            document.getElementById("inputfaxnumber").value = "";
      }
      if(h == "null"){
            document.getElementById("inputnumberofambulances").value = "";
      }
      });
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
    <form action="addhospital" method="post" id="add">
                    <p style="color:red">${errorname}</p>
                    <p style="color:red">${errorcountry}</p>
                    <p style="color:red">${errortown}</p>
                    <p style="color:red">${errorstreet}</p>
                    <p style="color:red">${errorpostalcode}</p>
                    <p style="color:red">${errorphonenumber}</p>
                    <p style="color:red">${errorfaxnumber}</p>
                    <p style="color:red">${errornumberofambulances}</p>
                    <p style="color:red">${errorhelicopteraccess}</p>
                    <p style="color:red">${errorteachinghospital}</p>
                    <p style="color:red">${errorhospitalexists}</p>

                    <% String name =  request.getParameter("name");
                       String country =  request.getParameter("country");
                       String town =  request.getParameter("town");
                       String street =  request.getParameter("street");
                       String postalCode =  request.getParameter("postalCode");
                       String phoneNumber =  request.getParameter("phoneNumber");
                       String faxNumber =  request.getParameter("faxNumber");
                       String numberOfAmbulances =  request.getParameter("numberOfAmbulances");
                     %>
        <div class="form-group">
            <label for="inputname">Nazwa szpitala</label>
            <input type="text" name="name" value="<%= name %>" class="form-control" id="inputname" placeholder="Nazwa Szpitala" required>

		</div>
		<div class="form-group">
			<label for="inputcountry">Kraj</label>
			<input type="text" name="country" value="<%= country %>" class="form-control" id="inputcountry" placeholder="Kraj" required>
		</div>
		<div class="form-group">
			<label for="inputtown">Miasto</label>
			<input type="text" name="town" value="<%= town %>" class="form-control" id="inputtown" placeholder="Miasto" required>
        </div>
		<div class="form-group">
			<label for="inputstreet">Ulica</label>
			<input type="text" name="street" value="<%= street %>" class="form-control" id="inputstreet" placeholder="Ulica" required>
        </div>
		<div class="form-group">
			<label for="inputpostalcode">Kod pocztowy</label>
			<input type="text" name="postalCode" value="<%= postalCode %>" max="6" class="form-control" id="inputpostalcode" placeholder="Kod pocztowy" required>
        </div>
		<div class="form-group">
			<label for="inputphonenumber">Numer telefonu</label>
			<input type="text" name="phoneNumber" value="<%= phoneNumber %>"class="form-control" id="inputphonenumber" placeholder="Numer telefonu" required>
        </div>
		<div class="form-group">
			<label for="inputfaxnumber">Numer faksu</label>
			<input type="text" name="faxNumber" value="<%= faxNumber %>" class="form-control" id="inputfaxnumber" placeholder="Numer faksu">
        </div>
		<div class="form-group">
			<label for="inputnumberofambulances">Ilość karetek</label>
			<input type="number" name="numberOfAmbulances" value="<%= numberOfAmbulances %>" class="form-control" id="inputnumberofambulances" placeholder="Liczba karetek" required>
        </div>

		<div class="form-group form-check-inline">
			<label for="inputhelicopteraccess">Dostęp do helikoptera</label>&nbsp
			<input type="radio" name="helicopterAccess" value="true" class="form-check-input" autocomplete="off" required>Tak
			&nbsp
			<input type="radio" name="helicopterAccess" value="false" class="form-check-input" autocomplete="off" required>Nie
        </div>
        <br>
		<div class="form-group form-check-inline">
			<label for="inputteachinghospital">Szpital organizujący praktyki</label>&nbsp;
			<input type="radio" name="teachingHospital" value="true" class="form-check-input" autocomplete="off" required>Tak
			&nbsp
			<input type="radio" name="teachingHospital" value="false" class="form-check-input" autocomplete="off" required>Nie
        </div>

		<div class="mb-3">
		<br>
        <button class="btn btn-primary btn-lg btn-block" type="submit">Dodaj Szpital</button>
		</div>

    </form>
</div>
</div>
</div>


      </div>
    </main>


    <footer class="container-fluid w-100 py-2 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Hospitals Management</p>
      </div>
    </footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </wrapper>
  </body>
</html>
