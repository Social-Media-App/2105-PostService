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

import rev.model.Comment;
import rev.model.Post;
import rev.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {
	
	private CommentService commentServ;

	
	@Autowired
	public CommentController(CommentService commentServ) {
		super();
		this.commentServ = commentServ;
	}
	
	//this method get all comments by post
		@GetMapping(value="/getcomment")
		public @ResponseBody List<Comment> getCommentByPost(@RequestBody Post post){
			
			return commentServ.findByPost(post);
		}
		
		
		//this method create a new comment
		@PostMapping(value="/newcomment")
		public @ResponseBody Comment makeNewComment(@RequestBody Comment comment){
			
			return commentServ.save(comment);
		}
		//this method get all comments by post
		@GetMapping(value="/getAllcomment")
		public @ResponseBody List<Comment> getAllComments(){
			
			return commentServ.findAll();
		}
		
		
		
}
