package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class MainController {
	@Autowired
	private SqlDB sqlDB;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);

		return "hello";
	}

	@GetMapping ("/uploadPage")
	public String uploadPage(Model m){
		Post post = new Post(); // needs arguments but if i keep the default then the upload success page doesn't work
		m.addAttribute("plant");

		List<String> listStatus = Arrays.asList("Alive", "Dead", "Watered", "Un-Watered");
		m.addAttribute("post", post);
		m.addAttribute("listStatus", listStatus);

		return "uploadPage";
	}

	@PostMapping("/uploadPage")
	public String submitUploadPage(@ModelAttribute("post") Post post, Model m){
		m.addAttribute("Age", post.getAge());
		m.addAttribute("PlantName", post.getPlantName());
		m.addAttribute("Species", post.getSpecies());
		m.addAttribute("NameOfUser", post.getNameOfUser());
		m.addAttribute("Caption", post.getCaption());
		m.addAttribute("PhotoUrl", post.getPhotoUrl());
		System.out.print(post);

		sqlDB.uploadPost(post);
		return "uploadSuccess";
	}

	/* function httpGet(Url)
	{
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open( "GET", https://house-plants.p.rapidapi.com/common/coralberry, false ); // false for synchronous request
		xmlHttp.send( https://house-plants.p.rapidapi.com/common/coralberry );
		return xmlHttp.responseText;
	}
	HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	public respHttpResponse<String> getResponse() {return response;}
	 */

/*
	@GetMapping("/feed")
	public String feed(@RequestParam(name="Clarence", required=false, defaultValue="planty") String name, Model model){
		model.addAttribute("Clarence", name);
		Post plant1 = new Post(01, 01, 00, "plantbert", "green", "not green", "Alana", "pretty dead", "https://asset.bloomnation.com/c_pad,d_vendor:global:catalog:product:image.png,f_auto,fl_preserve_transparency,q_auto/v1627197230/vendor/2864/catalog/product/2/0/20200304122155_file_5e5ef4a3ccb60_5e5ef7b7cd5fa_600b664eac11a._600b6650be20c..jpg");
		Post plant2 = new Post(02, 02, 00, "Belle-adona", "~~blue belle*&^$#@", "livin' life to the fullest", "Alana", "IM BLUE`*%@^!", "https://www.woodlandtrust.org.uk/media/4272/bluebells-close-up-wtml-1024791-web-upload.jpg");

		ArrayList<Post> posts = new ArrayList<>();
		posts.add(plant1);
		posts.add(plant2);
		model.addAttribute(posts);


		ArrayList<Post> posts = new ArrayList<Post>();
		//posts = sqlDB.viewPosts();
		posts.add(plant1);
		posts.add(plant2);
		model.addAttribute("posts", posts);

		//return "/feed";
	}

 */



	@GetMapping("/feed") // Elizabeth's testing for viewPost (not working)
	public String feed(@RequestParam(name="Clarence", required=false, defaultValue="planty") String name, Model model){
		model.addAttribute("Clarence", name);

		Post plant1 = new Post(01, 01, 00, "plantbert", "green", "not green", "Alana", "pretty dead", "https://asset.bloomnation.com/c_pad,d_vendor:global:catalog:product:image.png,f_auto,fl_preserve_transparency,q_auto/v1627197230/vendor/2864/catalog/product/2/0/20200304122155_file_5e5ef4a3ccb60_5e5ef7b7cd5fa_600b664eac11a._600b6650be20c..jpg");
		Post plant2 = new Post(02, 02, 00, "Belle-adona", "~~blue belle*&^$#@", "livin' life to the fullest", "Alana", "IM BLUE`*%@^!", "https://www.woodlandtrust.org.uk/media/4272/bluebells-close-up-wtml-1024791-web-upload.jpg");

		ArrayList<Post> posts = new ArrayList<>();
		posts.add(plant1);
		posts.add(plant2);
		model.addAttribute(posts);

		TreeMap<Integer, Post> post = sqlDB.viewPosts();
		for (int i = 1; i < 2; i++) {// the starting postID value in the database is 1 (lowest value there)
			Post plant = post.get(i);
			posts.add(plant);
			System.out.print(plant.PlantName);
			System.out.print(plant.PhotoUrl);
			System.out.println(plant.Caption);
		}

		model.addAttribute("posts", posts);
		return "/feed";
	}

	@GetMapping("/test") // this successful prints the wanted array
	public String test(Model m) {
		TreeMap<Integer, Post> post = sqlDB.viewPosts();

		ArrayList<Post> posts = new ArrayList<>();
		for (int i = 0; i < post.size(); i++) {
			Post plant = post.get(i);
			posts.add(plant);

		}

		for(Post p : posts) {
			System.out.println(p);
		}
		return "index";
	}
}