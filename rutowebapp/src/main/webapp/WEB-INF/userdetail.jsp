<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/htm;charset=UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <title>Ruto.az</title>
</head>
<body>

<%
    User u = (User) request.getAttribute("user");
    CountryDaoInter countryDao =  Context.instanceCountryDao();
%>

<div class="col-16" style="margin-left: 10px"  >
    <a href="requests">Show all requests</a>
    <form:form action="userdetail" method="POST" modelAttribute="form">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="{<%=u.id()%>}"/>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Name</label>
                <input style="width: 300px" type="text" class="form-control" placeholder="First name" name="name" value="<%=u.getName()%>">
            </div>
            <div class="form-group col-md-6" >
                <label>Surname</label>
                <input style="width: 300px" type="text" class="form-control" placeholder="Surname" name="surname" value="<%=u.getSurname()%>">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Email</label>
                <input name="email" style="width: 300px"  type="email" class="form-control" id="inputEmail4" value="<%=u.getEmail()%>">
            </div>
            <div class="form-group col-md-6">
                <label >BirthDate</label>
                <input style="width: 150px" type="text" class="form-control" name="birthdate" value="<%=u.getBirthDate()%>">
            </div>
        </div>
        <div class="form-group">
            <label>Address</label>
            <input name="adress" style="width: 400px" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" value="<%=u.getAdress()%>">
        </div>
        <div class="form-group">
            <label>Phone</label>
            <input name="phone" style="width: 150px" type="text" class="form-control" id="inputAddress2" placeholder="Phone" value="<%=u.getPhone()%>">
        </div>
        <div class="form-row">
            <div style="padding-right: 400px" class="form-group col-md-6" >
                <label>Nationality</label>
                <input name="nationality" style="width: 150px" type="text" class="form-control" value="<%=u.getNationality()%>">
            </div>
            <div class="form-group col-md-4" style="margin-right: 50px">
                <label>BirthPlace</label>
                <select name="birthplace" class="form-control" style="width: 150px" >
                    <option><%=u.getBirthplace()%></option>
                    <option><%=countryDao.getById(1)%></option>
                    <option><%=countryDao.getById(2)%></option>
                    <option><%=countryDao.getById(3)%></option>
                    <option><%=countryDao.getById(6)%></option>
                    <option><%=countryDao.getById(7)%></option>
                    <option><%=countryDao.getById(8)%></option>
                    <option><%=countryDao.getById(9)%></option>
                    <option><%=countryDao.getById(10)%></option>
                </select>
            </div>
        </div>
        <button class="btn btn-primary" type="submit" name="save" value="Save">Save</button>
    </form:form>
     </br>
    <form action="userdetail" method="POST">
        <input type="hidden" name="action" value="back">
    <button class="btn btn-primary" type="submit" name="back" value="Back">Back</button>
    </form>
</div>

</body>
</html>