package rev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
@Table(name="Bookmarks")
public class Bookmarks {
	
	@Id
	@Column(name="bookmark_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookmarksId;
	
	@Column(name="user_id")
	private int userId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="post", nullable=false)
	private Post post;

	@JsonIgnore
	public Post getPost() {
		return post;
	}

}
