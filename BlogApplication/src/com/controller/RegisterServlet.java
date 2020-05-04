package com.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.DAOImpl.UserDAOImpl;
import com.DBConnection.DBConnect;
import com.model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = -1;

		String firstname=request.getParameter("firstname");
		String middlename=request.getParameter("midlename");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipcode=request.getParameter("zipcode");
		String userstatus=request.getParameter("userstatus");
		
		try {	
		UserDAO userdao=new UserDAOImpl();
		User u=new User(firstname, middlename,lastname, email, password, address, street, city, state, zipcode, (byte)0, userstatus);
		System.out.println(u);
		result = userdao.addUser(u);
		if (result == 1)
			response.sendRedirect("login.jsp");
		}catch(Exception ex) {
			System.out.println("Error Occured Please register again");
			response.sendRedirect("register.jsp");
			
		}
	}

}
