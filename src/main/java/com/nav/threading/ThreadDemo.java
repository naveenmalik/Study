package com.nav.threading;

public class ThreadDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	/*	ThreadDemo d1 = new ThreadDemo();
		
		Thread test1 = new Thread ( new ThreadTest(), "test1" );
		Thread test2 = new Thread ( new ThreadTest(), "test2" );
		
		test1.start();		
		test2.sleep(300);
		test2.start();
		ArrayList<String> e1;
		System.out.println("Exiting Main");
*/

		Runnable run=new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside run");
			}
		};

		Thread t = new Thread(run);

		for(int i=0; i<10 ; i++){
			t.start();
		}
	}

}
