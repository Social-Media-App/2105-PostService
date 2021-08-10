package rev.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rev.model.Post;
import rev.model.ReplyComment;

@Repository
public interface ReplyCommentDao extends JpaRepository<ReplyComment, Integer>{

	public ReplyComment save(ReplyComment replyComment);
	public List<ReplyComment> findByCommentId(int commentId);
}
