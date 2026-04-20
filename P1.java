package lab2;

import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;

public class P1 {
	public static void main(String[] args) {
		HashMap< Integer,String> hashMap = new HashMap<>();
		hashMap.put(1,"Apple");
		hashMap.put(2,"Strawberry");
		hashMap.put(3,"Pear");
		hashMap.put(4,"Cucumber");
		hashMap.put(5,"Grapes");
	
		System.out.println("Iterating over entries:");
		for (Entry<Integer, String> entry : hashMap.entrySet()) {
		System.out.println("Key: "+entry.getKey() + " -> Value: " + entry.getValue());
		}
		
	}
	

}