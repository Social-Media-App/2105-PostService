package rev.service;

import java.util.List;

import rev.model.Bookmarks;
import rev.model.Post;

public interface BookmarksService {
	
	public Bookmarks bookmarkAPost(Bookmarks bookmark);
	public List<Bookmarks> findAllBookmarksForPost(Post post);

}