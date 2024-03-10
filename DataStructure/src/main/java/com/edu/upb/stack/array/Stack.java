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
        if(data.reverse()){
            data.defragment();
            return true;
        }

        return false;
        
    }

    @Override
    public E peek() {
        if(top == -1){
            return null;
        }

        return data.get(top);
    }

    @Override
    public E pop() {
        if(top == -1){
            return null;
        }

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

    public String toString(){
        Array<E> temp = data;
        return temp.toString();
    }
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    @Override
    public int size() {
        return data.size();
    }
    
}

