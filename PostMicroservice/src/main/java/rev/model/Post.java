package rev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sm_post")
public class Post {
	
	@Id
    @Column(name="sm_post_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int postId;

}
