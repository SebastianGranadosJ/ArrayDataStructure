package com.edu.upb.exercises.polynomials;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.util.iterator.Iterator;

public class PolyCalculator {
    
    

    public PolyCalculator(){
    }

    public double evaluate(LinkedList<Integer> polynomial, double x){
        double sum = 0;
        int pow = 0;
        Iterator<Integer> iter = polynomial.iterator();

        while(iter.hasNext()){
            Integer nmr = iter.next();
            sum += Math.pow(x, pow)*nmr;
            pow++;
        }
        return sum;
    }

    public LinkedList<Integer> derivate(LinkedList<Integer> polynomial){
        
        LinkedList<Integer> toReturn = new LinkedList<>();
        Iterator<Integer> iter = polynomial.iterator();
        int pow = 1;

        iter.next();
        while(iter.hasNext()){
            toReturn.add(iter.next()*pow);
            pow++;

        }

        return toReturn;
    }

    public LinkedList<Integer> sumTwoPolinomials(LinkedList<Integer> polynomial1, LinkedList<Integer> polynomial2){
        LinkedList<Integer> toReturn = new LinkedList<>();
        Iterator<Integer> iter1 = polynomial1.iterator();
        Iterator<Integer> iter2 = polynomial2.iterator();

        while(iter1.hasNext() && iter2.hasNext()){
            toReturn.add(iter1.next() + iter2.next());
        }
        while(iter1.hasNext()){
            toReturn.add(iter1.next());
        }
        while(iter2.hasNext()){
            toReturn.add(iter2.next());
        }
        return toReturn;
    }

}
