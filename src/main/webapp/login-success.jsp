<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<div align="center">
    <h1>You have logined successfully</h1>
</div>
<script type="text/javascript">
    function redirect() {
        location.href = "http://localhost:8080/AdminGestionPlanning/user-list";
    }
    window.setTimeout("redirect()", 5000);
</script>
</body>
</html>