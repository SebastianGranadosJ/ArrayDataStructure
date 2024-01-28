package com.edu.upb.array;

import java.util.Arrays;
import java.util.function.Predicate;

import com.edu.upb.util.array.AbstractArray;
import com.edu.upb.util.collection.Collection;
import com.edu.upb.util.iterator.Iterator;

@SuppressWarnings("unchecked")
/**
 * This class represents a collection of elements that can be accessed by an index.
 */
public class Array<E> extends AbstractArray<E>{


    private E elements[];
    
    /**
     * This constructor initializes an instance of the Array class with the specified amount of data.
     * @param amtData The amount of data to be initialized in the Array.            
     */
    public Array(int amtData) {
        super(amtData);
        elements = (E[]) new Object[amtData];
    }
    /**
     * Returns the index of the first occurence of null.
     * 
     * @return return the index of the first occurrence of null, if there isnt any null will return -1.
     */
    private int getAvailableIndex(){
        for(int ii = 0; ii < elements.length; ii++){
            if(elements[ii] == null){
                return ii;
            }
        }
        return -1;
    }

    @Override // ask about override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0; 

            @Override
            public boolean hasNext() {
                if(index < elements.length){
                    return true;
                }
                else{
                    return false;
                }
                
            }

            @Override
            public E next() {
                return elements[index++];
            }
            

        };
        
    }

    @Override
    public boolean add(E element) {
        // Ask about this, when return true and false

        int index = getAvailableIndex();
        if( index != -1){
            elements[index] = element;
            return true;
        }
        return false;
        
    }

    @Override
    public boolean add(int index, E[] array) {
        boolean ret = false;

        if(index < 0){
            return ret;
        }

        for(E arrayElement: array){
            if(index < elements.length){
                elements[index] = arrayElement;
                ret = true;
                index++;
            }

        }

        return ret;
    }

    @Override
    public boolean add(int index, Collection<E> collection) {
        Iterator<E> iter = collection.iterator();
        boolean ret = false;

        if(index < 0){
            return ret;
        }

        while(iter.hasNext()){
            if(index < elements.length){
                elements[index] = iter.next();
                index++;
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public void defragment() {
        E[] arrayCopy = (E[]) new Object[amtData];
        int cntCopy = 0;
        
        for(int ii = 0; ii < elements.length; ii++){
            if(elements[ii] != null){
                arrayCopy[cntCopy] = elements[ii];
                cntCopy++;
            }
        }

        this.clear();

        for(int ii = 0; ii < elements.length; ii++){
            elements[ii] = arrayCopy[ii];
        }

    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public boolean remove(int index) {
        if(index < elements.length && index >= 0){
            elements[index] = null;
            return true;
        }

        return false;
    }

    @Override//ASK ABOUT THIS ONE
    public boolean remove(Predicate<E> filter) {
        boolean ret = false;

        for(int ii = 0; ii < elements.length; ii++){

            if(filter.test(elements[ii])){
                elements[ii] = null;
            }
            
        }


        return ret;
    }

    @Override
    public boolean remove(int from, int to) {
        int top;
        boolean ret = false;

        if(to > elements.length){
            top = elements.length;
        }
        else{
            top = to;
        }

        for(int ii = from; ii < top; ii++){
            elements[ii] = null;
            ret = true;
        }

        return ret;
        
    }

    @Override
    public boolean dimension(int newDimension){ // Ask about the return

        boolean rt = false;
        E[] arrayCopy = (E[]) new Object[amtData];
        int top;
        if(newDimension == amtData || newDimension <= 0){
            return false;
        }

        
        for(int ii = 0; ii < elements.length; ii++){
            arrayCopy[ii] = elements[ii];
        }

        this.elements = (E[]) new Object[newDimension];

        if(arrayCopy.length > elements.length){
            top = elements.length;
        }else{
            top= arrayCopy.length;
        }

        for(int ii = 0; ii < top; ii++){
            elements[ii] = arrayCopy[ii];
        }

        if(elements.length == newDimension){
            amtData = newDimension;
            rt = true;
        }

        return rt;
    }

    @Override
    public boolean set(int index, E element) {
        if( index < elements.length && index >= 0){
            elements[index] = element;
            return true;
        }
        return false;
    }

    @Override // ask about this one
    public boolean clear() {
        boolean rt = false;
        for(int ii = 0 ; ii < elements.length; ii++){
            elements[ii] = null;
            rt = true;
        }
        return rt;
    }

    // ask about this one return
    @Override
    public boolean reverse() {

        boolean rt = false;
        E[] arrayCopy = (E[]) new Object[amtData];
        
        for(int ii = 0; ii < elements.length; ii++){
            arrayCopy[ii] = elements[elements.length - 1 - ii];
        }

        for(int ii = 0; ii < elements.length; ii++){
            elements[ii] = arrayCopy[ii];
            rt = true;
        }

        return rt;
    }
    
    @Override
    public String toString() {
        return "Array [elements=" + Arrays.toString(elements) + "]";
    }
    
}
