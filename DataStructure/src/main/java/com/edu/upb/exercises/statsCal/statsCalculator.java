package com.edu.upb.exercises.statsCal;

import java.util.function.ToIntFunction;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.util.iterator.Iterator;

public class statsCalculator {

    public static double mean(LinkedList<Integer> nmrs){
        Iterator<Integer> iter = nmrs.iterator();
        double sum = 0;

        while(iter.hasNext()){
            sum += iter.next();
        }
        return sum/nmrs.size();
    }

    public static double median(LinkedList<Integer> nmrs){
        double median = 0; 
        Iterator<Integer> iter;
        
        ToIntFunction<Integer> toInt = new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
               return value;
            }
            
        };

        nmrs.sort(toInt);
        iter = nmrs.iterator();
        int cnt = 0;
        Integer nmr;
        if(nmrs.size() % 2 == 1){

            while(iter.hasNext()){
                nmr = iter.next();
                cnt++;
  
                if(cnt == (nmrs.size() + 1)/ 2){
                    
                    median = nmr;
                }
            }

        }else{
            Integer sum =0;
            while(iter.hasNext()){
                nmr = iter.next();
                cnt++;
                if(cnt == (nmrs.size())/ 2 || cnt == (nmrs.size()/ 2) + 1){
                    sum  += nmr;
                }   
            }
            median = sum/ 2.0;
            
        
        }
        return median;

    }

    public static Integer mode(LinkedList<Integer> nmrs){
        Integer mode = 0;
        Integer modeReps = 0;
        Integer actualNumber = 0;
        Integer actualreps = 0;
        Iterator<Integer> iter;

        ToIntFunction<Integer> toInt = new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
               return value;
            }
            
        };
        nmrs.sort(toInt);
        iter = nmrs.iterator();
        while(iter.hasNext()){
            Integer element = iter.next();

            if(element != actualNumber){
                
                actualNumber = element;
                actualreps = 1;
               
            }else{
                actualreps ++;
            }

            if(actualreps > modeReps){
                mode = actualNumber;
                modeReps = actualreps;
            }

        }
        return mode;
    }

    public static Integer min(LinkedList<Integer> nmrs){
        ToIntFunction<Integer> toInt = new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
               return value;
            }
            
        };
        nmrs.sort(toInt);

        return nmrs.peek();
    }
    
    public static Integer max(LinkedList<Integer> nmrs){
        ToIntFunction<Integer> toInt = new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
               return value;
            }
            
        };
        nmrs.sort(toInt);

        return nmrs.peekLast();
    }
}
