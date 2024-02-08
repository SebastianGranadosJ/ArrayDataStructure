package com.edu.upb.util.list;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.edu.upb.util.collection.Collection;
import com.edu.upb.util.iterator.Iterator;

public abstract class AbstractList<E> implements List<E>, Cloneable, Collection<E>{
    protected int amtData;

    protected AbstractList(){
        amtData = 0;
    }
    @Override
    public abstract boolean add(E element) ;

    @Override
    public abstract boolean add(E[] array);

    @Override
    public abstract boolean add(Collection<E> collection);

    @Override
    public abstract boolean addFirst(E element);

    @Override
    public abstract boolean addFirst(E[] array);

    @Override
    public abstract boolean addFirst(Collection<E> collection);

    @Override
    public E peek() {
        try{    

            Iterator<E> iter = this.iterator();


            if(iter.hasNext()){
                return iter.next();
            }
            return null;

        }catch(Exception e){
            return null;
        }
    }

    @Override
    public abstract E peekLast();

    @Override
    public E[] peekArray(int n) {
        try{    
            @SuppressWarnings("unchecked")

            E[] array  = (E[]) new Object[amtData];
            int cnt = 0;
            Iterator<E> iter = this.iterator();
            
            for(int ii = 0; ii < n; ii++){
                if(iter.hasNext()){
                    array[cnt] = iter.next();
                    cnt++;
                }
            }

            return array;
            
        }catch(Exception e){
            @SuppressWarnings("unchecked")
            E[] array  = (E[]) new Object[amtData];
            return array;
        }
        
    }

    @Override
    public E[] peekLastArray(int n) {
        try{    
            @SuppressWarnings("unchecked")

            E[] array  = (E[]) new Object[amtData];
            int cnt = 0;
            Iterator<E> iter = this.iterator();

            int toPass = this.amtData - n;

            for(int ii = 0; ii < toPass; ii++){
                if(iter.hasNext()){
                    iter.next();
                }
            }

            
            for(int ii = 0; ii < n; ii++){
                if(iter.hasNext()){
                    array[cnt] = iter.next();
                    cnt++;
                }
            }

            return array;
            
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public abstract List<E> peekCollection(int n) ;

    @Override
    public abstract List<E> peekLastCollection(int n);

    @Override
    public abstract E poll();

    @Override
    public abstract E pollLast();

    @Override
    public abstract E[] pollArray(int n);

    @Override
    public abstract E[] pollLastArray(int n);


    @Override
    public abstract List<E> pollCollection(int n);

    @Override
    public abstract List<E> pollLastCollection(int n);

    @Override
    public abstract boolean remove(E element);

    @Override
    public abstract boolean remove(E[] array);

    @Override
    public abstract boolean remove(Collection<E> collection);

    @Override
    public abstract boolean remove(Predicate<E> filter);

    @Override
    public abstract boolean replace(E element, E newElement, Predicate<E> comparator);

    @Override
    public abstract boolean replace(E[] element, E[] newElement, Predicate<E> comparator);

    @Override
    public abstract boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator);

    @Override
    public abstract boolean retain(E[] array);

    @Override
    public abstract boolean retain(Collection<E> collection);

    @Override
    public abstract boolean set(E index, E element);

    @Override
    public abstract boolean sort(ToIntFunction<E> toInt);

    @Override
    public abstract List<E> subList(E from, E to); // ASK

    @Override
    public E[] toArray() {
        try{    
            @SuppressWarnings("unchecked")

            E[] array  = (E[]) new Object[amtData];
            int cnt = 0;
            Iterator<E> iter = this.iterator();
            
           while(iter.hasNext()){
                array[cnt] = iter.next();
                cnt++;
           }
           return array;
            
        }catch(Exception e){
            return null;
        }
    }
    
    public int size(){
        return amtData;
    }

    public void forEach(Function<E, Void> action){
        Iterator<E> iter = this.iterator();

        while(iter.hasNext()){
            action.apply(iter.next());
        }

      
    }


    public boolean contains(E element){

        try{
            Iterator<E> iter = this.iterator();

            while(iter.hasNext()){
    
                if(iter.next() == element){
                    return true;
                }
    
            }
            return false;
        }catch(Exception e){
            return false;
        }
        
    }


    public boolean contains(E[] array) {

        try{
            for(E element: array ){

                if(this.contains(element) == false){
                    return false;
                }
    
            }
            return true;

        }catch(Exception e){
            return false;
        }

    }


    public boolean contains(Collection<E> collection) {

        try{
            Iterator<E> iter = collection.iterator();

            while(iter.hasNext()){
    
                if(this.contains(iter.next()) == false){
    
                    return false;
                }
            }
    
            return true;

        }catch(Exception e){
            return false;
        }
        
    }

    public abstract boolean isEmpty();
    
}
