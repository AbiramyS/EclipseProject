package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CommentDAO;
import com.DAOImpl.CommentDAOImpl;
import com.model.Comment;
import com.model.Post;
import com.model.User;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result=-1;
		
		String comment=request.getParameter("comment");
		HttpSession session=request.getSession(false);
		
		User u=(User) session.getAttribute("USERSESSION");
		System.out.println(u);
		
		try {
			Post p=new Post();
			Comment c=new Comment(u.getUserId(),p.getPostId(), comment, new Date() );
			CommentDAO commentdao=new CommentDAOImpl();
			commentdao.addComment(c);
			
			if (result == 1)
				response.sendRedirect("secure/viewcomment.jsp");
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			response.sendRedirect("secure/comment.jsp");
		}
	
	}

}
