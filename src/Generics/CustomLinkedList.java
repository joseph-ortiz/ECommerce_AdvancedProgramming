package Generics;

import java.util.LinkedList;

public class CustomLinkedList<E> extends LinkedList<E> {

	public void print(){
		String template = "\t User ID: " ;
		if(this.isEmpty()) System.out.println("Empty list - No nodes in the list to print.");
		else{
			System.out.println(template + this.getFirst());
			while(this.iterator().hasNext()){
				System.out.println(template + this.getFirst());
			}	
		}
	}
	

}
