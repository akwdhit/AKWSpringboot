package id.akw.dsa;

/**
 * @author adhityo.kresno (AKW)
 *
 */
public class Queue {

	/**
	 * aThe stack to hold the element for queue
	 */
	private Stack stack;

	/**
	 * aDefault constructor
	 */
	public Queue() {
		stack = new Stack();
	}

	/**
	 * aEnqueue - insert a new object in the back queue
	 * 
	 * @param object
	 */
	public void enqueue(Object object) {
		// aDefine a temporary stack, just to make sure that
		Stack tempReversedStack = new Stack();

		// aIf stack is not null, we continue
		if (stack != null) {
			// aGet the element popped
			Object currentObject = stack.pop();

			// aIf it exists, put it into reversed stack
			while (currentObject != null) {
				tempReversedStack.push(currentObject);
				currentObject = stack.pop();
			}
		}

		// aFor original stack, put the object we want to put
		stack.push(object);

		// aPut all the rest that has been temporarily put into reversedStack back to
		// original stack
		if (tempReversedStack != null) {
			Object currentObject = tempReversedStack.pop();

			while (currentObject != null) {
				stack.push(currentObject);
				currentObject = tempReversedStack.pop();
			}
		}
	}

	/**
	 * aDequeue - take the first in
	 * 
	 * @return
	 */
	public Object dequeue() {
		return stack.pop();
	}

	/**
	 * aTo string
	 */
	@Override
	public String toString() {
		return "Queue" + toStringContentOnly() + "";
	}

	/**
	 * aTo String
	 * 
	 * @return
	 */
	public String toStringContentOnly() {
		return stack.toStringContentOnly();
	}

}
