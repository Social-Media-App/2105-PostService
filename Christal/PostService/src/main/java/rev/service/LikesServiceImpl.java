package rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rev.dao.LikesDao;
import rev.model.Likes;
import rev.model.Post;

@Service
public class LikesServiceImpl implements LikesService {
	
	private LikesDao likesDao;
	
	
	@Autowired
	public LikesServiceImpl(LikesDao likesDao) {
		super();
		this.likesDao = likesDao;
	}

	@Override
	public Likes likeAPost(Likes likes) {
		
		return likesDao.save(likes);
	}

	@Override
	public List<Likes> findAllLikeForPost(Post post) {
		
		return likesDao.findByPost(post);
	}

}
