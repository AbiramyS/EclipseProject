package com.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.PostDAO;
import com.DBConnection.DBConnect;
import com.model.Post;

public class PostDAOImpl implements PostDAO {

	@Override
	public int addPost(Post p) {
		int status = -1;
		Connection con = null;

		try {

			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into post(userId, postTitle, postContent, postDate, postImage) values(?,?,?,?,?)");

			ps.setInt(1, p.getUserId());
			ps.setString(2, p.getPostTitle());
			ps.setString(3, p.getPostContent());
			ps.setDate(4, (Date) p.getPostDate());
			ps.setByte(5, p.getPostImage());

			status = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("error occured" + ex.getMessage());

		}
		return status;
	}

	@Override
	public int updatePost(Post p) {
		int status = -1;
		try {
			Connection con = null;
			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update post set postTitle=?, postContent=?, postDate=?, postImage=? where postId=?");

			ps.setString(1, p.getPostTitle());
			ps.setString(2, p.getPostContent());
			ps.setDate(3, (Date) p.getPostDate());
			ps.setByte(4, p.getPostImage());

			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("error occured during update post" + ex.getMessage());
		}
		return status;
	}

	@Override
	public int deletePost(Post p) {
		int status = -1;
		Connection con = null;
		try {

			con = DBConnect.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from post where postId=?");
			ps.setInt(1, p.getPostId());
			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error occured while delete post");
		}
		return status;
	}

	@Override
	public List<Post> getListOfPost() throws SQLException {

		List<Post> list = new ArrayList<Post>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement("select * from post");
			rs = ps.executeQuery();

			while (rs.next()) {

				Post p = new Post();
				p.setUserId(rs.getInt("userId"));
				p.setPostTitle(rs.getString("posttitle"));
				p.setPostContent(rs.getString("postcontent"));
				p.setPostDate(rs.getDate("postdate"));
				p.setPostImage(rs.getByte("postimage"));

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
	public Post getPost(int postId, int userId) {

		Post p=null;

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = DBConnect.getConnection();
			ps = con.prepareStatement("select * from post where postId=? and userId=?");
			ps.setInt(1, postId);
			ps.setInt(2, userId);
			rs = ps.executeQuery();

			while (rs.next()) {
				p = new Post();
				p.setPostTitle(rs.getString("posttitle"));
				p.setPostContent(rs.getString("postcontent"));
				p.setPostDate(rs.getDate("postdate"));
				p.setPostImage(rs.getByte("postimage"));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}

		return p;
	}
	
	@Override
	public int getSinglePost(Post p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
