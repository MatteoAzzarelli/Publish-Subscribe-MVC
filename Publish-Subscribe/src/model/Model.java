package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class Model implements IModel{
	
	private static Model instance = null;
	
	public static synchronized IModel instance() {
		if(instance == null) {
			instance = new Model();
		}
		return instance;
	}
	
	final ExecutorService executor = Executors.newFixedThreadPool(4);
	private List<MySubscription> subscriptions = Collections.synchronizedList(new ArrayList<MySubscription>());
	
	@Override
	public void subscribe(Subscriber<? super String> subscriber) {
		MySubscription subscription = new MySubscription(subscriber, executor);
		 
		subscriptions.add(subscription);
 
		subscriber.onSubscribe(subscription);
		
	}
	
	private class MySubscription implements Subscription {

		private final ExecutorService executor;

		private Subscriber<? super String> subscriber;
		
		public MySubscription(Subscriber<? super String> subscriber, ExecutorService executor) {
			this.subscriber = subscriber;
			this.executor = executor;
		}
		
		@Override
		public void cancel() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void request(long arg0) {
			// TODO Auto-generated method stub
			
		}

	}

}
