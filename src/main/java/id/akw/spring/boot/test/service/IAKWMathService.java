package id.akw.spring.boot.test.service;

/**
 * @author adhityo.kresno (AKW)
 *
 */
public interface IAKWMathService {

	/**
	 * aPower - but slow process
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Double powerSlow(Integer a, Integer b);

	/**
	 * aPower - faster process
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public Double powerFast(Integer a, Integer b);

}
