<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="com.bean.Cart"%>
<%@ page import="com.bean.Menu"%>
<%@ page import="com.bean.Customer"%>
<%@ page import="com.dao.ProductDao"%>


<%  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies. %>
	
<% if (request.getHeader("Referer") == null || request.getSession().getAttribute("user") == null || request.getSession().getAttribute("auth") != "true") {
    response.sendRedirect("/HungerBox/login.jsp");
}%>

<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Menu> cartProduct = null;
if (cart_list != null) {
	ProductDao pDao = new ProductDao();
	cartProduct = pDao.getCartProducts(cart_list);
	double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" type="text/css"
	href="/HungerBox/CSS/cart.css">
<link rel="stylesheet" type="text/css"
	href="/HungerBox/CSS/upiPayment.css">
</head>
<body>


	<nav>
		<div class="logo">
			<img src="/HungerBox/images/diet.png" alt="LuxuryBrand Logo" class="logo-img">
             <a href="/HungerBox/home.jsp">HungerBox</a>
		</div>
		<ul class="nav-links">
			<li><a href="/HungerBox/home.jsp">Home</a></li>
			<li><a href="/HungerBox/about.jsp">About Us</a></li>
			<li><a href="/HungerBox/contact.jsp">Contact Us</a></li> 
			<li><a href="/HungerBox/ordering.jsp">Order</a></li>
			<li><a href="/HungerBox/cart.jsp">Cart</a></li>
		</ul>
		<ul>
			<!-- Profile Section -->
			<li class="profile">
			<div class="profile-pic">
				<%=(((Customer)session.getAttribute("user")).getCustomerName()).toUpperCase().charAt(0) %>
			</div>
 			<span class="username"><% out.print(((Customer)session.getAttribute("user")).getCustomerName()); %></span>
				<div class="dropdown">
					<a href="/HungerBox/controller/GenerateHistory">Account Details</a> 
					<a href="/HungerBox/controller/logout">Logout</a>
				</div></li>
		</ul>
	</nav>




<div id="main">

	<div  class="container">
		<h2>Your Cart</h2>
		<div class="cart-header">
			<h3>Total Price: Rs. ${(total>0)?dcf.format(total):0}</h3>
			

			
		</div>
		<table class="table table-light">
			<thead>
				<tr class="details">
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cart_list != null) {
					for (Cart c : cart_list) {
				%>
				<tr>
					<td><%=c.getDishName() %></td>
					<td><%=c.getPrice() %></td>
					<td>
						<form action="/HungerBox/controller/cart-check-out" method="post">
							<input type="hidden" name="id" value="<%=c.getDishId()%>"
								class="form-input">
							<div  class="quantity-controls">
								<a href="/HungerBox/controller/quantity-inc-dec?action=inc&id=<%=c.getDishId()%>">
								<i>+</i>
								</a> 
								<input type="text" name="quantity"  value="<%=c.getQuantity()%>" readonly> 
								<a href="/HungerBox/controller/quantity-inc-dec?action=dec&id=<%=c.getDishId()%>">
								<i>-</i>
								</a>
							</div>
							
						</form>
					</td>
					<td>
					<a href="/HungerBox/controller/remove-from-cart?id=<%=c.getDishId()%>">Remove</a>
					</td>
				</tr>

				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
	
	<form action="/HungerBox/controller/cart-check-out" class="payment-container" onsubmit="return processPayment()">

    <h2>Hungerbox Payment</h2>

    <div class="total-price" id="total-price">Total Price: Rs. ${(total>0)?dcf.format(total):0}</div>

    <input type="text" id="upi-id" class="input-field" placeholder="Enter UPI ID" />

    <div class="error-message" id="error-message">Invalid UPI ID. Please enter a valid UPI ID (e.g., user@bank).</div>
	<% if(cart_list != null){ %>
    <button class="pay-btn" >Pay</button>
	<% } %>
    <div class="success-message" id="success-message"></div>

    <div class="warm-message" id="warm-message"></div>

    <div class="user-id" id="user-id"></div>

  </div>
  </form>
  <script type="text/javascript">
		history.forward();
	</script>
<script src="/HungerBox/SCRIPT/upiPayment.js"></script>
</body>
</html>