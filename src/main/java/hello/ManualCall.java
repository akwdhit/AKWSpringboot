package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import id.akw.spring.boot.test.controller.AKWPuzzleController;

/**
 * aLearn to call the spring from static void main instead of calling it by
 * spring boot runner
 * 
 * @author adhityo.kresno (AKW)
 *
 */
public class ManualCall {

	/**
	 * aThe main method to be called.<br />
	 * <br />
	 * Inspired by: <br />
	 * https://howtodoinjava.com/spring-core/how-to-use-spring-component-repository-service-and-controller-annotations/
	 * <br />
	 * https://stackoverflow.com/questions/28414234/where-can-i-find-the-example-applicationcontext-xml-file/28418012
	 * <br />
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// EmployeeManager manager = (EmployeeManager)
		// context.getBean(EmployeeManager.class);

		// OR this will also work

		HelloController helloController = (HelloController) context.getBean("HelloController");
		helloController = (HelloController) context.getBean(HelloController.class);

		AKWPuzzleController puzzleController = (AKWPuzzleController) context.getBean(AKWPuzzleController.class);

		System.out.println(helloController.index());
		System.out.println(puzzleController.isPalindrome("KATAK"));
		System.out.println(puzzleController.isPalindrome("123321"));
	}

}
