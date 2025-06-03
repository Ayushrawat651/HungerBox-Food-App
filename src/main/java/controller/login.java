package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.dao.AdminLogin;
import com.dao.CustomerLogin;
import com.dao.GetCustomerDetailsByEmail;
import com.utility.Encrypt;

@WebServlet("/controller/login")
public class login extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		System.out.println("Login Process Initiated");

		try (PrintWriter out = response.getWriter()) {
			String userType = request.getParameter("userType");
			String email = request.getParameter("email");
			String password = new Encrypt().encryptPassword(request.getParameter("password"));

			if (userType.equals("user")) {
				System.out.println("Login as user selected");
				CustomerLogin cl = new CustomerLogin();
				if (cl != null) {
					String password_db = cl.customerLogin(email);
					System.out.println(password + "--" + password_db);
					if (password.equals(password_db)) {
						System.out.println("user password matched");

						HttpSession false_session = request.getSession(false);

						if (false_session != null) {
							false_session.invalidate();
							System.out.println("Session invalidated successfully.");
						}
						HttpSession session = request.getSession(true);
						System.out.println("Session created successfully.");

						session.setAttribute("auth", "true");
						Customer customer = new GetCustomerDetailsByEmail().getCustomerDetailsByEmail(email);
						session.setAttribute("user", customer);
						
						/* out.print("<script>alert("+"Login Successful"+");</script>"); */
						response.sendRedirect("/HungerBox/home.jsp");

					} else {
						System.out.println("user password did not match");
						 RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); 
						request.setAttribute("error", "true");
						 rd.include(request, response); 
					}
				}
			} else if (userType.equals("admin")) {
				System.out.println("Login as admin selected");
				AdminLogin ad = new AdminLogin();
				String password_db = ad.adminLogin(email);
				password = request.getParameter("password");
				if(password.equals(password_db)) {
					System.out.println("admin credentials verified");
					HttpSession false_session = request.getSession(false);

					if (false_session != null) {
						false_session.invalidate();
						System.out.println("Session invalidated successfully.");
					}
					HttpSession session = request.getSession(true);
					System.out.println("Session created successfully.");

					session.setAttribute("auth", "true");
					session.setAttribute("admin", "Admin");
					response.sendRedirect("/HungerBox/controller/adminDashboard");
				}
				else {
					System.out.println("something went wrong!!!");
					 RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); 
						request.setAttribute("error", "true");
						 rd.include(request, response); 
				}
				
			} else {
				response.sendRedirect("/HungerBox/login.jsp");
			}
		}
	}
}