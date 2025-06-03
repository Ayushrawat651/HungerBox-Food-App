<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bean.Customer"%>
<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies. %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HungerBox</title>
<link rel="stylesheet" type="text/css" href="/HungerBox/CSS/landing.css">
</head>
<body>

<!-- Navigation Bar -->
<nav>
     <div class="logo">
                <img src="/HungerBox/images/diet.png" alt="LuxuryBrand Logo" class="logo-img">
                <a href="/HungerBox/landing.jsp">HungerBox</a>
     </div>
    <ul class="nav-links">
                    <li><a href="/HungerBox/landing.jsp">Home</a></li>
                    <li><a href="/HungerBox/about.jsp">About Us</a></li>
                    <li><a href="/HungerBox/login.jsp">Order</a></li>
                    <li><a href="/HungerBox/contact.jsp">Contact Us</a></li>  
     </ul>
     <div class="nav-buttons">
                <a href="/HungerBox/login.jsp" class="btn login">Login</a>
                <a href="/HungerBox/register.jsp" class="btn register">Register</a>
     </div>
    
</nav>

<!-- Main Content -->
   <form action="/HungerBox/login.jsp" method="post" class="main-content">
    <h1>Welcome to HungerBox</h1>
    <p>Your one-stop solution for delicious food delivery!</p>
    <button type="submit" class="cta-button">Order Now</button>
</form>

  <div class="features">
        <h2 style="text-align: center; color: aliceblue; font-size: 3rem;">What we provide?</h2>
        <br>
        <div class="container">
            <div style="background-color: #f5b53f;" class="feature-card">
                <div class="card-content">
                    <h3 style="color: white;">Fresh Ingredients</h3>
                    <p style="color: black;">We use only the freshest ingredients to ensure the highest quality and taste in every meal.</p>
                </div>
            </div>
            <div class="feature-card">
                <div class="card-content">
                    <h3>Variety of Dishes</h3>
                    <p>Our menu features a wide variety of dishes to cater to every palate and preference.</p>
                </div>
            </div>
            <div style="background-color: #f5b53f;" class="feature-card">
                <div class="card-content">
                    <h3 style="color: white;">Fast Delivery</h3>
                    <p style="color: black;">Enjoy your favorite meals delivered hot and fresh to your doorstep in no time.</p>
                </div>
            </div>
        </div>
    </div>

    <section class="features">
        <h2 style="text-align: center; color: aliceblue; font-size: 2rem;">Hear from our Customers</h2>
        <br>
        <div class="container">
            <div class="feature-card">
                <div class="card-content">
                    <h3 style="color: black;">"Best Food Experience Ever!"</h3>
                    <p style="color: black;">The ingredients are always fresh and the dishes are so flavorful. Highly recommended!</p>
                    <p style="color: black; text-align: right;">- Shashank Kothari</p>
                </div>
            </div>
            <div style="background-color: #f5b53f;" class="feature-card">
                <div class="card-content">
                    <h3 style="color: black;">"Variety and Quality"</h3>
                    <p style="color: black;">I love the variety of dishes offered. There is always something new to try and everything tastes amazing.</p>
                    <p style="text-align: right;">- Ayush Rawat</p>
                </div>
            </div>
            <div class="feature-card">
                <div class="card-content">
                    <h3 style="color: black;">"Fast and Reliable Service"</h3>
                    <p style="color: black;">The delivery is always quick, and the food arrives hot and fresh. Great service every time!</p>
                    <p style="color: black; text-align: right;">- Shivangi Sharma</p>
                </div>
            </div>
        </div>
    </section>
    
    <!-- Footer Section -->
    <footer>
        <div class="footer-content container">
            <p>&copy; 2024 HungerBox. All rights reserved.</p>
            <ul class="social-links">
                <li><a href="#">Facebook</a></li>
                <li><a href="#">Instagram</a></li>
                <li><a href="#">Twitter</a></li>
            </ul>
        </div>
    </footer>



<script type="text/javascript">
		history.forward();
	</script>

<script src="/HungerBox/SCRIPT/home.js"></script>
</body>
</html>