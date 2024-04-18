package com.edu.upb.stack.list;

import com.edu.upb.linkedList.singly.LinkedList;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.stack.AbstractStack;

public class Stack<E> extends AbstractStack<E>{

    LinkedList<E> data;

    public Stack(){
        data = new LinkedList<>();
    }

    @Override
    public boolean clear() {
         return data.clear();
           
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();

    }

    @Override
    public boolean reverse() {
        return data.reverse();
    }

    @Override
    public E peek() {
        return data.peek();
    }

    @Override
    public E pop() {
       return data.poll();
    }

    @Override
    public boolean push(E element) {
      
        return data.addFirst(element);
          
    }
    public String toString(){
        return data.toString();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    @Override
    public int size() {
        return data.size();
    }
    @Override
    public boolean contains(E element){
        return data.contains(element);
    }
    
}
