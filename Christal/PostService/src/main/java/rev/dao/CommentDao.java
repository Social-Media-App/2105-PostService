package rev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rev.model.Comment;
import rev.model.Post;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer>{
	public Comment save(Comment comment);
	public Comment findByCommentId(int id);
	public List<Comment> findByPost(Post post);
	public List<Comment> findAll();
}
