package view;

import java.util.concurrent.Flow.Subscription;


public class View implements IView{

	private static View instance = null;
	
	public static synchronized IView instance() {
		if(instance == null) {
			instance = new View();
		}
		return instance;
	}
	
	
	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSubscribe(Subscription arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNext(String arg0) {
		// TODO Auto-generated method stub
		
	}

}
