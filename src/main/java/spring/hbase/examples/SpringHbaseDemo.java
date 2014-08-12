package spring.hbase.examples;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHbaseDemo {

  private static final Log log = LogFactory.getLog(SpringHbaseDemo.class);

  public static void main(String[] args) throws Exception{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/application-context.xml", SpringHbaseDemo.class);
		log.info("Wordcount with HDFS copy Application Running");
		context.registerShutdownHook();

		UserUtils userUtils = context.getBean(UserUtils.class);		
		userUtils.initialize();
		userUtils.addUsers();
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		List<User> users = userRepository.findAll();
		System.out.println("Number of users = " + users.size());
		System.out.println(users);
  }
}
