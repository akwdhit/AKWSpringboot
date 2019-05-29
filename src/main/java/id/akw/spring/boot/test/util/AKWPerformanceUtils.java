/**
 * 
 */
package id.akw.spring.boot.test.util;

/**
 * @author kresna1
 *
 */
public class AKWPerformanceUtils {

	/**
	 * aTo return execution time
	 * 
	 * @param startTime
	 */
	public static double getExecutionTimeMs(long startTime) {
		long endTime = System.nanoTime();
		return ((endTime - startTime) / 1000000);
	}

	/**
	 * aTo print execution time
	 * 
	 * @param startTime
	 */
	public static void printExecutionTime(long startTime) {
		System.out.println("Execution Time: " + getExecutionTimeMs(startTime) + " ms");
	}

}
