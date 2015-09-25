package Logic;

import java.util.Iterator;
import java.util.PriorityQueue;


public class CustomPriorityQueue<E> extends PriorityQueue<E> {
	
	public CustomPriorityQueue<E> removeElementAtCenter() {
		CustomPriorityQueue<E> tempQ = new CustomPriorityQueue<E>();
		Iterator<E> it = (Iterator<E>) this.iterator();
		int counter = 1;
		int middle = this.size()/2;
		while(it.hasNext()){
			if(counter == middle)
				it.next();//this.poll();
			else
				tempQ.offer(it.next());
			counter++;
		}
		return tempQ;
	}
}
