package com.edu.upb.util.stack;

import com.edu.upb.util.collection.AbstractCollection;
import com.edu.upb.util.iterator.Iterator;

public abstract class AbstractStack<E>  extends AbstractCollection<E> implements Stack<E>{

    @Override
    public abstract boolean clear();

    @Override
    public abstract Iterator<E> iterator() ;

    @Override
    public abstract boolean reverse();

    @Override
    public abstract E peek();

    @Override
    public abstract E pop();

    @Override
    public abstract boolean push(E element);


    
}
