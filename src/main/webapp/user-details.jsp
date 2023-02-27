<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">

  <div class="row text-center">
    <h1 class="h3 mb-3 font-weight-normal">Mise à jour de ${user.username}</h1>
  </div>

  <div class="row">
    <div class="col-8 offset-2 mt-3">
      <div class="card">
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/update-user" method="post">
            <div class="mb-3">
              <label for="userPseudo">Pseudo</label>
              <input id="userPseudo" type="text" name="userPseudo" class="form-control" required="required" value="${user.username}">
            </div>
            <div class="mb-3">
              <label for="userEmail">Email</label>
              <input id="userEmail" type="email" name="userEmail" class="form-control" required="required" value="${user.email}">
            </div>
            <div class="mb-3">
              <label for="userImg">Image</label>
              <input id="userImg" type="text" name="userImg" class="form-control" value="${user.img}">
            </div>
            <div class="mb-3">
              <label for="userNom">Nom</label>
              <input id="userNom" type="text" name="userNom" class="form-control" required="required" value="${user.nom}">
            </div>
            <div class="mb-3">
              <label for="userPrenom">Prenom</label>
              <input id="userPrenom" type="text" name="userPrenom" class="form-control" required="required" value="${user.prenom}">
            </div>
            <c:if test="${canAccess}">
                <div class="mb-3">
                  <label for="userType">Rôle</label>
                  <select id="userType" type="number" name="userType" class="form-control" required="required">
                      <option value="1">User</option>
                      <option value="2">Admin</option>
                  </select>
                </div>
            </c:if>
            <div class="mb-3">
              <label for="userPassword">Password</label>
              <input id="userPassword" type="password" name="userPassword" class="form-control">
            </div>

            <div class="mb-3 text-end">
              <button type="submit" class="btn btn-primary" name="idUser" value="${user.id}">Update</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>