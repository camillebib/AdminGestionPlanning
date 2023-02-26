<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">

  <div class="row text-center">
    <h1 class="h3 mb-3 font-weight-normal">Inscription</h1>
  </div>

  <div class="row">
    <div class="col-8 offset-2 mt-3">
      <div class="card">
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/sign-in" method="post">
            <div class="mb-3">
              <label for="userPseudo">Pseudo</label>
              <input id="userPseudo" type="text" name="userPseudo" class="form-control" required="required">
            </div>
            <div class="mb-3">
              <label for="userEmail">Email</label>
              <input id="userEmail" type="email" name="userEmail" class="form-control" placeholder="exemple@mail.com" required="required">
            </div>
            <div class="mb-3">
              <label for="userNom">Nom</label>
              <input id="userNom" type="text" name="userNom" class="form-control" required="required">
            </div>
            <div class="mb-3">
              <label for="userPrenom">Prénom</label>
              <input id="userPrenom" type="text" name="userPrenom" class="form-control" required="required">
            </div>
            <div class="mb-3">
              <label for="userPassword">Mot de passe</label>
              <input id="userPassword" type="password" name="userPassword" class="form-control" required="required">
            </div>

            <div class="mb-3 text-end">
              <button type="submit" class="btn btn-primary">S&rsquo;inscrire</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
