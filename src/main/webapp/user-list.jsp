<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="row justify-content-start">
    <c:forEach items="${users}" var="user">
        <div class="col mt-2 ms-2">
            <div class="card" style="width: 16rem;">
                <div class="card-body">
                    <h5 class="card-title">${user.username}</h5>
                    <p class="card-text">Nom : ${user.nom}</p>
                    <p class="card-text">Prénom : ${user.prenom}</p>
                    <p class="card-text">Email : ${user.email}</p>
                    <c:forEach items="${user.roles}" var="role">
                        <p class="card-text">Niveau d&rsquo;accès : ${role.id}</p>
                    </c:forEach>
                    <form action="${pageContext.request.contextPath}/user-details" method="post">
                        <button type="submit" class="btn btn-primary" name="idUser" value="${user.id}">Update</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/remove-user" method="post">
                        <button type="submit" class="btn btn-danger" name="idUser" value="${user.id}">Remove</button>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</div>

</body>
</html>