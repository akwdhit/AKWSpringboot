package id.akw.junit.spring.boot.test.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import id.akw.spring.boot.test.service.AKWPuzzleImpl;
import id.akw.spring.boot.test.service.IAKWPuzzleService;

/**
 * aJunit to test service of Puzzle
 * 
 * @author adhityo.kresno (AKW)
 *
 */
public class AKWPuzzleImplTest {

	/**
	 * aPuzzle Service instance
	 */
	private IAKWPuzzleService puzzleService;

	/**
	 * aDefining the test case here
	 */
	private Map<String, Boolean> testCaseString;

	/**
	 * aDefining the test case here
	 */
	private Map<Integer, Boolean> testCaseInt;

	/**
	 * aWith this @After annotation, it will be called when this class is closed (it
	 * replaces the method tearDown)
	 */
	@After
	public void finish() {
		System.out.println("Shutting down...");
	}

	/**
	 * aWith this @Before annotation, it will be called when this class is initiated
	 * (it replaces the method setup)
	 */
	@Before
	public void startup() {
		System.out.println("Initializing...");

		puzzleService = new AKWPuzzleImpl();

		testCaseString = new HashMap<String, Boolean>();
		testCaseString.put("katak", true);
		testCaseString.put("KATAK", true);
		testCaseString.put("kaTAk", true);
		testCaseString.put("BUkan Palindrome", false);
		testCaseString.put("A A", true);
		testCaseString.put("KOdok", true);
		testCaseString.put("APA", true);
		testCaseString.put("Ahsiap", false);
		testCaseString.put("Sunny", false);
		testCaseString.put("LUCU", false);
		testCaseString.put("LUCUL", true);

		testCaseInt = new HashMap<Integer, Boolean>();
		testCaseInt.put(12321, true);
		testCaseInt.put(123321, true);
		testCaseInt.put(1234567890, false);
		testCaseInt.put(111111112, false);
	}

	/**
	 * aTo test Palindrome of String
	 */
	@Test
	public void testIsPalindromeString() {
		System.out.println("Starting palindrome string test");

		for (Entry<String, Boolean> entry : testCaseString.entrySet()) {
			Boolean result = puzzleService.isPalindrome(entry.getKey());
			System.out.println("Kata '" + entry.getKey() + "' adalah " + ((!result) ? "Bukan " : "") + "Palindrome");
			assertEquals(result, entry.getValue());
		}
	}

	/**
	 * aTo test Palindrome of Integer
	 */
	@Test
	public void testIsPalindromeInteger() {
		System.out.println("Starting palindrome int test");

		for (Entry<Integer, Boolean> entry : testCaseInt.entrySet()) {
			Boolean result = puzzleService.isPalindrome(entry.getKey());
			System.out.println("Kata '" + entry.getKey() + "' adalah " + ((!result) ? "Bukan " : "") + "Palindrome");
			assertEquals(result, entry.getValue());
		}
	}

}
