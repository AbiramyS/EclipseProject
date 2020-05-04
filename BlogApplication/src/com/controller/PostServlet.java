package com.controller;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.PostDAO;
import com.DAOImpl.PostDAOImpl;
import com.model.Post;
import com.model.User;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result=-1;
		
		String posttitle=request.getParameter("posttitle");
		String postcontent=request.getParameter("postcontent");
		HttpSession session = request.getSession(false);
		User u = (User) session.getAttribute("USERSESSION");
		System.out.println(u);
		try {
			
			Post p = new Post(u.getUserId(),posttitle, postcontent,(byte)0);
			System.out.println(p);
			PostDAO postdao=new PostDAOImpl();
			result=postdao.addPost(p);
			
			if (result == 1)
				response.sendRedirect("secure/viewpost.jsp");
			}catch(Exception ex) {
				ex.printStackTrace();
				System.out.println("Error Occured Please post again"+ex.getMessage());
				response.sendRedirect("secure/addpost.jsp");
				
			}	
	
	}

}
