<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accès non-autorisé</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div align="center">
    <h1>401</h1>
    <h3>Accès non-autorisé ou identifiants erronés</h3>
    <p>Cliquez <a href="http://localhost:8081/AdminGestionPlanning/login">ici</a> si vous n&rsquo;êtes pas rédirigé.e dans les 5 secondes</p>
</div>
<script type="text/javascript">
    function redirect() {
        location.href = "http://localhost:8081/AdminGestionPlanning/login";
    }
    window.setTimeout("redirect()", 5000);
</script>
</body>
</html>