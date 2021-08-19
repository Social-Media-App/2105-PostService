package rev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rev.model.Bookmarks;
import rev.model.Post;

@Repository
public interface BookmarksDao extends JpaRepository<Bookmarks, Integer> {
	
	public Bookmarks save(Bookmarks bookmarks);
	public List<Bookmarks> findByPost(Post post);
	public boolean existsByUserIdAndPost(Integer userId, Post post);
	public void deleteAllByUserIdAndPost(Integer userId, Post post);

}