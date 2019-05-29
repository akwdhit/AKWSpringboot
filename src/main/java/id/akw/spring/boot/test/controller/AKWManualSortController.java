package id.akw.spring.boot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.akw.spring.boot.test.service.IAKWBubbleSortService;

/**
 * @author adhityo.kresno (AKW)
 *
 */
@RestController
public class AKWManualSortController {

	@Autowired
	private IAKWBubbleSortService bubbleSortService;

	/**
	 * aGetting String as a response
	 * 
	 * @param arr
	 * @return
	 */
	@RequestMapping(value = "/bubbleSortString/{arr}", method = RequestMethod.GET)
	@ResponseBody
	public String bubbleSortString(@PathVariable Integer[] arr) {
		StringBuffer sb = new StringBuffer();

		if (arr != null && arr.length > 0) {
			sb.append(displayArray(arr));

			sb.append("After sort...").append(getLineSeparator());
			bubbleSortService.sort(arr);

			sb.append(displayArray(arr));
		} else {
			sb.append("Value is empty");
		}

		return sb.toString();
	}

	/**
	 * aGetting response entity
	 * 
	 * @param arr
	 * @return
	 */
	@RequestMapping(value = "/bubbleSort/{arr}", method = RequestMethod.GET)
	public ResponseEntity<Object> bubbleSort(@PathVariable Integer[] arr) {
		try {
			return new ResponseEntity<>(bubbleSortString(arr), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * aDisplaying the array
	 * 
	 * @param objs
	 * @return
	 */
	private String displayArray(Object[] objs) {
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;

		sb.append("The values are:").append(getLineSeparator());
		for (Object a : objs) {
			if (isFirst) {
				isFirst = false;
			} else {
				sb.append(getLineSeparator());
			}

			sb.append(a);
		}
		sb.append(getLineSeparator());

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
