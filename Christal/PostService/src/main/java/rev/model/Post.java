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
	private String Content;
	
	@Column(name="picture")
	private String Picture;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="date")
	private String  date;
	
	@Column(name="group_id")
	private int GroupId;
	
	@Column(name="auto_delete_date")
	private String autoDeleteDate;
	
	@Transient
	private User postOwner;
	

}


//Post Table:
//-Id
//-Content (text)
//-Picture 
//-User (FK)
//-Date
//-Group Id
//-Auto Delete date
//
//Likes for post table:
//-post Id (FK)
//-User (FK)
//
//Comment Table:
//-Id of the comment
//-Post id(FK)
//-Comment for the post (text)
//-user id (FK)
//
//Reply Table:
//-id 
//-Comment id (FK)
//-Post id(FK)
//-Reply content (text)
//-User id (FK)
//-Picture???