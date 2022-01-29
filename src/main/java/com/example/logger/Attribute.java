package com.example.logger;

public class Attribute {

	String key;
	String value;
	
	public Attribute(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String toString() {
		return String.format("%s: %s", key, value);
	}
}
