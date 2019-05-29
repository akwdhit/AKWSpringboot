package id.akw.spring.boot.test.service;

import org.springframework.stereotype.Service;

/**
 * @author kresna1
 *
 */
@Service
public class AKWBubbleSortImpl implements IAKWBubbleSortService {

	@Override
	public Integer[] sort(Integer[] arr) {
		if (arr == null || arr.length <= 0) {
			return arr;
		}

		for (int i = 0; i < arr.length - 1; i++) {			// aRow iteration
			for (int j = 0; j < arr.length - i - 1; j++) {	// aColumn iteration
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		return arr;
	}

	/**
	 * aLocal test - turn to public if needed
	 * 
	 * @param args
	 */
	private static void main(String[] args) {
		AKWBubbleSortImpl test = new AKWBubbleSortImpl();

		Integer[] i = { 3, 4, 1, 10, 8 };
		test.sort(i);

		for (int j : i) {
			System.out.println(j);
		}
	}

}
