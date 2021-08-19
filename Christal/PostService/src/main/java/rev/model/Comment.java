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
import javax.persistence.Transient;

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
@Table(name="Comments")
public class Comment {


	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="post", nullable=false)
	private Post post;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="user_id")
	private int userId;
	
	@Transient
	private User commentedBy;

	public Comment(Post post, String comment, int userId) {
		super();
		this.post = post;
		this.comment = comment;
		this.userId = userId;
	}
	
	
}
