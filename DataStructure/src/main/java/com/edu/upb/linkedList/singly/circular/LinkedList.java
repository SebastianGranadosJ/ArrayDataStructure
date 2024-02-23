package com.edu.upb.linkedList.singly.circular;

import java.util.NoSuchElementException;
import java.util.function.ToIntFunction;

import com.edu.upb.linkedList.node.singly.LinkedNode;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.list.AbstractList;
import com.edu.upb.util.list.List;

public class LinkedList<E> extends AbstractList<E>{
    LinkedNode<E> head;

    public LinkedList(){
        head = null;
        amtData = 0;
    }


    @Override
    public boolean clear() {
        try{
            head = null;
            amtData = 0;
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean reverse() {
        try{
            LinkedList<E> reverseList  = new LinkedList<>();
            
            Iterator<E> iter1 = iterator();

            while(iter1.hasNext()){
                reverseList.addFirst(iter1.next());
            }

            Iterator<E> iter2 = reverseList.iterator();
            clear();

            while(iter2.hasNext()){
                add(iter2.next());
            }
            return true;

        }catch(Exception e){
            return false;
        }      
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedNode<E> inode = head;

            @Override
            public boolean hasNext() {
               return inode != null;
            }

            @Override
            public E next() {

                if(!hasNext()){
                   throw new NoSuchElementException("No more elements in the list."); 
                }
                E ret = inode.get(); 
                
                if(inode.getNext().equals(head)){
                    inode = null;
                }else{
                    inode = inode.getNext();
                }
      
                return ret;
            }
            

        };
    }

    @Override
    public boolean add(E element) {
       
            LinkedNode<E> node = new LinkedNode<>();
            LinkedNode<E> inode = head;

            node.set(element);

            if(isEmpty()){
                head = node;
                node.setNext(node);
                amtData++;
                return true;
            }
            while(inode.getNext() != head){
                inode = inode.getNext();
            }
            inode.setNext(node);
            node.setNext(head);
            
            amtData++;
            return true;

       
    }

    @Override
    public boolean addFirst(E element) {
        try{
            LinkedNode<E> node = new LinkedNode<>();
            LinkedNode<E> inode = head;
            node.set(element);

            if(isEmpty()){
                head = node;
                node.setNext(node);
                amtData++;
                return true;
            }

            while(inode.getNext() != head){
                inode = inode.getNext();
            }
            inode.setNext(node);
            node.setNext(head);
            head = node;
            
            amtData++;
            return true;

        }catch(Exception e){
            return false;
        }
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        

        LinkedNode<E> inode = head;
        while(inode.getNext() != head){
            inode = inode.getNext();
        }

        return inode.get();
    }

    @Override
    public List<E> peekCollection(int n) {
        LinkedList<E> retList = new LinkedList<>();
        Iterator<E> iter = iterator();

        for(int ii = 0; ii < n; ii++){
            if(iter.hasNext()){
                retList.add(iter.next());
            } 
        }
        return retList;
    }

    @Override
    public List<E> peekLastCollection(int n) {
        LinkedList<E> retList = new LinkedList<>();
        Iterator<E> iter = iterator();

        if(n <= 0){
            return retList;
        }

        int toPass = this.amtData - n;

        for(int ii = 0; ii < toPass; ii++){
            if(iter.hasNext()){
                iter.next();
            }
        }

        while(iter.hasNext()){

            retList.add(iter.next());
        }
        return retList;
    }
   

    @Override
    public E pollLast() {
        LinkedNode<E> inode = head;
        E element;
        if(isEmpty()){
            return null;
        }


        if(head.getNext().equals(head)){
            element = head.get();
            head = null;
            amtData = 0;
            return element;
        }

        while(inode.getNext().getNext() != head){
            inode = inode.getNext();
        }
        element = inode.getNext().get();
        inode.setNext(inode.getNext().getNext());
        amtData--;
        
        return element;
    }


    @Override
    public E[] pollLastArray(int n) {
        int top;
        if( n <= 0){
            @SuppressWarnings("unchecked")
            E[] arrayRet  = (E[]) new Object[1];
            return arrayRet;
        }

        @SuppressWarnings("unchecked")
        E[] arrayRet  = (E[]) new Object[n];

        if(n >= amtData){
            top = amtData;
        }else{
            top = n;
        }

        for(int ii = top -1 ; ii >= 0; ii--){
            arrayRet[ii] = pollLast();
        }
        return arrayRet;
    }

    @Override
    public List<E> pollCollection(int n) {
        LinkedList<E> list = new LinkedList<>();
        
        int top;

        if(amtData < n){
            top = amtData;
        }else{
            top = n;
        }


        for(int ii = 0; ii < top; ii++){
            list.add(this.poll());
        }
        return list;
    }

    @Override
    public List<E> pollLastCollection(int n) {
        LinkedList<E> list = new LinkedList<>();

        int top;

        if(amtData < n){
            top = amtData;
        }else{
            top = n;
        }


        for(int ii = 0; ii < top; ii++){
            list.addFirst(this.pollLast());
        }
        return list;
    }

    @Override
    public boolean remove(E element) {
      
            LinkedNode<E> inode = head;

            if(isEmpty()){
                return false;
            }

            if(head.getNext().equals(head)){
                if(head.get().equals(element)){    
                    head = null;
                    amtData = 0;
                    return true;
                }else{
                    return false;
                }
            }
            if(head.get().equals(element)){
                do{
                    inode = inode.getNext();
                }while(inode.getNext() != head);

                inode.setNext(head.getNext());
                head = inode.getNext();
                amtData--;
                return true;
            }

            do{
                if(inode.getNext().get().equals(element) ){
                    if(inode.getNext().equals(head)){
                        inode.setNext(inode.getNext().getNext());
                        head = inode.getNext();
                        amtData--;
                        return true;
                    }

                    inode.setNext(inode.getNext().getNext());
                    amtData--;
                    return true;
                    
                }
                
                inode = inode.getNext();
                

            }while(inode != head);
            
            return false;

       
    }


    @Override
    public boolean set(E index, E element) {
        try{
            if(isEmpty()){
                return false;
            }

            LinkedNode<E> inode = head;
            do{
                if(inode.get().equals(index) ){
                    inode.set(element);
                    return true;
                }
                
                inode = inode.getNext();
                

            }while(inode != head);

            return false;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) {
        try{
            LinkedList<E> listCopy = new LinkedList<>();
            LinkedNode<E> inode;
            E minor;

            if(isEmpty()){
                return false;
            }

            while(!isEmpty()){
                inode = head;
                minor = head.get();
                
                do{

                    if(toInt.applyAsInt(inode.get()) <= toInt.applyAsInt(minor)){
                        minor = inode.get();
                    }
                    inode = inode.getNext();


                }while(inode != head);
                listCopy.add(minor);
                remove(minor);

            }
            add(listCopy);
            head = listCopy.head;
            this.amtData = listCopy.amtData;

            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<E> subList(E from, E to) {

        LinkedList<E> retList = new LinkedList<>();
        LinkedNode<E> inode = head;
        boolean copy = false;

        do{

            if(inode.get().equals(from) ){
                copy = true;
                
            }
            if(inode.get().equals(to)){
                if(from.equals(to) ){
                    retList.add(inode.get());
                }
                return retList;
            }
            if(copy){
                retList.add(inode.get());
            }

            inode = inode.getNext();

        }while(inode != head);

        return retList;
    }

    @Override
    public E[] toArray() {
        
        if(isEmpty()){
            @SuppressWarnings("unchecked")
            E[] array  = (E[]) new Object[1];
            return array;
        }

        @SuppressWarnings("unchecked")
        E[] array  = (E[]) new Object[amtData];
        int cnt = 0;
        LinkedNode<E> inode = head;
        
       do{
            array[cnt] = inode.get();
            cnt++;
            inode = inode.getNext();
       }while(inode != head);
       return array;
    }

    @Override
    public boolean isEmpty() {
        if(head == null  && amtData == 0){
            return true;
        }
        return false;
    }
    public String toString(){

        String reString = "[";
        Iterator<E> iter = iterator();
        int cnt = 1;

        while(iter.hasNext()){
            E element = iter.next();
            if(cnt == amtData){
                reString = reString + element.toString() + " ]";
            }else{
                reString = reString + element.toString() + ", ";
            }
           cnt++;
        }
        return reString;
        
    }


   
}
