package com.model;
import java.sql.Date;

public class Post {
	private int postId;
	private int userId;
	private String postTitle;
	private String postContent;
	private Date postDate;
	private byte postImage;
	
	

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int userId, String postTitle, String postContent, byte postImage) {
		super();
		this.userId = userId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postImage = postImage;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ",userId=" + userId + ",postTitle=" + postTitle + ", postContent=" + postContent + ", postDate=" + postDate
				+ ", postImage=" + postImage + "]";
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

	public byte getPostImage() {
		return postImage;
	}

	public void setPostImage(byte postImage) {
		this.postImage = postImage;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
