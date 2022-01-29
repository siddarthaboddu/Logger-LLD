package com.example.logger;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class LoggerFactory {

	private static BlockingQueue<LogMessage> logMessageQueue;
	private static LogReceiver logAppender;
	
	private  static BlockingQueue<LogMessage> getLogMessageQueue(){
		if(logMessageQueue == null) {
			logMessageQueue = new ArrayBlockingQueue<>(10000);
		}
		return logMessageQueue;
	}
	
	private  static LogReceiver getLogAppender(){
		if(logAppender == null) {
			logAppender = new SimpleLogReceiver(getLogMessageQueue(), getOutputPrinterMap());
		}
		return logAppender;
	}
	
	private static HashMap<LogLevel, OutputPrinter> getOutputPrinterMap(){
		HashMap<LogLevel, OutputPrinter> map = new HashMap<>();
		map.put(LogLevel.info, new ConsoleOutputPrinter());
		map.put(LogLevel.debug, new ConsoleOutputPrinter());
		map.put(LogLevel.error, new ConsoleOutputPrinter());
		return map;
	}

	public static Logger getLogger(Class clazz) {
		
		BlockingQueue<LogMessage> logMessageQueue = getLogMessageQueue();
		LogReceiver logReceiver = getLogAppender();
		
		new Thread(()-> logReceiver.run()).start();
		
		
		Logger logger = new SimpleLogger(clazz.getName(), logMessageQueue);
	
		return logger;
		
	}
}
