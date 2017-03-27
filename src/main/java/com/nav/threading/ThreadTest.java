package com.nav.threading;

public class ThreadTest implements Runnable {

	public ThreadTest() {
		System.out.println("Inside ThreadTest Constructor");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		System.out.println("Start: Inside ThreadTest Thread " + Thread.currentThread() );
		
		System.out.println("Stop: Inside ThreadTest Thread " + Thread.currentThread() );
	}
	
	

}
