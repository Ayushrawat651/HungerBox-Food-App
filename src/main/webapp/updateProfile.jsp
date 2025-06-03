<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.bean.Customer"%>
    <%@ page import="com.bean.Orders"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Dashboard</title>
<link rel="stylesheet" href="/HungerBox/CSS/updateProfile.css">
<% if (request.getHeader("Referer") == null || request.getSession().getAttribute("user") == null || request.getSession().getAttribute("auth") != "true") {
    response.sendRedirect("/HungerBox/login.jsp");
}%>
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
					<a href="/HungerBox/updateProfile.jsp">Account Details</a> 
					<a href="/HungerBox/controller/logout">Logout</a>
				</div></li>
		</ul>
	</nav>

	   <div class="container">
        <h1>Edit Profile</h1>

        <!-- Edit Profile Form -->
        <form action="/HungerBox/controller/updateProfile" method="post" >
            <input class="editInput" type="hidden" name="customerid" value="<%= ((Customer)session.getAttribute("user")).getCustomerId() %>" readOnly>

            <div class="form-group">
                <label for="customername">Full Name</label>
                <input class="editInput" type="text" id="customername" name="customername" value="<%= ((Customer)session.getAttribute("user")).getCustomerName() %>" readOnly>
            </div>

            <div class="form-group">
                <label for="customeremail">Email</label>
                <input class="editInput" type="email" id="customeremail" name="customeremail" value="<%= ((Customer)session.getAttribute("user")).getCustomerEmail() %>" readOnly>
            </div>

            <div class="form-group">
                <label for="customerphoneno">Phone Number</label>
                <input class="editInput" type="tel" id="customerphoneno" name="customerphoneno" value="<%= ((Customer)session.getAttribute("user")).getCustomerPhoneNo() %>" readOnly>
            </div>

            <!-- Password Section -->
            <h3>Change Password</h3>
            <div class="form-group">
                <label for="oldpassword">Old Password</label>
                <input class="editInput" type="password" id="oldpassword" name="oldpassword" required readOnly>
            </div>

            <div class="form-group">
                <label for="newpassword">New Password</label>
                <input class="editInput" type="password" id="newpassword" name="newpassword" readOnly>
            </div>

            <div class="form-group">
                <label for="confirmpassword">Confirm New Password</label>
                <input class="editInput" type="password" id="confirmpassword" name="confirmpassword" readOnly>
            </div>

            <div class="form-actions">
            	<button onclick="onEdit()" id="edit"  class="edit-save-button">Edit</button>
                <input id="save" type="submit" value="Save Changes" class="edit-save-button">
                <a href="/HungerBox/updateProfile.jsp" class="cancel-button">Cancel</a>
            </div>
        </form>
    </div>

<div id="history">
    <h1 style="color: black">History</h1>
    <% 
    ArrayList<Orders> orders = (ArrayList<Orders>) session.getAttribute("history");
    if (orders != null && !orders.isEmpty()) {
        for (Orders order : orders) {
    %>
        <div id="history-items">
            <p><strong>Customer ID:</strong> <%= order.getCustomerId() %></p>
            <p><strong>Dishes:</strong> <%= order.getDishes() %></p>
            <p><strong>Status:</strong> <% if(order.getStatus() == 0){
            	out.print("In queue");
            }else{
            	out.print("completed");
            }
            	%></p>
            
        </div>
    <% 
        }
    } else { 
    %>
        <p class="empty-message">No orders in your history.</p>
    <% } %>
</div>

    <script src="/HungerBox/SCRIPT/updateProfile.js"></script>
    	<script type="text/javascript">
    history.forward();
	</script>
</body>
</html>