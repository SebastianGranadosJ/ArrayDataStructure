package com.edu.upb.linkedList.singly;

import com.edu.upb.linkedList.node.singly.LinkedNode;
import com.edu.upb.util.list.AbstractList;

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


}
