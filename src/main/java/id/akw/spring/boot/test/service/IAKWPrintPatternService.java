package id.akw.spring.boot.test.service;

/**
 * @author adhityo.kresno (AKW)
 *
 */
public interface IAKWPrintPatternService {

	/**
	 * aFor input n = 3<br />
	 * <br />
	 * *<br />
	 * **<br />
	 * ***<br />
	 * 
	 * @param n
	 * @return
	 */
	public String printPattern(int n);

	/**
	 * aFor input n = 3<br />
	 * <br />
	 * 00*<br />
	 * 0**<br />
	 * ***<br />
	 * 
	 * @param n
	 * @return
	 */
	public String printPatternWithPadding(int n);

}
