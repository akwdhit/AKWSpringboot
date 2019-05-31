package id.akw.spring.boot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.akw.spring.boot.test.service.IAKWPuzzleService;

/**
 * aList of Puzzle
 * 
 * @author adhityo.kresno (AKW)
 *
 */
@RestController("AKWPuzzleController")
@RequestMapping("puzzle")
public class AKWPuzzleController {

	@Autowired
	private IAKWPuzzleService puzzleService;

	/**
	 * aSmall util to return the line separator
	 * 
	 * @return
	 */
	private String getLineSeparator() {
		return "<br />";
	}

	/**
	 * aIs this text Palindrome?<br />
	 * <br />
	 * Try these links:<br />
	 * <ul>
	 * <li>http://localhost:8080/puzzle/palindromString/katak: true</li>
	 * <li>http://localhost:8080/puzzle/palindromString/akw: false</li>
	 * <li>http://localhost:8080/puzzle/palindromString/ada%20ada: true</li>
	 * </ul>
	 * 
	 * @param text
	 * @return
	 */
	@RequestMapping(value = "palindromString/{text}", method = RequestMethod.GET, produces = "text/html")
	public String isPalindrome(@PathVariable Object text) {
		StringBuffer sb = new StringBuffer();

		boolean isPalindrome = false;

		if (text instanceof String) {
			String input = (String) text;
			sb.append("Your input was: " + input + " - " + ((text != null) ? text.getClass() : "UNKNOWN"));

			isPalindrome = puzzleService.isPalindrome(input);
		} else {
			String toString = String.valueOf(text);
			sb.append("Your input was: " + toString + " - " + ((text != null) ? text.getClass() : "UNKNOWN"));

			isPalindrome = puzzleService.isPalindrome(toString);
		}
		sb.append(getLineSeparator());

		sb.append("Your input IS" + ((!isPalindrome) ? " NOT" : "") + " a palindrome");
		sb.append(getLineSeparator());

		return sb.toString();
	}

	/**
	 * aIs this int Palindrome?<br />
	 * <br />
	 * Try these links:<br />
	 * <ul>
	 * <li>http://localhost:8080/puzzle/palindromInt/12321: true</li>
	 * <li>http://localhost:8080/puzzle/palindromInt/123321: true</li>
	 * <li>http://localhost:8080/puzzle/palindromInt/1234567890: false</li>
	 * </ul>
	 * 
	 * @param text
	 * @return
	 */
	@RequestMapping(value = "palindromInt/{number}", method = RequestMethod.GET, produces = "text/html")
	public String isPalindrome(@PathVariable int number) {
		StringBuffer sb = new StringBuffer();

		boolean isPalindrome = false;

		Integer input = (Integer) number;
		sb.append("Your input was: " + input);

		isPalindrome = puzzleService.isPalindrome(input);
		
		sb.append(getLineSeparator());

		sb.append("Your input IS" + ((!isPalindrome) ? " NOT" : "") + " a palindrome");
		sb.append(getLineSeparator());

		return sb.toString();
	}

}
