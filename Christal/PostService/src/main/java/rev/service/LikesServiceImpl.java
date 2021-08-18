package rev.service;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public Likes likeAPost(Likes likes) {
		boolean alreadyliked = likesDao.existsByUserIdAndPost(likes.getUserId(), likes.getPost());
		if(alreadyliked) {
			likesDao.deleteAllByUserIdAndPost(likes.getUserId(), likes.getPost());
			alreadyliked = likesDao.existsByUserIdAndPost(likes.getUserId(), likes.getPost());
			return null;
		}
			return likesDao.save(likes);
	}
	

	@Override
	public List<Likes> findAllLikeForPost(Post post) {
		
		return likesDao.findByPost(post);
	}
	
	

}
