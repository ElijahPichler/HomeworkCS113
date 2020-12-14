package Homework4;
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
  public void add(int index, E obj)
  { // Fill Here 
	  if(index > size || index < 0)
		  throw new IndexOutOfBoundsException();
	  
	  Node obj2 = new Node(obj);
	  
	  if(head == null) {
		  head = tail = obj2;
	  }else if(index == 0) {
		  obj2.next = head;
		  head.prev = obj2;
		  head = obj2;
	  }else if(index == size) {
		  obj2.prev = tail;
		  tail.next = obj2;
		  tail = obj2;
	  }else {
		  for(int i = 0; i< index; i++) 
			  head = head.next; 
			 
			  obj2.next = head.next;
			  head.next = obj2;
			  obj2.prev = head;
			  obj2.next.prev = obj2;
			 
		  
 
	  }
	  size++;
	  
   }
  /**
   * This method clears the list
   */
  public void clear() {
  	Node<E> trav = head;
  	while(trav != null) {
  		Node<E> next = trav.next;
  		trav.prev = trav.next = null;
  		trav.data = null;
  		trav = next;
  	}
  	head = tail = trav = null;
  	size = 0;

    }
  public void addFirst(E obj) { // Fill Here 
	  if(isEmpty() ) {
		  head = tail = new Node<E> (obj);
	  } else {
		  head.prev = new Node<E> (obj);
		  head = head.prev;
	  }
	  size++;

  }
  public boolean isEmpty() {
	  return size() == 0;
  }
  public void addLast(E obj) { // Fill Here\
	  if(isEmpty()) {
		  head = tail = new Node<E>(obj);
	  } else {
		  tail.next = new Node<E>(obj);
		  tail = tail.next;
	  }
	  size++;
  }
  

  public E get(int index) 
  { 	
	  if(index == 0)
		  throw new IndexOutOfBoundsException();
	  if(index < 0 || index >= size)
	  	  throw new IndexOutOfBoundsException();
	  	ListIterator<E> iter = listIterator(index); 
      	return iter.next();
  }  
  public E getFirst() { return head.data;  }
  public E getLast() { return tail.data;  }

  public int size() {  return size;  } // Fill Here

  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }

  public Iterator iterator() { return new ListIter(0);  }
  public ListIterator listIterator() { return new ListIter(0);  }
  public ListIterator listIterator(int index){return new ListIter(index);}
  public ListIterator listIterator(ListIterator iter)
  {     return new ListIter( (ListIter) iter);  }

  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
        
        
  }  // end class Node
  

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i)  // constructor for ListIter class
    {   if (i < 0 || i > size)
        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
        lastItemReturned = null;
 
        if (i == size)     // Special case of last item
        {     index = size;     nextItem = null;      }
        else          // start at the beginning
        {   nextItem = head;
            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
        }// end else
    }  // end constructor

    public ListIter(ListIter other)
    {   nextItem = other.nextItem;
        index = other.index;    }

    /**
     * This method checks if list has a next node
     */
    public boolean hasNext() {  
    	return nextItem != null;
    	    
    	} // Fill Here
   /**
    * this method checks if the list has a previous item
    */
    public boolean hasPrevious() {  
    	return (nextItem == null && size != 0) || nextItem.prev != null;  
    	} // Fill Here
    
    
    public int previousIndex() {  
    		return index-1;	
    } // Fill Here
    public int nextIndex() { 	
    	return index;    
    } // Fill here
    /**
     * Sets previous item to a new object
     */
    public void set(E o)  {
    	
    	if(lastItemReturned == null)
    		throw new IllegalStateException();
    	lastItemReturned.data = o;
    	
    	
    } 
    public void remove(){
    	
		if(lastItemReturned != null){
			if(lastItemReturned.prev == null){
				lastItemReturned.next.prev = null;
				head = lastItemReturned.next;
			}else if(lastItemReturned.next == null){
				lastItemReturned.prev.next = null;
				tail = lastItemReturned.prev;
			}else{
				lastItemReturned.prev.next = nextItem;
				nextItem.prev = lastItemReturned.prev;
			}
		}else
			throw new IllegalStateException();
		
    }      // not implemented
    /**
     * Moves the pointer to the next node and returns previous node
     */
    public E next()
    {  
    	if(!hasNext()) {
    		throw new NoSuchElementException();
    	}
    	lastItemReturned = nextItem;
    	nextItem = nextItem.next;
    	index++;
    	return lastItemReturned.data;
        
    }
    /**
     * This method moves the pointer back one slot and returns the lastItem data
     */
    public E previous() 
    {  
    	if(!hasPrevious()) 
    		throw new NoSuchElementException();
    	if(nextItem == null) 
    		nextItem = tail;
    	 else {
    		 nextItem = nextItem.prev;
    	 }
    	lastItemReturned = nextItem;
    	index--;
    	return lastItemReturned.data;
    	
    	 // Fill Here 
    }
    /**
     * This method adds an object to the list
     */
    public void add(E obj) {
    	
    	Node<E> newNode = new Node(obj);
    	if(head == null) {
    		head = newNode;
    		tail = newNode;
    	} else if(nextItem == head){
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    		tail = newNode;
    	}else {
    		newNode.prev = nextItem.prev;
    		nextItem.prev.next = newNode;
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    	
    	}
    	size++;
    // Fill Here
    }
    
    
    //EQUALS METHOD
    
    public boolean contains(Object o) {
    	Node<E> object = new Node(o);
    	Node<E> current = head;
    	while(current != null) {
    		if(current.data == object.data)
    			return true;
    		current = current.next;
    	}
    	return false;
    }
    public int indexOf(Object o) {
    	Node<E>  object = new Node(o);
    	Node<E>  current = head;
    	
    	if(head == null)
    		return -1;
    	for(int i = 0; i < size; i++) {
    		if(current.data == object.data)
    			return i;
    		current  = current.next;
    	}
    	
    	return -1;
    	
    }
    
    public int lastIndexOf(Object o) {
    	Node object = new Node(o);
    	Node current = head;
    	int foundIndex = -1;
    	if(head == null)
    		return -1;
    	for(int i = 0; i < size; i++) {
    		if(current.data == object.data)
    			foundIndex = i;
    		current  = current.next;
    	}
    	
    	return foundIndex;
    }
    
    public boolean isEmpty() {
    	return head == null;
    }
    
    public boolean remove(Object o) {
    	Node object = new Node(o);
    	Node current = head;
    	if(head.data == o) {
    		head = head.next;
    		size--;
    		return true;
    	}
    	while(current != null) {
    		if(current.data == o) {
    			current.prev.next = current.next;
    			current.next.prev = current.prev;
    			size--;
    			return true;
    		}
    		current = current.next;
    	}
    	return false;
    }
    
    public E set(int index, E element) {
    	Node current = head;
    	E dataRemoved = null;
    	if(index < 0 || index > size)
    		throw new NullPointerException();
    	for(int i = 0; i <size; i++) {
    		if(i == index) {
    			dataRemoved = (E) current.data;
    			current.data = element;
    		}
    		current = current.next;
    	}
    	return dataRemoved;
    }
    
  }// end of inner class ListIter
}// end of class DoubleLinkedList
