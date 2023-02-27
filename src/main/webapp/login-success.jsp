<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion réussie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div align="center">
    <h1>Connexion validée</h1>
</div>
<script type="text/javascript">
    function redirect() {
        location.href = "http://localhost:8080/AdminGestionPlanning/user-list";
    }
    window.setTimeout("redirect()", 0);
</script>
</body>
</html>