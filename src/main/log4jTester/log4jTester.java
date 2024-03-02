package main.log4jTester;

import org.apache.log4j.Logger;

public class log4jTester {
	
	private static final Logger logger=Logger.getLogger(log4jTester.class);

	public static void main(String[] args) {
		System.out.println("log4j tester");
		logger.debug("debug LEVEL");
		logger.info("info LEVEL");
		logger.fatal("fatal LEVEL");
		logger.warn("warn LEVEL");
		logger.error("error LEVEL");
		

	}

}
