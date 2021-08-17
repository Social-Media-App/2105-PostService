package rev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import rev.dao.PostDao;
import rev.model.Post;
import rev.model.User;

@Service
public class PostServiceImpl implements PostService {
	
	private PostDao myPostDao;
	private RestTemplate restTemp = new RestTemplate();
	
	
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
		List<User> userList = new ArrayList<>();
		User[] userArr = restTemp.getForObject("http://localhost:9005/user-service/getallusers", User[].class);
		Collections.addAll(userList, userArr);
		List<Post> postList = myPostDao.findAll();
		for(Post tempPost: postList) {
			user:
			for(User tempUser: userList) {
				if(tempPost.getUserId()==tempUser.getUserId()) {
					tempPost.setPostOwner(tempUser);
					break user;
				}
			}
		}
		return postList;
		
	}

}
