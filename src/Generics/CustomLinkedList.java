package Generics;



public class CustomLinkedList<E> {

	private Node<E> head,tail;
	private int size;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element) {
			this.element = element;
		}
	}


	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e);
		newNode.next = head;
		head = newNode;
		size++;
		if(tail == null)
			tail = head;
	}

	
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if(tail == null){
			head = tail = newNode;
		}else{
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}
	
	public void add(int index, E e){
		if(index == 0) addFirst(e);
		else if (index >= size) addLast(e);
		else {
			Node<E> current = head;
			for(int i = 1; i < index; i++)
			{
				current = current.next;
			}
			Node<E> temp = current.next;
			(current.next).next = temp;
			size++;
		}
	}
	
	public E RemoveFirst() {
		if(size == 0) return null;
		else {
			Node<E> temp = head; //Keep the first node temporarily.
			head = head.next; //Move head to point to next node.
			size--;
			if(head == null) tail = null;
			return temp.element;
		}
	}
	
	
	
	

}
