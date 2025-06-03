<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HungerBox</title>
<link rel="stylesheet" type="text/css" href="/HungerBox/CSS/contact.css">
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
<br><br>
  <section class="contact-section">
        <div class="container">
            <div class="contact-box">
                <h2>Contact Us</h2>
                <form action="#">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" required placeholder="Enter your name">

                    <label for="email">Email ID:</label>
                    <input type="email" id="email" name="email" required placeholder="Enter your email">

                    <label for="phone">Phone No:</label>
                    <input type="text" id="phone" name="phone" required placeholder="Enter your contact">

                    <label for="message">Message:</label>
                    <textarea id="message" name="message" required placeholder="Enter your message" rows="5"></textarea>

                    <button type="submit" class="btn submit-btn">Submit</button>
                </form>
            </div>
        </div>
    </section>
    <br><br>
 
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