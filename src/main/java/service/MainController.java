package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

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
		return "hello";}
	@GetMapping ("/uploadPage")
	public String uploadPage(Model m){
		Post post = new Post(); // needs arguments but if i keep the default then the upload success page doesnt work
		m.addAttribute("plant");

		List<String> listStatus = Arrays.asList("Alive", "Dead", "Watered", "Un-Watered");
		//m.addAttribute("post", post);
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
		return "uploadSuccess";
	}
}
