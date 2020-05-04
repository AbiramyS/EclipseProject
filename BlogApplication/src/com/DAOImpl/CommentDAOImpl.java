package com.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.CommentDAO;
import com.DBConnection.DBConnect;
import com.model.Comment;
import com.model.Post;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public int addComment(Comment c) {
		int status = -1;
		Connection con = null;

		try {

			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into comment(comment, commentDate) values(?,?)");

			ps.setString(1, c.getComment());
			ps.setDate(2, (Date) c.getCommentDate());
			status = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("error occured" + ex.getMessage());

		}
		return status;
	}

	@Override
	public int updateComment(Comment c) throws SQLException {

		int status = -1;

		Connection con = null;

		try {
			con = DBConnect.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update comment set comment=?, commentDate=? where commentId=?");

			ps.setString(1, c.getComment());
			ps.setDate(2, (Date) c.getCommentDate());
			status = ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return status;
	}

	@Override
	public int deleteCommment(Comment c) {
		int status = -1;
		Connection con = null;
		try {

			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from comment where commentId=?");
			ps.setInt(1, c.getCommentId());
			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while delete post");
		}

		return status;
	}

	@Override
	public List<Comment> getListOfComment() throws SQLException {
		List<Comment> list = new ArrayList<Comment>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnect.getConnection();
			ps = con.prepareStatement("select * from comment");
			rs = ps.executeQuery();

			while (rs.next()) {

				Comment c = new Comment();

				c.setComment(rs.getString("comment"));
				c.setCommentDate(rs.getDate("commentdate"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
		return list;
	}

	@Override
	public Comment getComment(int postId, int userId, int commentId) {

		Comment c = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement("select * from comment where postId=?and userId=? and  commentId=?");
			
			ps.setInt(1, postId);
			ps.setInt(2, userId);
			ps.setInt(3, commentId);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				c = new Comment();
				c.setComment(rs.getString("comment"));
				c.setCommentDate(rs.getDate("commentdate"));

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}

		return c;
	}

	@Override
	public int getSingleComment(int commentId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
