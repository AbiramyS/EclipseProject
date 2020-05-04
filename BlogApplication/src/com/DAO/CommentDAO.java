package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.model.Comment;
public interface CommentDAO {
	
	int addComment(Comment c);
	int updateComment(Comment c) throws SQLException;
	int deleteCommment(Comment c);
	List<Comment> getListOfComment() throws SQLException;
	int getSingleComment(int commentId);
	Comment getComment(int postId, int userId, int commentId);
}
