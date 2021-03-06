package rev.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rev.dao.BookmarksDao;
import rev.model.Bookmarks;
import rev.model.Post;

@Service
public class BookmarksServiceImpl implements BookmarksService {
	
	@Autowired
	private BookmarksDao bookmarksDao;
	
	

	@Override
	@Transactional
	public Bookmarks bookmarkAPost(Bookmarks bookmark) {
		boolean alreadybookmarked = bookmarksDao.existsByUserIdAndPost(bookmark.getUserId(), bookmark.getPost());
		if(alreadybookmarked) {
			bookmarksDao.deleteAllByUserIdAndPost(bookmark.getUserId(), bookmark.getPost());
			alreadybookmarked = bookmarksDao.existsByUserIdAndPost(bookmark.getUserId(), bookmark.getPost());
			return null;
		}
			return bookmarksDao.save(bookmark);
	}

	@Override
	public List<Bookmarks> findAllBookmarksForPost(Post post) {
		return bookmarksDao.findByPost(post);
	}

}
