package com.edu.upb.nolineal.graph;

public class Node<E> {
    private E element;
    private int numNode;

    public Node(E element, int numNode){
        this.element = element;
        this.numNode = numNode;
    }

    public Node(){
        element = null;
        numNode = -1;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public int getNumNode() {
        return numNode;
    }

    public void setNumNode(int numNode) {
        this.numNode = numNode;
    }


    @Override
    public String toString() {
        return  element.toString() + " numNode=" + numNode ;
    }

    


}
