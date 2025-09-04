<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page JSP</title>
</head>
<body>
<h1>Welcome.</h1>
<hr>

<h3>Please Signup.</h3>
<p style="color:red">${signupfail}</p><br><br>
<form method="post" action="signup">
Username: <input type="text" name="username" required><br><br>
Password: <input type="password" name="password" required><br><br>
<input type="submit" value="Click For Signup">
</form>

</body>
</html>