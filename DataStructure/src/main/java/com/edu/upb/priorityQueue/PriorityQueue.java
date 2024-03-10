package com.edu.upb.priorityQueue;

import java.util.NoSuchElementException;

import com.edu.upb.array.Array;
import com.edu.upb.queue.list.Queue;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.priorityQueue.AbstractPriorityQueue;

public class PriorityQueue<E> extends AbstractPriorityQueue<E>{

    Array<Queue<E>> array;

    public PriorityQueue(int amtPriorities){

        if(amtPriorities <= 0){
            amtPriorities = 1;
        }

        array = new Array<>(amtPriorities);

        for(int ii = 0; ii < array.lenght(); ii++){
            array.add(new Queue<>());
        }
    }

    @Override
    public E peek() {

        for(int ii = 0; ii < array.lenght(); ii++){
            if(!array.get(ii).isEmpty()){
                return array.get(ii).peek();
            }
        }
        return null;


    }

    @Override
    public E extract() {
        
        for(int ii = 0; ii < array.lenght(); ii++){
            if(!array.get(ii).isEmpty()){
                return array.get(ii).extract();
            }

        } 
        return null;  
     }

    @Override
    public boolean insert(E element) {
        return insert(array.lenght() - 1, element);
    }

    @Override
    public boolean insert(int index, E element) {
        try{
            if(index < 0 || index >= array.lenght()){
                index = array.lenght() - 1;
            }
            return array.get(index).insert(element);

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean reverse() {
        try{
            boolean toReturn = true;
            for(int ii = 0; ii < array.lenght(); ii++){
                if(!array.get(ii).reverse()){
                    toReturn = false;
                }
            }
            if(!array.reverse()){
                toReturn = false;
            }
            return toReturn;
           


        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean clear() {
        
        try{
            for(int ii = 0; ii < array.lenght(); ii++){
                array.get(ii).clear();
            }
            return true;

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;
            Queue<E> queue = array.get(index);
            Iterator<E> iter = queue.iterator();

            @Override
            public boolean hasNext() {

                while(!iter.hasNext() && index < array.lenght()){
                    queue = array.get(index);
                    index++;
                    iter = queue.iterator();
                }

                return iter.hasNext();
            }

            @Override
            public E next() {

                if(hasNext() == false){
                    throw new NoSuchElementException("No more elements in the list."); //check
                }
                
                return iter.next();
                
            }
            

        };
    }

    @Override
    public int size() {
        int size = 0;
        for(int ii = 0; ii < array.lenght(); ii++){
            size += array.get(ii).size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean areEmpty = true;

        for(int ii = 0; ii < array.lenght(); ii++){
            if(!array.get(ii).isEmpty()){
                areEmpty = false;
            }
        }

    
        return areEmpty && size() == 0;
        

    }

    public String toString(){
        String toRet = "{\n";
        for(int ii = 0; ii < array.lenght(); ii++){
            toRet += ii + ". " + array.get(ii).toString() +"\n";
        }
        toRet += "}";
        return toRet;
    }

    
}
