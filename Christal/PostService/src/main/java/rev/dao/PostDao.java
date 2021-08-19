package rev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rev.model.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Integer>{
	
	
	public Post save(Post post);
	public void delete(Post post);
	public Post findByPostId(int id);
	public List<Post> findByUserId(int userId);
	public List<Post> findAll();
	
	
	
}
