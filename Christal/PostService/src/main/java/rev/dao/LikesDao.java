package rev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rev.model.Likes;
import rev.model.Post;

@Repository
public interface LikesDao extends JpaRepository<Likes, Integer>{

	public Likes save(Likes likes);
	public List<Likes> findByPost(Post post);
	
}
