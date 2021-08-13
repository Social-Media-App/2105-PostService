package rev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rev.model.Comment;
import rev.model.ReplyComment;
import rev.service.ReplyCommentService;

@RestController
@RequestMapping("/replycomment")
public class ReplyCommentController {

	private ReplyCommentService replyServ;

	@Autowired
	public ReplyCommentController(ReplyCommentService replyServ) {
		super();
		this.replyServ = replyServ;
	}
	
	
	//this method get all replies by comment
		@GetMapping(value="/getreply")
		public @ResponseBody List<ReplyComment> getReplyByComment(@RequestBody Comment comment){
			
			return replyServ.findReplyByComment(comment.getCommentId());
		}
		
		
		//this method create a new comment
		@PostMapping(value="/newreply")
		public @ResponseBody ReplyComment replyComment(@RequestBody ReplyComment replyComment){
			
			return replyServ.replyComment(replyComment);
		}
		
	
}
