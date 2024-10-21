<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/htm;charset=UTF-8">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript" src="assets/js/users.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <title>Ruto.az</title>
</head>
<body>

<div class=" container mycontainer">
    <div>
        <div class="col-4">
            <f:form action="users" method="GET" modelAttribute="user">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <f:input placeholder="Enter Name"
                                class="form-control"
                                path="name"
                                id="whatIamtyping"/>
                    <small id="emailHelp" class="form-text text-muted">Axtarish etmek ucun ad qeyd edin</small>
                    <f:errors path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <f:input
                            placeholder="Enter Surname"
                            class="form-control"
                            path="surname"/>
                    <f:errors path="surname"/>
                </div>
                <f:button  type="submit" class="btn btn-primary">Search</f:button>
                <f:button class="btn btn-primary" type="submit" value="back">Back</f:button>
            </f:form>
        </div>
        <div>
            <f:errors path="*"/>
            <table class="table">
                <thead>
                <tr>
                    <th>name</th>
                    <th>Surname</th>
                    <th>Nationality</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="u">
                    <tr>
                        <td>${u.name}</td>
                        <td>${u.surname}</td>
                        <td>${u.nationality.id}</td>
                        <td style="width:5px">
                            <input type="hidden" name="id" value="${u.id}"/>
                            <input type="hidden" name="action" value="delete"/>
                            <button class="btn btn-danger" type="submit" value="delete" data-toggle="modal"
                                    data-target="#exampleModal" onclick="setIdForDelete(${u.id})">
                                <i class="fa-solid fa-trash-can"></i>
                            </button>
                        </td>
                        <td style="width:5px">
                            <form action="userdetail" method="GET">
                                <input type="hidden" name="id" value="${u.id}"/>
                                <input type="hidden" name="action" value="update"/>
                                <button class="btn btn-secondary " type="submit" value="update">
                                    <i class="fa-solid fa-square-pen"></i>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="submit" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are You sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" id="idForDelete"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="submit" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>