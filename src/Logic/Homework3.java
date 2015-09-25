package Logic;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

import Generics.CustomLinkedList;
import Generics.GenericQueue;
import Generics.GenericStack;
import Helper.Setup;
import Models.User;

public class Homework3 {
	
	public static void main(String[] args){
		
		/**
		 * Problem #1
		 * Apply the GenericStack<E> as discussed in class, 
		 * “add” 12 e-commerce customers and/or transactions
		 **/
		RunGenericStackExample();
		
		
		
		/**
		 * Problem #2
		 * Create a new LinkedList ( and an associated ListIterator), 
		 * store “add” 12 customers. 
		 * “Remove” the customer(s) in the middle. 
		 **/
		RunLinkedListExample();
		

		/**
		 * Problem #3.  
		 * Create a “queue”, “add” 12 customers, 
		 * remove a couple customers in the middle. 
		 * Maintain the same queueing order for the rest of customers.
		 */
		RunQueueExample();
	}
	
	

	

	/**
	 * HW#3 Problem 1
	 */
	private static void RunGenericStackExample() {
		
		//Step 1 - build the stack
		GenericStack<User> stack= new GenericStack<User>();
		Setup.SetupListData(stack, 12);
		
		//Step 2 - Remove the fifth customer
		int counter = 0;
		int fifthElement = 4;
		GenericStack<User> tempStack = new GenericStack<User>();
		System.out.println("\nRemoving the fifth element");
		while(!stack.isEmpty()){
			if(counter == fifthElement){
				//stack.pop();
				System.out.println(stack.pop().toString() + " Skipped");
			}
			else{
				User u = stack.pop();
				tempStack.push(u);
				//System.out.println(u.toString() + " pushed to the temp stack.");
			}	
			counter++;
		}

		
		//Step -3 push the filtered stack to the new stack to maintain order.
		System.out.println("\n\nPushing to the original stack");
		System.out.println("Final Stack");
		while(!tempStack.isEmpty()){
			User user = tempStack.pop();
			stack.push(user); 
			System.out.println(user.toString());
		}
	}
	
	/**
	 * HW#3 Problem 2
	 */
	private static void RunLinkedListExample() {
		//Step 1 - Build the linked list with users and random orders
		CustomLinkedList<User> list = new CustomLinkedList<User>();
		Setup.SetupListData(list, 12);

		//Step 2 - remove the middle node.
		CustomLinkedList<User>filteredList = list.removeMiddleNode();
		
		//Step 3 iterate over linked List
		filteredList.print();
	}	
	
	/**
	 * HW#3 Problem 3
	 * //Create a “queue”, “add” 12 customers, remove a couple customers in the middle. 
	 * Maintain the same queueing order for the rest of customers.
	 */
	
	private static void RunQueueExample() {		CustomPriorityQueue<User> queue = new CustomPriorityQueue<User>();
		queue = Setup.SetupListData(queue, 12);
		System.out.println("\n Built Queue");
		queue.forEach(x -> System.out.println("User: " + x.username + "with priority of " + x.getPriority()));
		
		CustomPriorityQueue<User> filteredQueue = queue.removeElementAtCenter();
		filteredQueue = filteredQueue.removeElementAtCenter();
		System.out.println("\n removed middle element");
		filteredQueue.forEach(x -> System.out.println("User: " + x.username + "with priority of " + x.getPriority()));
		
		
		System.out.println("\n removed another middle element");
		filteredQueue.forEach(x -> System.out.println("User: " + x.username + "with priority of " + x.getPriority()));
	}
}
