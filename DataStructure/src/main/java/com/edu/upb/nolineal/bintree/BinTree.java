package com.edu.upb.nolineal.bintree;

import com.edu.upb.linkedList.singly.LinkedList;
import com.edu.upb.nolineal.bintree.linkednode.LinkedNode;
import com.edu.upb.queue.list.*;
import com.edu.upb.util.iterator.Iterator;

public class BinTree<E> {

    public LinkedNode<E> root;

    public BinTree(E value){
        this.root = new LinkedNode<E>(value);
    }

    public BinTree(){
        root = null;
    }

    //---- preOrden ----
    public LinkedList<E> preOrder(){

        LinkedList<E> list = new LinkedList<>();
        preOrder(root, list);
        return list;
    }
    private void preOrder(LinkedNode<E> root, LinkedList<E> list){
        
        if (root != null){
            list.add(root.get());
            preOrder (root.getLeft(), list);
            preOrder (root.getRight(), list);
        }
    }

    
    //---- InOrder ----
    public LinkedList<E> inOrder(){
        LinkedList<E> list = new LinkedList<>();

       inOrder(root, list);
         return list;
    }
    private void inOrder(LinkedNode<E> root, LinkedList<E> list){
        if (root != null){
            inOrder (root.getLeft(), list);
            list.add(root.get());
            inOrder (root.getRight(), list);
         }
    }

    //---- PostOrder ----
    public LinkedList<E> postOrder(){
        LinkedList<E> list = new LinkedList<>();
        postOrder(root, list);
        return list;
    }
    private void postOrder(LinkedNode<E> root,  LinkedList<E> list ){
        if (root != null){
            postOrder (root.getLeft(), list);
            postOrder (root.getRight(), list);
            list.add(root.get());
        }
    }

    //---- En Amplitud ----
    public LinkedList<E> inAmplitude(){
        Queue<LinkedNode<E>> queue = new Queue<>();
        LinkedList<E> list = new LinkedList<>();
        LinkedNode<E> node;
        
        if(root != null){
            queue.insert(root);
        }

        while(!queue.isEmpty()){
            node = queue.extract();
            list.add(node.get());

            if(node.getLeft() != null){
                queue.insert(node.getLeft());
            }

            if(node.getRight() != null){
                queue.insert(node.getRight());
            }
        }

        return list;
    }

    //---- Get Height ---
    public int getHeight(){
        int height = 0;
        LinkedList<LinkedNode<E>> nodes = new LinkedList<>();
        if(root != null){
            nodes.add(root);
        }

        while(!nodes.isEmpty()){
            Iterator<LinkedNode<E>> iter = nodes.iterator();
            LinkedList<LinkedNode<E>> nextLevelNodes = new LinkedList<>();

            while(iter.hasNext()){
                LinkedNode<E> node = iter.next();

                if(node.getRight() != null){
                    nextLevelNodes.add(node.getRight());
                }

                if(node.getLeft() != null){
                    nextLevelNodes.add(node.getLeft());
                }
                
            }
            nodes = nextLevelNodes;
            height++;
        }
        return height;

    }

    // Este lo hice cuenta propia, determina si un arbol esta lleno( el de si esta completo esta abajo)
    // If the first node in a level is null the other ones have to be null to be a full tree. 
    // At the same way, if the first node un a level has an element, the other ones have to has a element.
    // This metod use this to evaluate if a tree is full
    public boolean isFull(){
        LinkedList<LinkedNode<E>> nodes = new LinkedList<>();

        if(root == null){
            return false;
        }

        nodes.add(root);

        while(!nodes.isEmpty()){
            Iterator<LinkedNode<E>> iter = nodes.iterator();
            LinkedList<LinkedNode<E>> nextLevelNodes = new LinkedList<>();
            boolean firstNull = true;
            boolean firstIteration = true;


            while(iter.hasNext()){
                LinkedNode<E> node = iter.next();

                if(firstIteration){
                    firstNull = node.getLeft() == null;
                    firstIteration = false;
                }
                

                if(node.getLeft() != null){
                    nextLevelNodes.add(node.getLeft());
                    if(firstNull){
                        return false;
                    }
                }else{
                    if(!firstNull){
                        return false;
                    }
                }

                if(node.getRight() != null){
                    nextLevelNodes.add(node.getRight());

                    if(firstNull){
                        return false;
                    }

                }else{
                    if(!firstNull){
                        return false;
                    }
                }
                
            }
            nodes = nextLevelNodes;
            firstIteration = true;
        }

        return true;
    }

