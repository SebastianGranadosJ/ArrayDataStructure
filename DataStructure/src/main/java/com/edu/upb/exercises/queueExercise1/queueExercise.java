package com.edu.upb.exercises.queueExercise1;

import com.edu.upb.queue.list.Queue;
import com.edu.upb.stack.list.Stack;

//Se tiene una pila de enteros positivos. Con las operaciones básicas de pilas y colas
//escribir un fragmento de código para poner todos los elementos que son par de la pila
//en la cola

public class queueExercise {
    

    public static Queue<Integer> stackEvensToQueue(Stack<Integer> stack){
        Queue<Integer> toRet = new Queue<>();
        
        while(!stack.isEmpty()){
            Integer element = stack.pop();
            if(element %2 == 0){
                toRet.insert(element);
            }
        }
        return toRet;
        
        


    }
}
