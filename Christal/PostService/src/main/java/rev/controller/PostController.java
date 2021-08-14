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

import rev.model.Post;
import rev.service.PostService;

@RestController
@RequestMapping("/post-service")
@CrossOrigin("*")
public class PostController {
	
	private PostService postServ;

	@Autowired
	public PostController(PostService postServ) {
		super();
		this.postServ = postServ;
	}
	
	
	//this method get all posts available
	@GetMapping(value="/getallposts")
	public @ResponseBody List<Post> getAllPosts(){
		System.out.println("Finding all posts");
		return postServ.selectAll();
	}
	
	
	//this method create a new post
	@PostMapping(value="/createpost")
	public @ResponseBody Post makeNewPost(@RequestBody Post post){
		System.out.println("Making a new post");
		return postServ.createPost(post);
	}
	
	
	
	
}
