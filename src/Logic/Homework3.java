package Logic;

import java.util.Iterator;

import Generics.CustomLinkedList;
import Generics.GenericStack;
import Helper.Setup;
import Models.User;

public class Homework3 {
	
	public static void main(String[] args){
		//Homework#3 Problem 1
		////#1 Apply the GenericStack<E> as discussed in class, “add” 12 e-commerce customers and/or transactions
		//RunGenericStackExample();
		
		//HomeWork #2 Problem 2 : 
		//#2.  Create a new LinkedList ( and an associated ListIterator), store “add” 12 customers. 
		//“Remove” the customer(s) in the middle. 
		RunLinkedListExample();
		
		//#3.  Create a “queue”, “add” 12 customers, remove a couple customers in the middle. Maintain the same queueing order for the rest of customers.
		//user piorityQueue
		//RunQueueExample();
	}
	
	private static void RunQueueExample() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * HW#3 Problem 1
	 */
	private static void RunGenericStackExample() {
		GenericStack<User> stack= new GenericStack<User>();
		for(int i = 0; i < 12; i++)
		{
			User user = new User("jortiz");
			Setup.CreateRandomOrder(user);
			stack.push(user);
		}
		System.out.println("Building the stack");
		System.out.println("stack size: " + stack.getSize());
		
		
		//#2 Remove the fifth customer
		int originalStackSize = stack.getSize();
		GenericStack<User> tempStack = new GenericStack<User>();
		for(int j = 0; j < originalStackSize; j++)
		{
			if(j != 4){
				System.out.println("added element at index: " + j + " to the tempStack.");
				tempStack.push(stack.pop());
			}else{
				System.out.println("skipped over the fifth element");
			}
		}
		System.out.println("pushing to the  temp stack");
		System.out.println("stack size: " + stack.getSize());
		System.out.println("tempStack size: " + tempStack.getSize());
		
		
		for(int k = 0; k < originalStackSize-1; k++)
		{	
			User user = tempStack.pop();
			stack.push(user); 
		}
		System.out.println("Pushing to the original stack");
		System.out.println("tempStack size: " + tempStack.getSize());
		System.out.println("stack size: " + stack.getSize());
	}
	

	private static void RunLinkedListExample() {
		//Step 1 - Build the linked list with users and random orders
		CustomLinkedList<User> list = new CustomLinkedList<User>();
		Setup.SetupLinkedListData(list);
		
		
		//Step 2 - get the middle nodes
		int middleNodeIndex;
		middleNodeIndex = GetMiddleNodeIndex(list);
		
		System.out.println("Planning to remove node at index : " + middleNodeIndex);
		
		//Step 3 iterate over linked List
		int counter = 0;
		CustomLinkedList<User> filteredList = new CustomLinkedList<User>();
		if(!list.isEmpty()){
			Iterator<User> it = list.iterator();
			while(it.hasNext()){ 
				User u = it.next();
				System.out.println("retrieved User " + u.username.toString());
				Boolean didRemoveNode = TryRemoveMiddleNode(middleNodeIndex, counter, list);
				if(!didRemoveNode){
					filteredList.addLast(u);	//put linked list to a new list.
					System.out.println("Added element in index: " + counter);
				}	
					counter++;
				}
		}
		filteredList.print();
	}

	/**
	 * @param middleNodeIndex
	 * @param counter
	 * @param list
	 */
	private static Boolean TryRemoveMiddleNode(int middleNodeIndex, int counter, CustomLinkedList<User> list) {
		
		if(list.isEven()){
			if(counter == middleNodeIndex - 1 || 
					counter == (middleNodeIndex -2)){
				System.out.println("Skipped over element in index: " + counter);
				return true;
			}
		}	
		else {
			if(counter == middleNodeIndex) {
				System.out.println("Skipped over element in index: " + counter);
				return true;
			}
		}
		return false;
	}

	/**
	 * @param list
	 * @return
	 */
	private static int GetMiddleNodeIndex(CustomLinkedList<User> list) {
		int middleNodeIndex;
		if(list.isEven()){
			middleNodeIndex = (list.size() / 2) ;
		}else{
			middleNodeIndex = (int) Math.ceil(list.size()/2) ;
		};
		return middleNodeIndex;
	}
}
