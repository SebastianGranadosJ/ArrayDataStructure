package com.edu.upb.nolineal.bintree.linkednode;

import com.edu.upb.util.node.Node;

public class LinkedNode<E> implements Node<E>, Cloneable{

    private E root;
    private LinkedNode<E> right;
    private LinkedNode<E> left;

    public LinkedNode(E root){
        this.root = root;
        right = null;
        left = null;

    }
    public LinkedNode(){
        root = null;
        right = null;
        left = null;

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
