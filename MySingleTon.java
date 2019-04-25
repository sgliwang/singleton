package com.tony.singleton;
 
public class MySingleTon {
 
	private static final MySingleTon instance = new MySingleTon ();
 
	protected MySingleTon () {
	}
 
	public static MySingleTon getInstance() {
		return instance;
	}

}