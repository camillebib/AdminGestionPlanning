<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>403</h1>
    <h3>Thou art not allowed here or thou hast spoken the wrong key to enter</h3>
</div>
<script type="text/javascript">
    function redirect() {
        location.href = "http://localhost:8080/AdminGestionPlanning/login";
    }
    window.setTimeout("redirect()", 5000);
</script>
</body>
</html>