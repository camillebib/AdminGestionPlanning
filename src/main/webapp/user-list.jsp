<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col-8 offset-2 mt-3">
        <c:forEach items="${users}" var="user">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                    <h5 class="card-title">${user.pseudo}</h5>
                    <p class="card-text">${user.nom}</p>
                    <p class="card-text">${user.prenom}</p>
                    <p class="card-text">${user.email}</p>
                    <p class="card-text">${user.type}</p>
                    <form action="${pageContext.request.contextPath}/remove-user" method="post">
                        <button type="submit" class="btn btn-primary" name="idUser" value="${user.id}">Remove</button>
                    </form>
                </div>
            </div><br>
        </c:forEach>
    </div>
</div>
</div>

</body>
</html>