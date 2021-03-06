package rev.model;

import java.util.List;

public class Utilities {
	
	public Post post;
	public List<Comment> comments;
	public List<Likes> likeNumber;
	public List<Bookmarks> bookmarksList;
	
	public Utilities() {
		// TODO Auto-generated constructor stub
	}
	


	public Utilities(Post post) {
		super();
		this.post = post;
	}



	public Utilities(Post post, List<Comment> comments, List<Likes> likeNumber, List<Bookmarks> bookmarksList) {
		super();
		this.post = post;
		this.comments = comments;
		this.likeNumber = likeNumber;
		this.bookmarksList = bookmarksList;
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

	public List<Likes> getLikeNumber() {
		return likeNumber;
	}

	public void setLikeNumber(List<Likes> likeNumber) {
		this.likeNumber = likeNumber;
	}



	public List<Bookmarks> getBookmarksList() {
		return bookmarksList;
	}



	public void setBookmarksList(List<Bookmarks> bookmarksList) {
		this.bookmarksList = bookmarksList;
	}
	
	
	
	

}
