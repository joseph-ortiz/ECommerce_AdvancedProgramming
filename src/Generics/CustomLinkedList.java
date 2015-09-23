package Generics;

import java.util.Iterator;
import java.util.LinkedList;

public class CustomLinkedList<E> extends LinkedList<E> {

	public void print(){
		String template = "\t User ID: " ;
		if(this.isEmpty()) System.out.println("Empty list - No nodes in the list to print.");
		else{
			Iterator<E> it = this.iterator();
			while(it.hasNext()){
				E current = it.next();
				System.out.println(template + current.toString());
				
			}	
		}
		System.out.println("Size: " + this.size());
	}

	public  boolean isEven() {
		Boolean isEven;
		if(this.size() % 2 == 0){
			isEven = true;
		}else{
			isEven = false;
		}
		return isEven;
	}
}
