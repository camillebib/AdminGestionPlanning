<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Accès non-autorisé</title>
</head>
<body>
<div align="center">
    <h1>401</h1>
    <h3>Accès non-autorisé ou identifiants erronés</h3>
    <p>Cliquez <a href="http://localhost:8080/AdminGestionPlanning/login">ici</a> si vous n&rsquo;êtes pas rédirigé.e dans les 5 secondes</p>
</div>
<script type="text/javascript">
    function redirect() {
        location.href = "http://localhost:8080/AdminGestionPlanning/login";
    }
    window.setTimeout("redirect()", 5000);
</script>
</body>
</html>