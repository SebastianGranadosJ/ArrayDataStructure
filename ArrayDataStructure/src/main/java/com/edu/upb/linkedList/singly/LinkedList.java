package com.edu.upb.linkedList.singly;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.edu.upb.linkedList.node.singly.LinkedNode;
import com.edu.upb.util.collection.Collection;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.list.AbstractList;
import com.edu.upb.util.list.List;

public class LinkedList<E> extends AbstractList<E>{
    
    LinkedNode<E> head;
    LinkedNode<E> tail;

    public LinkedList(){
        head = null;
        tail = null;
    }
    
    public LinkedList(LinkedNode<E> node){
        head = node;
        tail = node;
    }

    @Override
    public boolean clear() {
        try{
            head = null;
            tail = null;
            amtData = 0;
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean reverse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reverse'");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedNode<E> currentNode = head; 

            @Override
            public boolean hasNext() {

                return currentNode != null;
            }

            @Override
            public E next() {

                if(hasNext()){
                    throw new UnsupportedOperationException("Unimplemented method 'reverse'"); //check
                }
                E ret = currentNode.get();
                currentNode = currentNode.getNext();
                return ret;
            }
            

        };
    }

    @Override
    public boolean add(E element) {
        try{
            LinkedNode<E> node = new LinkedNode<>();
            node.set(element);

            if(this.isEmpty()){
                tail = node;
                head = node;
                this.amtData++;

            }else{
                tail.setNext(node);
                tail = node;
                this.amtData++;
            }
            return true;

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean add(E[] array) {
        try{
            for(int ii = 0; ii < array.length; ii++){
                this.add(array[ii]);

            }
            return true; // Ask about true conditions


        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean add(Collection<E> collection) {
        try{
            Iterator<E> iter = collection.iterator();

            while(iter.hasNext()){
                this.add(iter.next());

            }
            return true; // Ask about the return 

        }catch(Exception e){
            return false;
        }

    }

    @Override
    public boolean addFirst(E element) {
        try{
            LinkedNode<E> node = new LinkedNode<>();
            node.set(element);

            if(isEmpty()){

                tail = node;
                head = node;
                this.amtData++;

            }else{

                node.setNext(head);
                head = node;
                this.amtData++;
            }
            return true;

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean addFirst(E[] array) {
        try{

            for(int ii = 0; ii < array.length; ii++){
                addFirst(array[ii]);

            }
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean addFirst(Collection<E> collection) {
        try{
            Iterator<E> iter = collection.iterator();

            while(iter.hasNext()){
                this.addFirst(iter.next());

            }
            return true; // Ask about the return 

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public E poll() {
        
        if(isEmpty()){

            return null;

        }else{
            E ret = head.get();
            head = head.getNext();
            amtData--;
            return ret;
        }


        
    }

    @Override
    public E pollLast() {
        if (isEmpty()){
            return null;
        }else{
            E ret = tail.get();

            LinkedNode<E> node = head;

            while(node.getNext() != tail){
                node = node.getNext();
            }

            tail = node;
            tail.setNext(null);
            amtData--;
            return ret;



        }

    }

    @Override
    public E[] pollArray(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pollArray'");
    }

    @Override
    public E[] pollLastArray(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pollLastArray'");
    }

    @Override
    public List<E> pollCollection(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pollCollection'");
    }

    @Override
    public List<E> pollLastCollection(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pollLastCollection'");
    }

    @Override
    public boolean remove(E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean remove(E[] array) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean remove(Collection<E> collection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean remove(Predicate<E> filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public boolean replace(E[] element, E[] newElement, Predicate<E> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public boolean retain(Collection<E> collection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retain'");
    }

    @Override
    public boolean set(E index, E element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

    @Override
    public List<E> subList(E from, E to) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subList'");
    }


}
