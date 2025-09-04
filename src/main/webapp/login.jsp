<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>This is login page.</h1>
<hr>
Type your LOGIN Credentials.<br><br>
<p style="color:green">${signupsuccessful}</p>
<p style="color:red">${error}</p>

<form method="post" action="login">
Username: <input type="text" name="username"><br><br>
Password: <input type="password" name="password"><br><br>
<input type="submit" value="Click for Login">
</form>
</body>
</html>