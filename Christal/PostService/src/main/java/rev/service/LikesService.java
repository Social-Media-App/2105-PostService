package rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rev.model.Likes;
import rev.model.Post;


public interface LikesService {
	public Likes likeAPost(Likes likes);
	public List<Likes> findAllLikeForPost(Post post);
	
}
