package id.akw.spring.boot.test.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import id.akw.dsa.Queue;
import id.akw.dsa.Stack;

/**
 * @author adhityo.kresno (AKW)
 *
 */
@RestController
public class AKWDSAController {

	/**
	 * aGet line separator
	 * 
	 * @return
	 */
	private Object getLineSeparator() {
		return "<br />";
	}

	/**
	 * aProcess as a queue.<br />
	 * <br />
	 * Try to call with: /queue/aku,coba,untuk,masukin,ini,ke,dalam,queue
	 * 
	 * @param objects
	 * @return
	 */
	@RequestMapping(value = "/queue/{objects}", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String processQueue(@PathVariable Object[] objects) {
		StringBuffer sb = new StringBuffer();

		Queue queue = new Queue();
		for (Object o : objects) {
			queue.enqueue(o);
		}
		sb.append("Queue after enqueue: " + queue);
		sb.append(getLineSeparator());

		Object o = queue.dequeue();
		while (o != null) {
			o = queue.dequeue();
		}
		sb.append("Queue after dequeue: " + queue);
		sb.append(getLineSeparator());

		return sb.toString();
	}

	/**
	 * aProcess as a stack<br />
	 * <br />
	 * Try to call with: /queue/aku,coba,untuk,masukin,ini,ke,dalam,stack
	 * 
	 * @param objects
	 * @return
	 */
	@RequestMapping(value = "/stack/{objects}", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String processStack(@PathVariable Object[] objects) {
		StringBuffer sb = new StringBuffer();

		Stack stack = new Stack();
		for (Object o : objects) {
			stack.push(o);
		}
		sb.append("Stack after push: " + stack);
		sb.append(getLineSeparator());

		Object o = stack.pop();
		while (o != null) {
			o = stack.pop();
		}
		sb.append("Stack after pop: " + stack);
		sb.append(getLineSeparator());

		return sb.toString();
	}
}
