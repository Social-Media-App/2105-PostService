package rev.model;

import java.util.List;

public class Utilities {
	
	public Post post;
	public List<Comment> comments;
	public int likeNumber;
	
	public Utilities() {
		// TODO Auto-generated constructor stub
	}
	


	public Utilities(Post post) {
		super();
		this.post = post;
	}



	public Utilities(Post post, List<Comment> comments, int likeNumber) {
		super();
		this.post = post;
		this.comments = comments;
		this.likeNumber = likeNumber;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(int likeNumber) {
		this.likeNumber = likeNumber;
	}
	
	

}
