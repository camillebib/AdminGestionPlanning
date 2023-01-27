<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign-in Success</title>
</head>
<body>
<div align="center">
    <h1>Sign-in successful</h1>
    <p>Click <a href="http://localhost:8080/AdminGestionPlanning/login">here</a> if you are not redirected within 5 seconds</p>
</div>
<script type="text/javascript">
    function redirect() {
        location.href = "http://localhost:8080/AdminGestionPlanning/login";
    }
    window.setTimeout("redirect()", 5000);
</script>
</body>
</html>