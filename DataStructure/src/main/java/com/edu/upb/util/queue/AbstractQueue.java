package com.edu.upb.util.queue;

import com.edu.upb.util.collection.AbstractCollection;
import com.edu.upb.util.iterator.Iterator;

public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E>{

    @Override
    public abstract boolean clear() ;
    
    @Override
    public abstract Iterator<E> iterator();

    @Override
    public abstract boolean reverse() ;

    @Override
    public abstract int size() ;
    
    @Override
    public abstract E extract();

    @Override
    public abstract boolean insert(E element) ;

    @Override
    public abstract E peek();

    @Override
    public abstract boolean isEmpty() ;
    
}
