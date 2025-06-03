
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bean.Customer"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>HungerBox - Login</title>
<link rel="stylesheet" type="text/css" href="/HungerBox/CSS/login.css">
</head>

<body>
	<nav>
		<div class="logo">
			<img src="/HungerBox/images/diet.png" alt="LuxuryBrand Logo"
				class="logo-img"> <a href="/HungerBox/landing.jsp">HungerBox</a>
		</div>
		<ul class="nav-links">
			<li><a href="/HungerBox/landing.jsp">Home</a></li>
			<li><a href="/HungerBox/about.jsp">About Us</a></li>
			<li><a href="/HungerBox/contact.jsp">Contact Us</a></li>

		</ul>

	</nav>

	<br>
	<div class="login-container">
		<h2>Login to HungerBox</h2>
		<form action="/HungerBox/controller/login" method="post"
			id="loginForm" onsubmit="return validateForm()">
			<select id="userType" name="userType">
				<option value="user">Login as User</option>
				<option value="admin">Login as Admin</option>
			</select> <input type="text" id="email" name="email"
				placeholder="Registered Email ID" required>
			<div class="error-message" id="emailError"></div>
			<input type="password" id="password" name="password"
				placeholder="Password" required>
			<div class="error-message" id="passwordError"></div>
			<%
			String str = (String) request.getAttribute("error");
			String tr = "true";
			if (str == tr) {
				out.print("<p style='color: red;'>Invalid Credentials</p>");
			}
			%>

			<button type="submit">Login</button>
			<a href="/HungerBox/register.jsp" class="register-link">Don't
				have an account? Register here</a>
		</form>
	</div>
	<br>
	<br>

	<script src="/HungerBox/SCRIPT/login.js"></script>
	<script type="text/javascript">
		history.pushState(null, null, window.location.href);
		window.onpopstate = function() {
			history.go(1);
		};
	</script>
</body>

</html>