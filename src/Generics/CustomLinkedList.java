package Generics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Models.User;

public class CustomLinkedList<E> extends LinkedList<E> {

	public void print(){
		if(this.isEmpty()){
			System.out.println("Empty list");
		}else{
			System.out.println("\n");
			Iterator<E> it = this.iterator();
			while(it.hasNext()){
				E current = it.next();
				System.out.println(current.toString());
			}	
		}
		System.out.println("Size: " + this.size());
	}
	public CustomLinkedList<E> removeMiddleNode() {
		int counter = 1;
		CustomLinkedList<E> tempList = new CustomLinkedList<E>();
		int middle = this.size()/2;
		Iterator<E> it = this.iterator();
		while(it.hasNext()){ 
			if(counter == middle){
				System.out.println("\nskipping over " + it.next().toString());
			}else{
				tempList.add(it.next());
			}	
			counter++;
		}
		return tempList;
	}
}
