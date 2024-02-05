package com.edu.upb.util.list;

import com.edu.upb.util.collection.Collection;

public interface List<E> {
    public boolean add(E element);

    public boolean add(E[] array);

    public boolean add(Collection<E> collection);

    public boolean addFirst(E element);

    public boolean addFirst(E[] array);
    
    public boolean addFirst( Collection<E> collection);

    public E peek();

    public E peekLast();

    public E[] peekArray(int n); 

    public E[] peekLastArray(int n); 

    public List<E> peekCollection(int n);
    
    public List<E> peekLastCollection(int n);

    public E poll();

    public E pollLast();

    public E[] pollArray(int n);

    public E[] pollLastArray(int n);

}
