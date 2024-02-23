package com.edu.upb.stack.array;

import com.edu.upb.array.Array;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.stack.AbstractStack;

public class Stack<E> extends AbstractStack<E>{

    Array<E> data;
    int top;

    public Stack(int size){
        data = new Array<>(size);
        top = -1;
    }
    @Override
    public boolean clear() {
        top = -1;
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
        return data.get(top);
    }

    @Override
    public E pop() {
        E toRet = data.get(top);
        data.remove(top);
        top--;
       return toRet;
    }

    @Override
    public boolean push(E element) {
        if( data.add(element)){
            top ++;
            return true;
        }
        return  false;
          
    }
    
}

