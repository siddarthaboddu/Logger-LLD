package com.example.logger;

import java.util.Queue;

public class SimpleLogger implements Logger{

	private Queue<LogMessage> logMessageQueue;
	private String className;
	
	public SimpleLogger(String className, Queue<LogMessage> logMessageQueue) {
		this.logMessageQueue = logMessageQueue;
		this.className = className;
	}
	
	@Override
	public LogMessage info(String msg) {
		return new LogMessage(this, msg, className, LogLevel.info);
	}
	
	@Override
	public void log(LogMessage logMessage) {
		logMessageQueue.add(logMessage);
	}

	@Override
	public LogMessage error(String msg) {
		return new LogMessage(this, msg, className, LogLevel.error);
	}

	@Override
	public LogMessage debug(String msg) {
		return new LogMessage(this, msg, className, LogLevel.debug);
	}

}
