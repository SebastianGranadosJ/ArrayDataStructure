package com.edu.upb.exercises.stackExercise1;

import com.edu.upb.array.Array;
import com.edu.upb.scan.Scan;
import com.edu.upb.stack.list.Stack;

public class StackExercise {
    Array<Stack<Integer>> stacks = new Array<>(5);

    public StackExercise(){
        for(int ii = 0; ii < stacks.lenght() ; ii++){
            stacks.add(new Stack<>());
        }
    }
  
    private boolean action(int i, int j, int k){
        if(i == 0){
            return false;
        }
        if(k == -1){
            stacks.get(i - 1).clear();
            return true;
        }

        if(i > 0){
            stacks.get(i - 1).push(j);

        }
        if(i < 0){
            Stack<Integer> copyStack = new Stack<>();
            Stack<Integer> actualStack = stacks.get(Math.abs(i) - 1);
            while (!actualStack.isEmpty()) {
                int element = actualStack.pop();
                if (element != j) {
                    copyStack.push(element);
                }
            }
            while (!copyStack.isEmpty()) {
                actualStack.push(copyStack.pop());
            }
            
        }
        return true;
    }

    private Array<Integer> input(){
        Array<Integer> inputs = new Array<>(3);
        System.out.println("Ingres los siguiente valores: ");
        System.err.println("i: ");
        int i = Scan.getValidatedIntInput();
        while( i > 5 || i < -5){
            i = Scan.getValidatedIntInput();
        }
        inputs.add(i);
        System.err.println("j: ");
        inputs.add(Scan.getValidatedIntInput());
        System.err.println("k: ");
        inputs.add(Scan.getValidatedIntInput());
        return inputs;

    }

    public void menu(){
        Array<Integer> inputs = input();

        while(action(inputs.get(0), inputs.get(1), inputs.get(2))){
            System.out.println(toString());
            inputs = input();
        }

        System.out.println("Programa Finalizado");
        System.out.println(toString());
        



    }

    public String toString(){
        String toRet = "{";

        for(int ii = 0; ii < stacks.lenght(); ii++){

            toRet += stacks.get(ii).toString() + "\n";

        }
        toRet += "}";
        return toRet;

    }
}

