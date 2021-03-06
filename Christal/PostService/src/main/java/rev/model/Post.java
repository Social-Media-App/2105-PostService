package rev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="Posts")
public class Post {
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@Column(name="content")
	private String content;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="date")
	private String  date;
	
	@Column(name="group_id")
	private int groupId;
	
	@Column(name="auto_delete_date")
	private String autoDeleteDate;
	
	@Transient
	private User postOwner;

}