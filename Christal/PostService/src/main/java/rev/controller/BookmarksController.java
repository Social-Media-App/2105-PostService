package rev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rev.model.Bookmarks;
import rev.model.Post;
import rev.service.BookmarksService;


@RestController
@RequestMapping("/bookmarks")
@CrossOrigin("*")
public class BookmarksController {
	
	private BookmarksService bookmarksServ;

	@Autowired
	public BookmarksController(BookmarksService bookmarksServ) {
		super();
		this.bookmarksServ = bookmarksServ;
	}
	
	
	//this method get the number of bookmark by post
			@GetMapping(value="/getBookmarks")
			public @ResponseBody List<Bookmarks> getNbByPost(@RequestBody Post post){
				
				return (bookmarksServ.findAllBookmarksForPost(post));
			}
			
			//this method make new bookmark to a given post
			@PostMapping(value="/makeBookmark")
			public @ResponseBody Bookmarks makeBookmark(@RequestBody Bookmarks bookmark){
				
				return bookmarksServ.bookmarkAPost(bookmark);
			}		

}
