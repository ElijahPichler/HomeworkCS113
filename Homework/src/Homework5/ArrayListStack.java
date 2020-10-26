package Homework5;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E>{
	ArrayList<E> list;
	
	
	public ArrayListStack() {
		list = new ArrayList<>();
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return list.size() == 0;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(empty())
			throw new  EmptyStackException();
	
		return list.get(list.size() - 1);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(empty())
			throw new EmptyStackException();
	
		return list.remove(list.size() - 1);
	}

	@Override
	public E push(E obj) {
		// TODO Auto-generated method stub
		list.add(obj);
		return obj;
	}

}
