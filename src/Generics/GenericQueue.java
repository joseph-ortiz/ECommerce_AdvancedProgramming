package Generics;

import java.util.Iterator;
import java.util.LinkedList;

public class GenericQueue<E>{
	private java.util.LinkedList<E> list = new LinkedList<>();
	
	public void enqueue(E e) {
		list.addLast(e);
	}
	
	public E dequeue() {
		return list.removeFirst();
	}
	
	public int getSize(){
		return list.size();
	}
	
	@Override
	public String toString() {
		return "Queue: " + list.toString();		
	}

	public void print() {
		String template = "\t User ID: " ;
		if(this.getSize() == 0) System.out.println("Empty list in the Queue");
		else{
			Iterator<E> it = this.list.iterator();
			while(it.hasNext()){
				E current = it.next();
				System.out.println(template + current.toString());
			}	
		}
		System.out.println("Size: " + this.getSize());
	}
}
