package rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rev.dao.PostDao;
import rev.model.Post;

@Service
public class PostServiceImpl implements PostService {
	
	private PostDao myPostDao;
	
	
	@Autowired
	public PostServiceImpl(PostDao myPostDao) {
		super();
		this.myPostDao = myPostDao;
	}

	@Override
	public Post createPost(Post post) {
		
		return myPostDao.save(post);

	}

	@Override
	public void delete(Post post) {
		myPostDao.delete(post);

	}

	@Override
	public Post selectById(int id) {
		
		return myPostDao.findByPostId(id);
	}

	@Override
	public List<Post> selectByUserId(int userId) {
	
		return myPostDao.findByUserId(userId);
		
	}

	@Override
	public List<Post> selectAll() {
		
		return myPostDao.findAll();
		
	}

}
