package com.edu.upb.linkedList.node.singly;

import com.edu.upb.util.node.AbstractNode;

public class LinkedNode<E> extends AbstractNode<E>{
    LinkedNode<E> next;

    public LinkedNode(){
        super();
        next = null;
    }

    public LinkedNode(LinkedNode<E> next){
        super();
        this.next = next;
    }

    public void setNext(LinkedNode<E> next){
        this.next = next;

    }

    public LinkedNode<E> getNext(){
        return next;
    }


}
