package com.edu.upb.nolineal.binsearchtree.linkednode;

import com.edu.upb.util.node.Node;

public class LinkedNode<E> implements Node<E>, Cloneable{

    private E root;
    private int value;
    private LinkedNode<E> right;
    private LinkedNode<E> left;

    public LinkedNode(E root, int value){
        this.root = root;
        right = null;
        left = null;
        this.value = value;
    }
    public LinkedNode(){
        root = null;
        right = null;
        left = null;

    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public void set(E root) {
        this.root = root;
    }

    public E get() {
        return root;
    }

    public void setRight(LinkedNode<E> right){
        this.right = right;

    }

    public LinkedNode<E> getRight(){
        return right;
    }
    public void setLeft(LinkedNode<E> left){
        this.left = left;

    }

    public LinkedNode<E> getLeft(){
        return left;
    }
    public E getRoot() {
        return root;
    }

    
}
