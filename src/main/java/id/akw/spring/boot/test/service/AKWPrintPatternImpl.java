package id.akw.spring.boot.test.service;

import org.springframework.stereotype.Service;

/**
 * @author adhityo.kresno (AKW)
 *
 */
@Service
public class AKWPrintPatternImpl implements IAKWPrintPatternService {

	/**
	 * aSmall util to return line separator
	 * 
	 * @return
	 */
	private String getLineSeparator() {
		return "<br />";
	}

	@Override
	public String printPattern(int n) {
		StringBuffer sb = new StringBuffer();

		for (int r = 0; r < n; r++) { // aRepeating the row
			for (int c1 = 0; c1 < (r + 1); c1++) { // aRepeating the column / star
				sb.append("*");
			}

			// aGet a new line
			sb.append(getLineSeparator());
		}

		return sb.toString();
	}

	@Override
	public String printPatternWithPadding(int n) {
		StringBuffer sb = new StringBuffer();

		for (int r = 0; r < n; r++) { // aRepeating the row
			for (int c2 = (n - r - 1); c2 > 0; c2--) {
				sb.append("O");
			}

			for (int c1 = 0; c1 < (r + 1); c1++) { // aRepeating the column / star
				sb.append("*");
			}

			// aGet a new line
			sb.append(getLineSeparator());
		}

		return sb.toString();
	}

}
