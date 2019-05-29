package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"id.akw.spring.boot.test", "hello"})
@SpringBootApplication
public class Application {

	/**
	 * aThis part is called by the startup, when you do java -jar
	 * akw-spring-boot-test.jar
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		/*
		 * System.out.println("Let's inspect the beans provided by Spring Boot:");
		 * 
		 * String[] beanNames = ctx.getBeanDefinitionNames(); Arrays.sort(beanNames);
		 * for (String beanName : beanNames) { System.out.println(beanName); }
		 */

		System.out.println("I'm starting...");
	}

}
