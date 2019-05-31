package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * aDefault container
 * 
 * @author adhityo.kresno (AKW)
 *
 */
// aIn order to call it outside your spring boot runner, then you need to define the name to be able to be located by the context
@RestController("HelloController")
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
