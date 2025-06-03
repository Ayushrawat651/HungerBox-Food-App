package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.dao.GetHistory;

@WebServlet("/controller/GenerateHistory")
public class GenerateHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("auth") != null) {
			request.getSession().setAttribute("history", new GetHistory().getHistory(((Customer) request.getSession().getAttribute("user")).getCustomerId()));
			System.out.println(request.getSession().getAttribute("history"));
    		response.sendRedirect("/HungerBox/updateProfile.jsp");
		}
		else {
    		response.sendRedirect("/HungerBox/login.jsp");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
