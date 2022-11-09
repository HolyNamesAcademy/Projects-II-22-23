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
		Post post = new Post();
		m.addAttribute("plant");

		List<String> listStatus = Arrays.asList("Alive", "Dead", "Watered", "Un-Watered");
		m.addAttribute("listStatus", listStatus);
		m.addAttribute("post", post);
		return "uploadPage";
	}
	@PostMapping("/uploadPage")
	public String submitUploadPage(@ModelAttribute("post") Post post){
		System.out.print(post);
		return "uploadSuccess";
	}
}