    public boolean isComplete(){
        
            LinkedList<LinkedNode<E>> nodes = new LinkedList<>();
    
            if(root == null){
                return false;
            }
    
            nodes.add(root);
    
            while(!nodes.isEmpty()){
                Iterator<LinkedNode<E>> iter = nodes.iterator();
                LinkedList<LinkedNode<E>> nextLevelNodes = new LinkedList<>();
                boolean hasNull  = false;

    
                while(iter.hasNext()){

                    LinkedNode<E> node = iter.next();
    
                    if(node.getLeft() != null){
                        nextLevelNodes.add(node.getLeft());
                        if(hasNull){
                            return false;
                        }
                    }else{
                        hasNull = true;
                    }
    
                    if(node.getRight() != null){
                        nextLevelNodes.add(node.getRight());
                        if(hasNull){
                            return false;
                        }
    
                    }else{
                        hasNull = true;
                    }
                    
                }
                nodes = nextLevelNodes;
            }
    
            return true;
        }
    

    public boolean insert(E element){
        try{
            
            LinkedList<LinkedNode<E>> nodes = new LinkedList<>();
    
            if(root == null){
                root = new LinkedNode<>(element);
                return true;
            }
    
            nodes.add(root);
    
            while(!nodes.isEmpty()){
                Iterator<LinkedNode<E>> iter = nodes.iterator();
                LinkedList<LinkedNode<E>> nextLevelNodes = new LinkedList<>();


                while(iter.hasNext()){

                    LinkedNode<E> node = iter.next();
    
                    if(node.getLeft() != null){
                        nextLevelNodes.add(node.getLeft());
                        
                    }else{
                        node.setLeft( new LinkedNode<>(element));
                        return true;
                    }
    
                    if(node.getRight() != null){
                        nextLevelNodes.add(node.getRight());
                    }else{
                        node.setRight(new LinkedNode<>(element));
                        return true;
                    }
                    
                }
                nodes = nextLevelNodes;
            }
    
            return false;
        }catch(Exception e){
            return false;
        }

    }

    public boolean remove(E element){
        try{
            root =  remove(element, root);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    private LinkedNode<E> remove(E element, LinkedNode<E> node) {
        if (node == null) {
            return null;
        }
    
        if (node.get().equals(element)) {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
    
            if (node.getLeft() == null) {
                return node.getRight();
            }
    
            if (node.getRight() == null) {
                return node.getLeft();
            }
    
            // Caso en que el nodo tiene dos hijos
            node.set(node.getLeft().get());
            LinkedNode<E> successor = orderSuccessor(node.getLeft());
            node.setLeft(successor);
        } else {
            node.setLeft(remove(element, node.getLeft()));
            node.setRight(remove(element, node.getRight()));
        }
        return node;
    }

    private LinkedNode<E> orderSuccessor(LinkedNode<E> node){

        if(node.getLeft() == null && node.getRight() ==  null){
            return null;
        }

        if(node.getLeft() != null){
            node.set(node.getLeft().get());
            node.setLeft( remove( node.get(), node.getLeft()));
            return node;
        }

        if(node.getRight() != null){
            node.set(node.getRight().get());
            node.setRight( remove( node.get(), node.getRight()));
            return node;
        }
       

        return node;

    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        toString(root, stringBuilder, 0);
        return stringBuilder.toString();
    }
    
    private void toString(LinkedNode<E> node, StringBuilder stringBuilder, int tabs) {
        if (node != null) {
            for (int ii = 0; ii < tabs; ii++) {
                stringBuilder.append("   ");
            }
            stringBuilder.append(node.get().toString()).append("\n");
            toString(node.getLeft(), stringBuilder, tabs + 1);
            toString(node.getRight(), stringBuilder, tabs + 1);
        }
    }
}
