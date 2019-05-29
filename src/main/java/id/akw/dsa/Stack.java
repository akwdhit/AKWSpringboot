package id.akw.dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adhityo.kresno (AKW)
 *
 */
public class Stack {

	/**
	 * aTo hold your elements
	 */
	List<Object> listObject;

	/**
	 * aIndex which element it is pointing currently
	 */
	int currentIndex;

	/**
	 * aDefault constructor
	 */
	public Stack() {
		// aCommon initiate
		listObject = new ArrayList<Object>();

		// aThe index is still behind the line currently, the first index should be 0 if
		// any element exists
		currentIndex = -1;
	}

	/**
	 * aPop out
	 * 
	 * @return
	 */
	public Object pop() {
		// aMake sure that the stack has contents already
		if (currentIndex >= 0) {
			// aGet the value first / getting the element's value
			Object temp = listObject.get(currentIndex);

			// aRemove the element from list
			listObject.remove(currentIndex);

			// aDecrease the index / step backward
			currentIndex--;

			// aReturn the object kept
			return temp;
		}

		// aNo element yet
		return null;
	}

	/**
	 * aPush in
	 * 
	 * @param object
	 */
	public void push(Object object) {
		// aIncrease the index
		currentIndex++;

		// aAdd the object into the list
		listObject.add(currentIndex, object);
	}

	/**
	 * aOverridding toString
	 */
	@Override
	public String toString() {
		return "Stack" + toStringContentOnly() + "";
	}

	/**
	 * aTo String
	 * 
	 * @return
	 */
	public String toStringContentOnly() {
		return ((listObject != null) ? listObject.toString() : "");
	}

}
