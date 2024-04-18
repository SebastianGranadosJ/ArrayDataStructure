package com.edu.upb.exercises.queueExercise1;

import com.edu.upb.stack.list.Stack;

public class Main {
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(queueExercise.stackEvensToQueue(stack).toString());
    
    }
}
