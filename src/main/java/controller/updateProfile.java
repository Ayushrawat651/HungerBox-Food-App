package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.bean.Menu;
import com.dao.GetCustomerDetailsByEmail;
import com.dao.GetHistory;
import com.dao.GetMenuItems;
import com.dao.UpdateUser;

@WebServlet("/controller/updateProfile")
public class updateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("auth") != null) {
			String email = request.getParameter("customeremail");
            boolean status = new UpdateUser().updateUser(
            		new Customer(
            				Integer.parseInt(request.getParameter("customerid")),
            				request.getParameter("customername"),
            				email,
            				request.getParameter("customerphoneno"),
            				request.getParameter("newpassword")
            				),
            		request.getParameter("oldpassword")
            		);
            if(status) {
				Customer customer = new GetCustomerDetailsByEmail().getCustomerDetailsByEmail(email);
				request.getSession().setAttribute("user", customer);
        		response.sendRedirect("/HungerBox/updateProfile.jsp");
            }
            else {
            	PrintWriter out = response.getWriter();
            	out.print("Something Went Wrong");
            }
    	}
    	else {
    		response.sendRedirect("/HungerBox/login.jsp");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
