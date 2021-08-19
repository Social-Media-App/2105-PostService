package rev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rev.dao.CommentDao;
import rev.dao.PostDao;
import rev.model.Comment;
import rev.model.Post;
import rev.model.User;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao;
	private RestTemplate restTemp = new RestTemplate();
	
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
	
	@Override
	public List<Comment> findByPostId(Integer postId) {
		Post myPost = postDao.findByPostId(postId);
		List<Comment> commentList = commentDao.findByPost(myPost);
		List<User> userList = new ArrayList<>();
		User[] userArr = restTemp.getForObject("http://localhost:9082/login-service/getall", User[].class);
		Collections.addAll(userList, userArr);
		for(Comment tempComment: commentList) {
			user:
			for(User tempUser: userList) {
				if(tempComment.getUserId()==tempUser.getUserId()) {
					tempComment.setCommentedBy(tempUser);
					break user;
				}
			}
		}
		return commentList;
	}

}
