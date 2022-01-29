package com.example.logger;

import java.util.ArrayList;
import java.util.List;

public class LogMessage {
	
	private String logMsg;
	private Logger logger;
	private List<Attribute> attributeList;
	private String className;
	
	private LogLevel logLevel;
	
	
	public LogMessage(Logger logger, String logMsg, String className, LogLevel logLevel) {
		this.logMsg = logMsg;
		this.logger = logger;
		this.className = className;
		this.logLevel = logLevel;
		this.attributeList = new ArrayList<>();
	}
	
	public LogMessage attr(String key, String value) {
		this.attributeList.add(new Attribute(key, value));
		return this;
	}
	
	public void log() {
		logger.log(this);
	}
	
	public String getString() {
		String msg =  String.format("{} : {} : {} {}", logLevel, className, logMsg, attributeList.toString());
		return msg;
	}

	public String getLogMsg() {
		return logMsg;
	}

	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}

	public List<Attribute> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(List<Attribute> attributeList) {
		this.attributeList = attributeList;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}
	
}
