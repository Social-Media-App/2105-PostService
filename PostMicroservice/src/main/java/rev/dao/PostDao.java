package rev.dao;

import rev.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Integer> {

}
