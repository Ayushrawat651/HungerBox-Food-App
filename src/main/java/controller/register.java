package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.dao.RegisterCustomer;
import com.utility.Encrypt;

@WebServlet("/controller/register")
public class register extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String password = request.getParameter("password");

                Customer customer = new Customer(0,name,email,phone,new Encrypt().encryptPassword(password));

                RegisterCustomer rg = new RegisterCustomer();

                boolean status = rg.registerCustomer(customer);

                System.out.println(status);

                if(status) {
                        response.sendRedirect("/HungerBox/login.jsp");
                }
                else {
					RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
					request.setAttribute("error", "true");
					rd.include(request, response);
                }
        }

}