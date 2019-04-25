package com.tony.singleton;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class MySingleTonTest {

	@Test
	public void testConcurrentDifferentThreads() throws Exception {
	 	  		
          //set 100 task inside each with MySingleton instance
		  final List<MyCallableTask> tasks = new ArrayList<>();
	      for (int i = 0; i < 100; i++) {
	        tasks.add(new MyCallableTask());
	      }
	     
	      //run tread pool to handle tasks concurrently
	      final ExecutorService executorService = Executors.newFixedThreadPool(8);
	      final List<Future<MySingleTon>> results = executorService.invokeAll(tasks);
	     
	      //verify
	      final MySingleTon expectedInstance = MySingleTon.getInstance();
	      for (Future<MySingleTon> res : results) {
	        final MySingleTon instance = res.get();
	        assertNotNull(instance);
	        assertSame(expectedInstance, instance);
	      }
	      
	      executorService.shutdown();
	}

}
