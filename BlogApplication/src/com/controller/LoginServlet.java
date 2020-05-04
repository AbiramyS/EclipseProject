package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DAOImpl.UserDAOImpl;
import com.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = null;
		try {
			UserDAO userdao = new UserDAOImpl();
			if (email != null && password != null && !email.trim().equals("") && !password.trim().equals("")) {
				user = userdao.getUser(email, password);
				if (user != null) {
					HttpSession session = request.getSession();
					session.setAttribute("USERSESSION", user);
					session.setMaxInactiveInterval(1800);
					response.sendRedirect("secure/profile.jsp");
				} else {
					response.sendRedirect("home.jsp");

				}
			} else {
				System.out.println("Sorry Email or Password is null!");
				response.sendRedirect("home.jsp");

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("user is not found" + ex.getMessage());

		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Do get method");
	}

}
