package com.edu.upb.queue.list;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.queue.AbstractQueue;

public class Queue<E> extends AbstractQueue<E>{

    LinkedList<E> list;

    public Queue(){
        list = new LinkedList<>();
    }

    @Override
    public boolean clear() {
        return list.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public boolean reverse() {
        return list.reverse();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E extract() {
        return list.poll();
        
    }

    @Override
    public boolean insert(E element) {
        return list.add(element);
    }

    @Override
    public E peek() {
       return list.peek();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public String toString(){
        return list.toString() ;
    }
}
