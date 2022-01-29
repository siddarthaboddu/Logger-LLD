package com.example.logger;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class SimpleLogReceiver implements LogReceiver{

	private BlockingQueue<LogMessage> logMessageQueue;

	private HashMap<LogLevel, OutputPrinter> logLevelToPrinter;

	public SimpleLogReceiver(BlockingQueue<LogMessage> logMessageQueue,  HashMap<LogLevel, OutputPrinter> logLevelToPrinter) {
		this.logLevelToPrinter = logLevelToPrinter;
		this.logMessageQueue = logMessageQueue;

	}
	
	public void run() {
		while(true) {
			LogMessage logMessage = null;
			try {
				logMessage = logMessageQueue.poll(10, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(logMessage != null)
				print(logMessage);
		}
	}
	
	private void print(LogMessage logMessage) {
		
		OutputPrinter outputPrinter = logLevelToPrinter.get(logMessage.getLogLevel());
		outputPrinter.print(logMessage);
	}
}
