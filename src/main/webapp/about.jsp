<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HungerBox</title>
<link rel="stylesheet" type="text/css" href="/HungerBox/CSS/about.css">
</head>
<body>

<!-- Navigation Bar -->
<nav>
     <div class="logo">
                <img src="<%= request.getContextPath() %>/images/diet.png" alt="LuxuryBrand Logo" class="logo-img">
                <a href="<%= request.getContextPath() %>/home.jsp">HungerBox</a>
     </div>
    <ul class="nav-links">
    				<%if(session.getAttribute("auth") != null){ %>
                    <li><a href="<%= request.getContextPath() %>/home.jsp">Home</a></li>
                    <%}
    				else{ %>
    				<li><a href="<%= request.getContextPath() %>/landing.jsp">Home</a></li>
    				<%}%>
                    <li><a href="<%= request.getContextPath() %>/about.jsp">About Us</a></li>
                    <li><a href="/HungerBox/controller/ordering">Order</a></li>
                    <li><a href="<%= request.getContextPath() %>/contact.jsp">Contact Us</a></li>  
     </ul>
    
</nav>
<br><br><br>
  <div class="about-section">
        <div class="container">
            <div class="about-content">
                <div class="about-text">
                    <h2>About Us</h2>
                    <p>Welcome to HungryBox! We are a passionate team of food enthusiasts dedicated to bringing you the best culinary experiences. Our journey began with a simple idea: to create a space where food lovers can explore and enjoy diverse cuisines in a cozy and welcoming environment.</p>
                    <p>At HungryBox, we believe in the power of good food to bring people together. Our chefs are committed to using the freshest ingredients to prepare dishes that not only taste amazing but also nourish your body and soul. Whether you're in the mood for a hearty meal or a light snack, we have something for everyone.</p>
                    <p>Join us and be a part of our food-loving community. We look forward to serving you!</p>
                </div>
            </div>
        </div>
    </div>
    <br><br><br>

    
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

<%! public void aa(javax.servlet.jsp.JspWriter out) throws java.io.IOException {
                                out.print("hello0000");
                } %>



<script type="text/javascript">
		history.forward();
	</script>

<script src="/HungerBox/SCRIPT/home.js"></script>
</body>
</html>