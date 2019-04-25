package com.tony.singleton;

import java.util.concurrent.Callable;

public class MyCallableTask implements Callable<MySingleTon> {
	
    public MySingleTon call()  {
         
        return MySingleTon.getInstance();
    }
}