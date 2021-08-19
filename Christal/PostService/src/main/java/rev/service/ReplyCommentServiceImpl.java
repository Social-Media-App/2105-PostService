package rev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rev.dao.ReplyCommentDao;
import rev.model.Post;
import rev.model.ReplyComment;

@Service
public class ReplyCommentServiceImpl implements ReplyCommentService {

	ReplyCommentDao replyDao;
	
	
	@Autowired
	public ReplyCommentServiceImpl(ReplyCommentDao replyDao) {
		super();
		this.replyDao = replyDao;
	}

	@Override
	public ReplyComment replyComment(ReplyComment replyComment) {
		
		
		return replyDao.save(replyComment);
	}

	@Override
	public List<ReplyComment> findReplyByComment(int commentId) {
		
		return replyDao.findByCommentId(commentId);
	}

}
