package com.edu.upb.nolineal.binsearchtree;

import java.util.function.ToIntFunction;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.nolineal.binsearchtree.linkednode.LinkedNode;
import com.edu.upb.queue.list.Queue;
import com.edu.upb.util.iterator.Iterator;

public class BinarySearchTree<E> {

    public LinkedNode<E> root;

    public ToIntFunction<E> valueSetter;

    public BinarySearchTree(E value, ToIntFunction<E> valueSetter){
        this.valueSetter = valueSetter;
        this.root = new LinkedNode<E>(value, valueSetter.applyAsInt(value));
    }

    public BinarySearchTree(ToIntFunction<E> valueSetter){
        root = null;
        this.valueSetter = valueSetter;
    }
    // insert, remove, search
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
            LinkedNode<E> successor = orderSuccessor(node.getLeft());
            node.set(successor.get());
            node.setLeft(remove(successor.get(), node.getLeft()));
        } else {
            node.setLeft(remove(element, node.getLeft()));
            node.setRight(remove(element, node.getRight()));
        }
        return node;
    }

    private LinkedNode<E> orderSuccessor(LinkedNode<E> node){

        if (node.getRight() == null) {
            return node;
        }
        return orderSuccessor(node.getRight());

    }

    public E search(int value){
        if(root == null){
            return null;
        }

        return search(root, value);

    }
    private E search(LinkedNode<E> node, int value){
        if(node == null){
            return null;
        }

        if(value == node.getValue()){
            return node.get();
        }

        if(value  < node.getValue()){
            return search(node.getLeft(), value);
            
        }

        if(value > node.getValue()){
            return search(node.getRight(), value);
        }

        return null;
    
        
    }

    public boolean insert(E element){
        try{
            root = insert(root, element);
            return true;
        }catch(Exception e){
            return false;
        }        
    }
    private LinkedNode<E> insert(LinkedNode<E> node, E element){
        if(node == null){
            return new LinkedNode<E>(element, valueSetter.applyAsInt(element));
        }

        if( valueSetter.applyAsInt(element) < node.getValue()){
            node.setLeft(insert(node.getLeft(), element));
        }

        if( valueSetter.applyAsInt(element) > node.getValue()){
           node.setRight(insert(node.getRight(), element));
        }

        return node;
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

        //EJERCICIO

        //13.5. Construir un método en la clase ArbolBinarioBusqueda que encuentre el elemento máximo.

        public E getMax(){
            LinkedNode<E> node = root;

            if(node == null){
                return null;
            }

            while( node.getRight() != null){
                node = node.getRight();
            } 

            return node.getRoot();

        }

        //EJERCICIO

        // Construir un método en la clase ArbolBinarioBusqueda que encuentre los elementos en un rango min(Inclusivo), max(exclusivo).
        
        public LinkedList<E> getInRange(int min, int max){
            LinkedList<E> elements = new LinkedList<>();
            Queue<LinkedNode<E>> queue = new Queue<>();
            LinkedNode<E> actualNode;


            if(root == null){
                return elements;
            }  

            queue.insert(root);

            while(!queue.isEmpty()){

                actualNode = queue.extract();

                if(actualNode.getValue() >= max){
                    if(actualNode.getLeft() != null){
                        queue.insert(actualNode.getLeft());
                    }
                    
                }

                if(actualNode.getValue() <  min){
                    if(actualNode.getRight() != null){
                        queue.insert(actualNode.getRight());
                    }
                    
                }

                if( min <= actualNode.getValue() && actualNode.getValue() < max){
                    elements.add(actualNode.getRoot());

                    if(actualNode.getLeft() != null){
                        queue.insert(actualNode.getLeft());
                    }

                    if(actualNode.getRight() != null){
                        queue.insert(actualNode.getRight());
                    }
                }
                

            }

            return elements;

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
