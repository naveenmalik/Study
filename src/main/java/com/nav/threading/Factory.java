package com.nav.threading;

public class Factory
{
	public static void main(String[] args){
		
		Item item = new Item();
		Consumer c1= new Consumer(item);
		Producer p1 = new Producer(item);
	}
}

class Item {
	
	private int count;
	
	public synchronized void produce(){
		count ++;
		
		System.out.println("Produced" + count);
		notify();
	}
	
	public synchronized void consume(){
		while(count==0)
		{
			try 
			{
				wait();
			} catch (InterruptedException e) 
			{				
				e.printStackTrace();
			}
		}		
		System.out.println("Consumed" + count);
		count --;
	}
}

class Producer implements Runnable{
	
	Item item;
	Producer(Item item){	
		this.item = item;
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	public void run(){		
		while(true)
		{
			item.produce();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

class Consumer implements Runnable{
	Item item;
	Consumer(Item item){
		this.item= item;
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	public void run(){
		while(true)
		{
			item.consume();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

