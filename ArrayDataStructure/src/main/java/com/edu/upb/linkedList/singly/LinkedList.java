package com.edu.upb.linkedList.singly;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.edu.upb.linkedList.node.singly.LinkedNode;
import com.edu.upb.util.collection.Collection;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.util.list.AbstractList;
import com.edu.upb.util.list.List;

public class LinkedList<E> extends AbstractList<E>{
    
    private LinkedNode<E> head;
    private LinkedNode<E> tail;

    public LinkedList(){
        super();
        head = null;
        tail = null;
    }
    public LinkedList(E element){
        super();
        add(element);
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

        try{
            LinkedList<E> reverseList  = new LinkedList<>();
            Iterator<E> iter = iterator();
    
            while(iter.hasNext()){
                reverseList.addFirst(iter.next());
            }

            head = reverseList.head;
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

                if(hasNext()){
                    throw new NoSuchElementException("No more elements in the list."); //check
                }
                E ret = inode.get();
                inode = inode.getNext();
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
                
            }else{
                tail.setNext(node);
                tail = node;
            }
            amtData++;
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
                addFirst(iter.next());

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
        @SuppressWarnings("unchecked")
        E[] arrayRet  = (E[]) new Object[n];



        for(int ii = 0; ii < n; ii ++){
            arrayRet[ii] = this.poll();
        }
        return arrayRet;
       
    }

    @Override
    public E[] pollLastArray(int n) {
        @SuppressWarnings("unchecked")
        E[] array  = (E[]) new Object[n];

        for(int ii = 0; ii < n; ii++){
            array[ii] = pollLast();
        }
        return array;

    }

    @Override
    public List<E> pollCollection(int n) {
        LinkedList<E> list = new LinkedList<>();

        for(int ii = 0; ii < n; ii++){
            list.add(this.poll());
        }
        return list;
    }

    @Override
    public List<E> pollLastCollection(int n) {
        LinkedList<E> list = new LinkedList<>();

        for(int ii = 0; ii < n; ii++){
            list.add(this.pollLast());
        }
        return list;
    }

    @Override
    public boolean remove(E element) {

        try{
            if(isEmpty()){
                return false;
            }
            
            LinkedNode<E> inode = new LinkedNode<>();
            inode = head;
           

            if(inode.get() == element){
                head = head.getNext();
                amtData--;
                return true;
            }
            
            while (inode.getNext() != null) {
                if(inode.getNext().get() == element){

                    if(inode.getNext().getNext() != null){
                        inode.setNext(inode.getNext().getNext());
                        amtData--;
                        return true;
                    }else{
                        inode.setNext(null);
                        amtData--;
                        return true;
                    }
                   

                }
                
                inode = inode.getNext();
                
             }
            return false;

        }catch(Exception e){
            return false;
        }

        
    }

    @Override
    public boolean remove(E[] array) {
        boolean ret = true;
        try{
            for (E element : array) {
                if(!remove(element)){
                    ret = false;
                }
                
            }
            return ret;

        }catch(Exception e){
            return false;
        }
        
       
    }

    @Override
    public boolean remove(Collection<E> collection) {
        try{
            Iterator<E> iter = collection.iterator();
            boolean ret = true;

            while(iter.hasNext()){
                   if(!remove(iter.next())){
                        ret = false;
                   }
            }
            return ret;

        }catch(Exception e){
            return false;
        }
        
    }

    @Override
    public boolean remove(Predicate<E> filter) { // ASK ABOUT DOCUMENTATION AND RETURN

        Iterator<E> iter = iterator();
        boolean ret = true;
        while(iter.hasNext()){
            E element = iter.next();

            if(filter.test(element)){

                if(!remove(element)){
                    ret = false;
                }
                
            }
        }
        return ret;

    }

    @Override
    public boolean replace(E element, E newElement, Predicate<E> comparator) {
        
        try{
            if(!contains(element)){
                return false;
            }
            if(comparator.test(element)){
                set(element, newElement);
                return true;
            }
            return false;


        }catch(Exception e){
            return false;
        }

    }

    @Override
    public boolean replace(E[] element, E[] newElement, Predicate<E> comparator) {

        try{
            boolean ret = true;
            int top = element.length;

            if(newElement.length < element.length){
                top = newElement.length;
                ret = false;
            }

            for(int ii = 0; ii < top; ii++){
                
                if(!replace(element[ii], newElement[ii], comparator )){
                    ret = false;
                }
            }
            return ret;
        }catch(Exception e){
            return false;
        }
        
    }

    @Override
    public boolean replace(Collection<E> collection, Collection<E> newCollection, Predicate<E> comparator) {
        try{
            boolean ret = true;
            int top = collection.size();
            Iterator<E> iter = collection.iterator();
            Iterator<E> newIter = newCollection.iterator();

            if(newCollection.size() < collection.size()){
                ret = false;
                top = newCollection.size();
            }

            for(int ii  = 0; ii < top; ii++){
                if(!replace(iter.next(), newIter.next(), comparator)){
                    ret = false;
                }

            }
            

            return ret;



        }catch(Exception e){
            return false;
        }
    }
    @Override
    public boolean retain(E[] array) {
        try{

            for(int ii = 0; ii < array.length; ii++){

                if(contains(array[ii]) == false){
                    remove(array[ii]);
                }

            }
            return true;

        }catch(Exception e){
            return false;
        }

    }

    @Override
    public boolean retain(Collection<E> collection) { // Do i have to return false if any of the elements were eliminated?
        try{
            Iterator<E> iter = iterator();
            E element;

            while(iter.hasNext()){

                element = iter.next();

                if(collection.contains(element) == false){
                    remove(element);
                }

            }
            return true;


        }catch(Exception e){
            return false;
        }
        

    }

    @Override
    public boolean set(E index, E element) {
        try{
                
            LinkedNode<E> inode = head;

            while(inode != null){

                if(inode.get() == index){
                    inode.set(element);
                    return true;
                }
                inode = inode.getNext();
            }
            return false;
            
            }catch(Exception e){
                return false;
            }
    }

    @Override
    public boolean sort(ToIntFunction<E> toInt) { // All elements are remplaced with ToIntFunction and then sorted? Or arent remplaced?
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

    @Override
    public List<E> subList(E from, E to) {

        LinkedList<E> retList = new LinkedList<>();
        LinkedNode<E> inode = head;
        boolean copy = false;

        while(inode != null){

            if(inode.get() == from){
                copy = true;
            }
            if(inode.get() == to){
                copy = false;
                return retList;
            }
            if(copy){
                retList.add(inode.get());
            }

            inode = inode.getNext();

        }
        return retList;



    }

    @Override
    public boolean isEmpty() {
        
        try{
            if(head == null && tail == null && amtData == 0){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }

    }
    @Override
    public E peekLast() {
        return tail.get();
    }
    @Override
    public List<E> peekCollection(int n) {
        LinkedList<E> retList = new LinkedList<>();
        LinkedNode<E> inode = head;

        for(int ii = 0; ii < n; ){

        }

        


    }
    @Override
    public List<E> peekLastCollection(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peekLastCollection'");
    }
   


}
