package service;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MainController {
	@Autowired
	private SqlDB sqlDB;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";


	}


	//@GetMapping("/api")
	//public String callAPI() {
		//plantAPi.api();
		//return "Hello";
	//}
	//@GetMapping("/api")
	//public void fillApi() throws IOException, InterruptedException, ParseException {
	//ArrayList<speciesInfo> plants = dataReader.jsonReaderGetAll(plantAPi.getAll());
	//sqlDB.insertMultipleSpecies(plants);
	//public void testSearch(){
		//String name = "Janet Craig";
		//speciesInfo plant;
		//plant = sqlDB.selectSingleSpecies(name);
		//System.out.println(plant.getImgUrl() + "\n" + plant.getCommonName() + "\n" + plant.getLatinName() + "\n" + plant.getClimate() + "\n" + plant.getOrigin() +"\n" + plant.getFamily());
	//}
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

}