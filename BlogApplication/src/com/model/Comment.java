package com.model;

import java.util.Date;

public class Comment {
	private int commentId;
	private int userId;
	private int postId;
	private String comment;
	private Date commentDate;
	

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId,int userId, int postId,  String comment) {
		super();
		this.commentId=commentId;
		this.userId=userId;
		this.postId=postId;
		this.comment = comment;
		this.commentDate = new Date();
		
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId +",userId=" + userId +",postId=" + postId +", commentDate=" + commentDate + ", comment=" + comment + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
