package id.akw.spring.boot.test.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * aService implementation for puzzle
 * 
 * @author adhityo.kresno (AKW)
 *
 */
@Service("AKWPuzzleImpl")
public class AKWPuzzleImpl implements IAKWPuzzleService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * id.akw.spring.boot.test.service.IAKWPuzzleService#isPalindrome(java.lang.
	 * String)
	 */
	@Override
	public boolean isPalindrome(String text) {
		if (!StringUtils.isEmpty(text)) {
			int length = text.length();

			if (length > 1) {
				for (int i = 0; i < length; i++) {
					int end = (length - 1) - i;

					// aCheck whether the front increment still not exceeding the back increment
					if (i < end && Character.toUpperCase(text.charAt(i)) != Character.toUpperCase(text.charAt(end))) {
						return false;
					}
				}

				return true;
			} else if (length == 1) {
				return true;
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see id.akw.spring.boot.test.service.IAKWPuzzleService#isPalindrome(int)
	 */
	@Override
	public boolean isPalindrome(int i) {
		int temp = i;

		for (int e = 9; e > 0; e--) { // aIncrement for exponent
			if (temp > Math.pow(10, e)) {
				// aOnly process if the 10.pow.e is lower than i
				
				// aProcessing upper limit
				int n1 = (int) Math.floor(temp / Math.pow(10, e));
				temp -= n1 * Math.pow(10, e);

				// aProcessing lower limit
				int n2 = temp % 10;
				temp -= n2;
				temp /= 10;

				if (n1 != n2) {
					return false;
				}
			}
		}

		return true;
	}

}
