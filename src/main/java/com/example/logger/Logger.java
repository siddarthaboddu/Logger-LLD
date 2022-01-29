package com.example.logger;

public interface Logger {

	public LogMessage info(String msg);
	
	public void log(LogMessage logMessage);
	
	public LogMessage error(String msg);
	public LogMessage debug(String msg);
	
}
