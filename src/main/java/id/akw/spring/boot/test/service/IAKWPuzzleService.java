package id.akw.spring.boot.test.service;

/**
 * @author adhityo.kresno (AKW)
 *
 */
public interface IAKWPuzzleService {

	/**
	 * aTo check whether the string input is a palindrome or not
	 * 
	 * @param text
	 * @return
	 */
	public boolean isPalindrome(String text);

	/**
	 * aTo check whether the integer input is a palindrome or not
	 * 
	 * @param i
	 * @return
	 */
	public boolean isPalindrome(int i);

}
