package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.model.Post;


public interface PostDAO {
	
	int addPost(Post p);
	int updatePost(Post p);
	int deletePost(Post p);
	List<Post> getListOfPost() throws SQLException;
	int getSinglePost(Post p);
	Post getPost(int postId, int userId);

}
