<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion réussie</title>
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