package rev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rev.model.Likes;
import rev.model.Post;
import rev.service.LikesService;

@RestController
@RequestMapping("/likes")
@CrossOrigin("*")
public class LikesController {
	
	private LikesService likesServ;

	@Autowired
	public LikesController(LikesService likesServ) {
		super();
		this.likesServ = likesServ;
	}
	
	
	//this method get the number of like by post
			@GetMapping(value="/getLikes")
			public @ResponseBody Integer getNbByPost(@RequestBody Post post){
				
				return (likesServ.findAllLikeForPost(post)).size();
			}
			
			//this method make new like to a given post
			@PostMapping(value="/makeLike")
			public @ResponseBody Likes makeLiket(@RequestBody Likes like){
				
				return likesServ.likeAPost(like);
			}
	

}
