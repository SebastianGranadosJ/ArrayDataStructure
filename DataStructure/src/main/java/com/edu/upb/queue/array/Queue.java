package com.edu.upb.queue.array;

import java.util.NoSuchElementException;

import com.edu.upb.array.Array;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.queue.AbstractQueue;

public class Queue<E> extends AbstractQueue<E>{

    Array<E> array;
    int head;
    int tail;
    public Queue(int lenght){
        array = new Array<>(lenght);
        head = 0;
        tail = -1;
    }

    public int lenght(){
        return array.lenght();
    }

    @Override
    public boolean clear() {
        head = 0;
        tail = -1;
        return array.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return   new Iterator<E>() {
            int index = head;
            boolean hasNext = true;

            @Override
            public boolean hasNext() {
               return (array.get(index) != null) && hasNext;
            }

            @Override
            public E next() {

                if(!hasNext()){
                   throw new NoSuchElementException("No more elements in the list."); 
                }
                E ret = array.get(index); 

                if(index < array.lenght() - 1){
                    index++;
                }else{
                    index = 0;
                }
                
                if(index == head){
                    hasNext = false;
                }
      
                return ret;
            }
            

        };
    }

    @Override
    public boolean reverse() {
        try{
            if(isEmpty()){
                return true; // Preguntar al profesor si dejarlo en verdadero o ponerlo Falso
                // True puesto que si esta lleno de nulos el reverse sera el mismo que el original
            }


            int indexMax = lenght() - 1;
            int oldHead = head;
            int oldTail = tail;
            if(array.reverse()){

                if(size() == lenght()){
                    return true;
                }

                tail = indexMax - oldHead;
                head = indexMax - oldTail;
                return true;
            }

            return false;  
        }catch(Exception e){
            return false;
        }

    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public E extract() {

        if(isEmpty()){
            return null;
        }

        E toRet = array.get(head);
        array.remove(head);

        if(isEmpty()){
            head = 0;
            tail = -1;
            return toRet;
        }

        if(head < lenght() - 1){
            head++;
        }else{
            head = 0;
        }

        return toRet;
    
    }

    @Override
    public boolean insert(E element) {
        try{
            if(size() == lenght()){
                return false;
            }

            if(tail < lenght() - 1){
                tail++;
            }else{
                tail = 0;
            }

            array.set(tail, element);
     
            return true;

        }catch(Exception e){
            return false;
        }
    
        }
        
    @Override
    public E peek() {
       return array.get(head);
    }
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public String toString(){
        String reString = "[";
        Iterator<E> iter = iterator();
        int cnt = 1;

        while(iter.hasNext()){
            E element = iter.next();
            if(cnt == size()){
                reString = reString + element.toString() + " ]";
            }else{
                reString = reString + element.toString() + ", ";
            }
           cnt++;
        }
        return reString;

    }
    public String toStringArray(){
       
        return array.toString();

    }
    
}
