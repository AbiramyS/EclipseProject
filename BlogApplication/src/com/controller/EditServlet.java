package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDAO;
import com.DAOImpl.UserDAOImpl;
import com.model.User;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result=-1;
		String firstname=request.getParameter("firstname");
		String middlename=request.getParameter("midlename");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipcode=request.getParameter("zipcode");
		
		try {	
		UserDAO userdao=new UserDAOImpl();
		User u=new User();
		System.out.println(u);
		result = userdao.updateUser(u);
		if (result == 1)
			response.sendRedirect("viewusers.jsp");
		}catch(Exception ex) {
			response.sendRedirect("edituser.jsp");
			
		}
	}
	}


