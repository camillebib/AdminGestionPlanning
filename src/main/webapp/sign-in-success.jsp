<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription réussie !</title>
</head>
<body>
<div align="center">
    <h1>Inscription réussie !</h1>
    <p>Cliquez <a href="http://localhost:8080/AdminGestionPlanning/login">ici</a> si vous n&rsquo;êtes pas rédirigé.e dans les 5 secondes</p>
</div>
<script type="text/javascript">
    function redirect() {
        location.href = "http://localhost:8080/AdminGestionPlanning/login";
    }
    window.setTimeout("redirect()", 2000);
</script>
</body>
</html>