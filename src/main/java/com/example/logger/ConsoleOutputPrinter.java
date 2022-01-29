package com.example.logger;

public class ConsoleOutputPrinter implements OutputPrinter {

	@Override
	public void print(LogMessage logMessage) {
		System.out.println(String.format("%s %s %s", logMessage.getLogLevel(), logMessage.getLogMsg(), logMessage.getAttributeList()));
	}

}
