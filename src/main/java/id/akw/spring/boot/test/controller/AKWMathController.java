package id.akw.spring.boot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.akw.spring.boot.test.service.IAKWMathService;
import id.akw.spring.boot.test.util.AKWPerformanceUtils;

/**
 * @author adhityo.kresno (AKW)
 *
 */
@RequestMapping(value = "/math")
@RestController
public class AKWMathController {

	@Autowired
	private IAKWMathService akwMathService;

	/**
	 * aSmall util - get line separator
	 * 
	 * @return
	 */
	private String getLineSeparator() {
		return "<br />";
	}

	/**
	 * aGet power result<br/ >
	 * <br />
	 * Try this: http://localhost:8080/math/power/12708704,20
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@RequestMapping(value = "/power/{a},{b}", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String getPower(@PathVariable Integer a, @PathVariable Integer b) {
		StringBuffer sb = new StringBuffer();

		sb.append("Input: pow(" + a + ", " + b + ")");
		sb.append(getLineSeparator());

		long startTime = System.nanoTime();
		sb.append("Slow process: " + akwMathService.powerSlow(a, b));
		sb.append(getLineSeparator());
		sb.append("Execution time: " + AKWPerformanceUtils.getExecutionTimeMs(startTime) + " ms");
		sb.append(getLineSeparator());

		startTime = System.nanoTime();
		sb.append("Fast process: " + akwMathService.powerFast(a, b));
		sb.append(getLineSeparator());
		sb.append("Execution time: " + AKWPerformanceUtils.getExecutionTimeMs(startTime) + " ms");
		sb.append(getLineSeparator());

		return sb.toString();
	}

}
