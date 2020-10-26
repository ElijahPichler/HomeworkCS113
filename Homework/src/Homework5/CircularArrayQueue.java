package Homework5;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Queue;

public class CircularArrayQueue<E> implements Queue<E> {
	Object list[];
	int index = 0;
	
	public CircularArrayQueue() {
		list = new Object[10];
	}
	
	public CircularArrayQueue(int size) {
		list = new Object[size];
	}
	
	
	@Override
	
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.length == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.length;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		if(list.length == index) {
			Object[] newArray =  new Object[list.length * 2];
			for(int i = 0; i < index; i++) {
				newArray[i] =  list[i];
			}
			list = newArray;
			list[index++] = arg0;
			return true;
		}else {
		list[index++] = arg0;
		return true;
		}
		
	}

	@Override
	public E element() {
		// TODO Auto-generated method stub
		if(index == 0)
			throw new NoSuchElementException();
		return (E) list[0];
	}

	@Override
	public boolean offer(E arg0) {
		// TODO Auto-generated method stub
		if(list.length == index) {
			Object[] newArray =  new Object[list.length * 2];
			for(int i = 0; i < index; i++) {
				newArray[i] =  list[i];
			}
			list = newArray;
			list[index++] = arg0;
			return true;
		}
		else {
			list[index++] = arg0;
			return true;
		}
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(index == 0)
			return null;
		else 
			return (E) list[0];
		
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		if(index == 0)
			return null;
		else {
			E obj = (E) list[0];
			for(int i = 0; i < index - 1; i ++) {
				list[i] = list[i +1];
			}
			list[index-1] = null;
			index--;
			return obj;
		}
	}

	@Override
	public E remove() {
		// TODO Auto-generated method stub
		if(index == 0)
			throw new  NoSuchElementException();
		else {
			E obj = (E) list[0];
			for(int i = 0; i < index - 1; i++) {
				list[i] = list[i +1];
			}
			list[index-1] = null;
			index--;
			return obj;
		}
	}

}
