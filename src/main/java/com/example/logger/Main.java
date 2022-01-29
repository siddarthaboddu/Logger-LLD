package com.example.logger;

public class Main {

	static Logger log = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		

		log.info("Hello World").log();
		
		log.info("Hello World").attr("key1", "val1").log();
		
		log.error("Hello World").log();
		
		
	}
}
