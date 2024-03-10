package com.edu.upb.util.priorityQueue;

import com.edu.upb.util.collection.AbstractCollection;

public abstract class AbstractPriorityQueue<E> extends AbstractCollection<E> implements PriorityQueue<E>{

    @Override
    public abstract E peek();

    @Override
    public abstract E extract();

    @Override
    public abstract boolean insert(E element);

    @Override
    public abstract boolean insert(int index, E element);
    
}
