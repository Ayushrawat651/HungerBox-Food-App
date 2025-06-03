<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.bean.Customer"%>
    <%@ page import="com.bean.Menu"%>
    <%@ page import="com.bean.Orders"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hungerbox Admin Dashboard</title>
<link rel="stylesheet" href="/HungerBox/CSS/adminDashboard.css">
</head>
<body>
	<div class="sidebar">
		<h2>Hunger Box</h2>
		<ul>
			<li><a href="#dashboard">Dashboard</a></li>
			<li><a href="#orders">Orders</a></li>
			<li><a href="#users">Users</a></li>
			<li><a href="#menu">Menu</a></li>
		</ul>
		<a id="logout" href="/HungerBox/controller/logout">Logout</a>
	</div>

	<div class="main-content">
		<!-- Menu Management Section -->
		<section id="menu">
			<h2>Menu Management</h2>
			<br> <br>
			<button onclick="showAddMenuItemForm()">Add New Item</button>
			<button onclick="showRemoveMenuItemForm()">Remove Item</button>
			<table id="menu-table">
				<thead>
					<tr>
						<th>Item Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody id="menu-list">
					<% ArrayList<Menu> dishes = (ArrayList<Menu>) session.getAttribute("Admin-menu");
           			if(dishes != null){
        	   			for(Menu dish : dishes){ %>
							<tr>
								<td><%=dish.getDishName() %></td>
								<td><%=dish.getPrice() %></td>
							</tr>
        			<%   }
          			 }
           			else{ %>
	   					<tr>
	   						<td>No data found.</td>
	   						<td></td>
	   					</tr>
 			 		<% }%>
				</tbody>
			</table>
		</section>



		<!-- User Management Section -->

		<section id="users">

			<h2>User Management</h2>

			<table id="user-table">

				<thead>

					<tr>

						<th>Name</th>

						<th>Email</th>

						<th>Status</th>

						<th>Action</th>

					</tr>

				</thead>

				<tbody id="user-list">

					<% ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("Admin-customers");
           			if(customers != null){
        	   			for(Customer customer : customers){ %>
							<tr>
								<td><%=customer.getCustomerName() %></td>
								<td><%=customer.getCustomerEmail() %></td>
								<td><%=customer.getCustomerPhoneNo() %></td>
								<td><a href="/HungerBox/controller/DeleteCustomer?Admin-customer-id=<%=customer.getCustomerId() %>">Delete</a></td>
							</tr>
        			<%   }
          			 }
           			else{ %>
	   					<tr>
	   						<td>No data found.<td>
	   						<td></td>
	   						<td></td>
	   						<td></td>
	   					</tr>
 			 		<% }%>

				</tbody>

			</table>

		</section>



		<!-- Order Management Section -->

		<section id="orders">

			<h2>Order Management</h2>

			<table id="order-table">

				<thead>

					<tr>

						<th>Order ID</th>

						<th>User</th>

						<th>Food Item(s)</th>

						<th>Status</th>

						<th>Action</th>

					</tr>

				</thead>

				<tbody id="order-list">
					<% ArrayList<Orders> orders = (ArrayList<Orders>) session.getAttribute("Admin-history");
           			if(orders != null){
        	   			for(Orders order : orders){ %>
							<tr>
								<td>1</td>
								<td><%=order.getCustomerId() %></td>
								<td><%=order.getDishes() %></td>
								<td>
									<% if(order.getStatus() == 1){
										out.print("Completed");
									}
										else{
											out.print("In queue");
										}
									%>
								</td>
								<td><a href="/HungerBox/controller/ChangeOrderStatus?order-id=<%=order.getOrderId() %>">Update Status</a></td>
							</tr>
        			<%   }
          			 }
           			else{ %>
        	   				<tr>
        	   					<td>No data found.</td>
        	   					<td></td>
        	   					<td></td>
        	   					<td></td>
        	   					<td></td>
        	   				</tr>
         			 <% }%>

				</tbody>

			</table>

		</section>

	</div>



	<!-- Add Menu Item Modal -->

	<div id="add-item-form" class="modal">

		<form id="menu-item-form" action="/HungerBox/controller/AddDish">

			<label for="item-name">Item Name:</label> 
			<input type="text" id="item-name" name="item-name" required> 
			
			<label for="dish-Description">Dish Description:</label>
			<input type="text" name="dish-Description">
			
			<label for="type">Type:</label>
			<div>
			<div id = "radio-input">
				<input type="radio" name="type" value="TRUE">Veg
			</div>
			<div id = "radio-input">
				<input type="radio" name="type" value="FALSE">Non-veg
			</div>
			</div>
			
			<label for="img-Url">URL:</label>
			<input type="text" name="img-Url">
			
			<label for="quantity">Quantity:</label>
			<input type="number" name="quantity">
			
			<label for="item-price">Price:</label>
			<input type="number" id="item-price" name="item-price" required>

			<input id="submit" type="submit" value="Add Item">
			<button type="button" onclick="closeAddMenuItemForm()">Cancel</button>

		</form>

	</div>
	
		<!-- Remove Menu Item Modal -->

	<div id="remove-item-form" class="modal">

		<form id="remove-menu-item-form" action="/HungerBox/controller/RemoveDish">

			<label for="item-name">Item Name:</label> 
			<input type="text" id="remove-item-name" name="remove-item-name" required> 

			<input id="submit" type="submit" value="Remove Item">
			<button type="button" onclick="closeRemoveMenuItemForm()">Cancel</button>

		</form>

	</div>

	<script src="/HungerBox/SCRIPT/adminDashboard.js"></script>
	<script type="text/javascript">
		history.forward();
	</script>

</body>

</html>