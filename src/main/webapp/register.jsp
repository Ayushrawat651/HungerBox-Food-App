<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies. %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HungerBox - Registration</title>
<link rel="stylesheet" type="text/css" href="/HungerBox/CSS/register.css">
</head>
<body>

        	<nav>
		<div class="logo">
			<img src="/HungerBox/images/diet.png" alt="LuxuryBrand Logo" class="logo-img">
             <a href="/HungerBox/landing.jsp">HungerBox</a>
		</div>
		<ul class="nav-links">
			<li><a href="/HungerBox/landing.jsp">Home</a></li>
			<li><a href="/HungerBox/about.jsp">About Us</a></li>
			<li><a href="/HungerBox/contact.jsp">Contact Us</a></li> 

		</ul>

	</nav>

<div class="login-container">
    <h2>Register for HungerBox</h2>
    <form action="/HungerBox/controller/register" method="post" id="registrationForm" onsubmit="return validateRegistrationForm()">
        <input type="text" id="fullName" name="name" placeholder="Full Name" required>
        <div class="error-message" id="nameError"></div>

        <input type="text" id="email" name="email" placeholder="Email" required>
        <div class="error-message" id="emailError"></div>

        <input type="text" id="phone" name="phone" placeholder="Phone Number" required minlength="10" maxlength="10">
        <div class="error-message" id="phoneError"></div>

        <input type="password" id="password" name="password" placeholder="Password" required>
        <div class="error-message" id="passwordError"></div>

        <input type="password" id="confirmPassword" placeholder="Confirm Password" required>
        <div class="error-message" id="confirmPasswordError"></div>
        
        <% String str = (String)request.getAttribute("error"); 
                                	String tr = "true";
                                 if(str == tr){ 
                                	out.print("<p style='color: red;'>Invalid Credentials</p>");
                                }
                                %>

        <button type="submit">Register</button>
        <a href="login.jsp" class="register-link">Already have an account? Login here</a>
    </form>
</div>

<script src="/HungerBox/SCRIPT/register.js"></script>
	<script type="text/javascript">
    history.forward();
	</script>
</body>
</html>