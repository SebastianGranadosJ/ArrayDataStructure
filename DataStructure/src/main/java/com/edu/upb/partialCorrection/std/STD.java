package com.edu.upb.partialCorrection.std;

import java.util.function.ToIntFunction;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.util.iterator.Iterator;
import com.edu.upb.txtManager.TxtManager;

public class STD {

    public static void mean(){
        LinkedList<Integer> nmrs = TxtManager.readInts("std.in"); 
        Iterator<Integer> iter = nmrs.iterator();
        double sum = 0;
        while(iter.hasNext()){
            sum += iter.next();
        }
        double toWrite = sum/nmrs.size();
        TxtManager.writeDouble("std.out", toWrite); ;
    }

    public static void median(){
        LinkedList<Integer> nmrs = TxtManager.readInts("std.in"); 
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
        TxtManager.writeDouble("std.out", median); ;

    }

    public static void  mode(){
        LinkedList<Integer> nmrs = TxtManager.readInts("std.in"); 
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
        TxtManager.writeInt("std.out", mode); ;
    }
    public static void  frecuency(){
        LinkedList<Integer> nmrs = TxtManager.readInts("std.in"); 
        TxtManager.writeString("std.out", "Number | Times repeated"); ;
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
                if(actualNumber != 0){
                    TxtManager.writeString("std.out", actualNumber + " | " + actualreps);
                }
                actualNumber = element;
                actualreps = 1;
               
            }else{
                actualreps ++;
            }
            
        }
        TxtManager.writeString("std.out", actualNumber + " | " + actualreps);
    }

}
