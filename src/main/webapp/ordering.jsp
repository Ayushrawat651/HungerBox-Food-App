<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bean.Menu"%>
<%@ page import="com.bean.Cart"%>
<%@ page import="com.bean.Customer"%>
<%@ page import="java.util.*"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%>
<% if (request.getHeader("Referer") == null || request.getSession().getAttribute("user") == null || request.getSession().getAttribute("auth") != "true") {
    response.sendRedirect("/HungerBox/login.jsp");
}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HungerBox - Order</title>
<link rel="stylesheet" type="text/css"
	href="/HungerBox/CSS/ordering.css">


</head>
<body>

	<nav>
		<div class="logo">
			<img src="/HungerBox/images/diet.png" alt="LuxuryBrand Logo"
				class="logo-img"> <a href="/HungerBox/home.jsp">HungerBox</a>
		</div>
		<ul class="nav-links">
			<li><a href="/HungerBox/home.jsp">Home</a></li>
			<li><a href="/HungerBox/about.jsp">About Us</a></li>
			<li><a href="/HungerBox/contact.jsp">Contact Us</a></li>
			<li><a href="/HungerBox/controller/ordering">Order</a></li>
			<li><a href="/HungerBox/cart.jsp">Cart</a></li>
		</ul>
		<ul>
			<!-- Profile Section -->
			<li class="profile">
				<div class="profile-pic">
					<%=(((Customer) session.getAttribute("user")).getCustomerName()).toUpperCase().charAt(0)%>
				</div> <span class="username"> <%
 out.print(((Customer) session.getAttribute("user")).getCustomerName());
 %>
			</span>
				<div class="dropdown">
					<a href="/HungerBox/controller/GenerateHistory">Account Details</a> 
					<a href="/HungerBox/controller/logout">Logout</a>
				</div>
			</li>
		</ul>
	</nav>

	<div class="ordering-container">
		<h1>Choose Your Dishes</h1>

		<%
		String selectdOption = (String) session.getAttribute("selectdOption");
		%>

		<form id="myForm" action="/HungerBox/controller/ordering"
			method="post" class="switch">
			<input name="switch" id="all" type="radio" value="all"
				onclick="submitForm()"
				<%="all".equals(selectdOption) ? "checked" : ""%> /> <label
				for="all" id="label_all" class="switch__label">All</label> <input
				name="switch" id="veg" type="radio" value="veg"
				onclick="submitForm()"
				<%="veg".equals(selectdOption) ? "checked" : ""%> /> <label
				for="veg" id="label_veg" class="switch__label">Veg</label> <input
				name="switch" id="nonVeg" type="radio" value="nonveg"
				onclick="submitForm()"
				<%="nonveg".equals(selectdOption) ? "checked" : ""%> /> <label
				for="nonVeg" id="label_nonVeg" class="switch__label">Non-veg</label>
			<div class="switch__indicator" /></div>
		</form>

		<div class="dishes-list">

			<%
			Menu[] menu = (Menu[]) session.getAttribute("menu");
			if (menu != null) {
				for (Menu dish : menu) {
			%>
			<div class="dish">
				<img src="<%=dish.getImgUrl()%>" alt="<%=dish.getDishName()%>">
				<div class="name"><%=dish.getDishName()%></div>
				<div class="name"><%=dish.getPrice()%>
					Rs.
				</div>
				<div class="type">
					<%
					if (dish.getVeg()) {
					%>
					<span style="color: green;">VEG</span>
					<%
					} else {
					%>
					<span style="color: red;">NON-VEG</span>
					<%
					}
					%>
				</div>
				<a
					href="/HungerBox/controller/cart?id=<%=dish.getMenuId()%>&name=<%=dish.getDishName()%>&price=<%=dish.getPrice()%>"
					class="add-to-cart"
					onclick="addToCart('<%=dish.getDishName()%>', this)">Add to
					Cart</a>
				<div class="counter" style="display: none;">0</div>
			</div>
			<%
			}
			} else {
			out.print("<div>No Dishes Available</div>");
			}
			%>
		</div>
	</div>

	<br>
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




	<script src="/HungerBox/SCRIPT/ordering.js"></script>
	<script type="text/javascript">
		history.forward();
	</script>
</body>
</html>