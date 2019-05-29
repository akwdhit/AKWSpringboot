package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/**
	 * aThis part is when you try to access localhost:8080
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot! I'm AKW anyway";
	}

}
