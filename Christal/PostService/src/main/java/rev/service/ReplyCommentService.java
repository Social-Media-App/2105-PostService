package rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rev.model.Post;
import rev.model.ReplyComment;


public interface ReplyCommentService {
	
	public ReplyComment replyComment(ReplyComment replyComment);
	public List<ReplyComment> findReplyByComment(int commentId);

}
