package rev.service;

import java.util.List;

import rev.model.Post;

public interface PostService {

	public Post createPost(Post post);
	public void delete(Post post);
	public Post selectById(int id);
	public List<Post> selectByUserId(int userId);
	public List<Post> selectAll();
}
