package id.akw.spring.boot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.akw.spring.boot.test.service.IAKWPrintPatternService;
import id.akw.spring.boot.test.util.AKWPerformanceUtils;

/**
 * @author adhityo.kresno (AKW)
 *
 */
@RestController
public class AKWPrintPatternController {

	@Autowired
	private IAKWPrintPatternService printPatternService;

	/**
	 * aGetting String as a response
	 * 
	 * @param arr
	 * @return
	 */
	@RequestMapping(value = "/printPattern/{n}", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String bubbleSortString(@PathVariable Integer n) {
		StringBuffer sb = new StringBuffer();

		if (n != null && n > 0) {
			long startTime = System.nanoTime();

			sb.append(printPatternService.printPattern(n));
			sb.append(getLineSeparator());
			sb.append(printPatternService.printPatternWithPadding(n));
			sb.append(getLineSeparator());
			sb.append("Execution time: " + (int) AKWPerformanceUtils.getExecutionTimeMs(startTime) + " ms");
		} else {
			sb.append("AKW-ERR: Cannot process for n = null or n <= 0");
		}

		return sb.toString();
	}

	/**
	 * aGetting lineSeparator
	 * 
	 * @return
	 */
	private Object getLineSeparator() {
		// return System.lineSeparator();
		return "<br />";
	}

}
