package rev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rev.model.Post;
import rev.model.Utilities;
import rev.service.BookmarksService;
import rev.service.CommentService;
import rev.service.LikesService;
import rev.service.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
	
	private PostService postServ;
	private CommentService commentServ;
	private LikesService likesServ;
	private BookmarksService bookmarksServ;

	


	@Autowired
	public PostController(PostService postServ, CommentService commentServ, LikesService likesServ, BookmarksService bookmarksServ) {
		super();
		this.postServ = postServ;
		this.commentServ = commentServ;
		this.likesServ = likesServ;
		this.bookmarksServ = bookmarksServ;
	}
	
//	public PostController(PostService postServ) {
//		super();
//		this.postServ = postServ;
//	}
	
	
	//this method get all posts available
	@GetMapping(value="/getallposts")
	public @ResponseBody List<Post> getAllPosts(){
		System.out.println("Finding all posts");
		return postServ.selectAll();
	}
	
	



	//this method create a new post
	@PostMapping(value="/createpost")
	public @ResponseBody Post makeNewPost(@RequestBody Post post){
		System.out.println("Making a new post"+post);
		return postServ.createPost(post);
	}
	
	
	//this method get all posts available with their comments
		@GetMapping(value="/getpostsdetails")
		public @ResponseBody List<Utilities> getAllPostsWithComments(){
			System.out.println("Making a new post");
			List<Utilities> myObject=new ArrayList<>();
			Utilities utilities=null;
			for (Post post: postServ.selectAll()) {
				System.out.println(commentServ.findByPost(post));
				utilities=new Utilities(post,commentServ.findByPostId(post.getPostId()),likesServ.findAllLikeForPost(post), bookmarksServ.findAllBookmarksForPost(post));
				System.out.println(post);
				myObject.add(utilities);
			}
			
			return myObject; 
			
		}
		
}
