package rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rev.dao.CommentDao;
import rev.dao.PostDao;
import rev.model.Comment;
import rev.model.Post;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao;
	
	@Autowired
	private PostDao postDao;
	
	public CommentServiceImpl() {
		
	}
	@Autowired
	public CommentServiceImpl(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}

	
	@Override
	public Comment save(Comment comment) {
		System.out.println(comment);
		Post myPost = postDao.findByPostId(comment.getPost().getPostId());
		comment.setPost(myPost);
		return commentDao.save(comment);
	}

	@Override
	public Comment findByCommentId(int id) {
		
		return commentDao.findByCommentId(id);
	}

	@Override
	public List<Comment> findByPost(Post post) {
		
		return commentDao.findByPost(post);
	}

	@Override
	public List<Comment> findAll() {
		
		return commentDao.findAll();
	}

}
