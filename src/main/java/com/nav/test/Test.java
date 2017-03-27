package com.nav.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {

enum oddeven {odd, even, all};
	public static void main (String[] args) {
	
		Set<String> s = new HashSet<String>();
		
		Iterator iter = s.iterator();
		
		
		
	Light L1 = new NeonLight();
	
	System.out.println(L1.type);
	L1.getBill();
	
	System.out.println(oddeven.odd);
	
	}
	
	
	/**
	 * @param args
	 */
	public static void main1 (String[] args) {
		
		List a1 = Collections.EMPTY_LIST;
		HashMap h1 = new HashMap();
		Light l1 = new Light();
		//System.out.println(a1);
		String a = new String("test");
		Integer i = 5;
		String name = "NM";
		h1.put(null, l1);
		h1.put("test", a);
		h1.put(1, 5);
		
//		System.out.println(h1);
//	l1.type = " TEMP";
//		System.out.println(h1);
//		
//		Map m = Collections.unmodifiableMap(h1);
//		
//		l1.type = "ALTER";
//		System.out.println(m);
//		
//		
//		Hashtable h2 = new Hashtable();
//		
//		h2.put("temp", 1);
//		
//		System.out.println(h2);

		
		Light l2 = (Light) l1.Clone();
		
		System.out.println(l1==l2);
		//l1.type="New Light";
		
		System.out.println(l1);
		System.out.println(l2);
	

	}

}
class Light implements Cloneable
{
	int[] myArray;
	String type ="Light";
	
	public void getBill(int hours){
		System.out.println("Light getBill hours");
	}
	public void getBill(){
		System.out.println("Light getBill");
		
	}
	
	public String toString()
	{
		return type;
	}
	
	public Object Clone()
	{
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
}

class TubeLight extends Light
{
	String type="TubeLight";
	
	public void getBill(int hours){
		System.out.println("TubeLight getBill hours");
	}
	public void getBill(){
		System.out.println("TubeLight getBill");
	}
}

class NeonLight extends TubeLight
{
	String type="NeonLight";
	
	public void getBill(int hours){
		System.out.println("NeonLight getBill hours");
	}
	public void getBill(){
		System.out.println("NeonLight getBill");
	}
}
