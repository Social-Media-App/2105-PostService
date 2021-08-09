package rev.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="reply_comment")
public class ReplyComment {


	@Id
	@Column(name="reply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyId ;
	
	@Column(name="comment_id")
	private int CommentId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="post", nullable=false)
	private Post post;
	
	@Column(name="reply_content")
	private String replyContent;
	
	@Column(name="user_id")
	private int userId;
	
	
}
