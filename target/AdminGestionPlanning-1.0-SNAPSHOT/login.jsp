<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
    rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
    <h1>Login Form</h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <div class="form-group">
            <label for="uname">User Name:</label>
            <input type="text" class="form-control" id="pseudo" placeholder="User Name" name="pseudo" required>
        </div>
        <div class="form-group">
            <label for="uname">Password:</label> <input type="password" class="form-control" id="password"
             placeholder="Password" name="password" required>
        </div><br>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>