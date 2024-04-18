package com.edu.upb.exercises.queueExercise2;
import java.util.Random;

import com.edu.upb.queue.array.Queue;

/* Escribir un programa en el que se generen 100 números aleatorios en el rango –25
... +25 y se guarden en una cola implementada mediante un array considerado
circular. Una vez creada la cola, el usuario puede solicitar que se forme otra cola con
los números negativos que tiene la cola original. */

public class QueueExercise2 {
    Queue<Integer> queue ;
    
    public QueueExercise2(){
        queue = new Queue<>(100);
        Random rand = new Random();

        for(int ii = 0; ii < 100; ii++){
            queue.insert(rand.nextInt(-25, 26));
        }
    }

    public Queue<Integer> negativeNumbers(){
        Queue<Integer> toReturn = new Queue<>(100);

        while(!queue.isEmpty()){
            Integer element = queue.extract();

            if(element < 0){
                toReturn.insert(element);
            }
        }
        return toReturn;

        
    }

    public String toString(){
        return queue.toString();
    }


    
}
