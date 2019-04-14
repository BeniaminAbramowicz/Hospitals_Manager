<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand" href="#">Hospitals Management</a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Main Page
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/hospitals">Hospitals List</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/addhospital">Add Hospital</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Doctors List</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Add Doctor</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Employ Doctor</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>