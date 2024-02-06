package com.edu.upb.util.list;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

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

    public List<E> pollCollection(int n);

    public List<E> pollLastCollection(int n);

    public boolean remove(E element);

    public boolean remove(E[] array);

    public boolean remove(Collection<E> collection);

    public boolean remove(Predicate<E> filter);

    public boolean replace(E element, E newElement, Predicate<E> comparator);

    public boolean replace(E[] element, E[] newElement, Predicate<E> comparator);

    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator);

    public boolean retain(Collection<E> collection);

    public boolean set(E index, E element);

    public boolean sort(ToIntFunction<E> toInt);

    public List<E> subList(E from, E to );

    public E[] toArray();
}
