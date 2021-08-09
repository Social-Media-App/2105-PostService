package rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rev.model.Comment;
import rev.model.Post;

@Service
public interface CommentService {

	public Comment save(Comment comment);
	public Comment findByCommentId(int id);
	public List<Comment> findByPost(Post post);
	public List<Comment> findAll();
}
