package com.edu.upb.partialCorrection.calculator;
import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.scan.Scan;
import com.edu.upb.util.iterator.Iterator;

public class Calculator {
    /*
     * Desarrollar una calculadora que permita restar y calcular el módulo de números enteros muy largos, es
decir números que no pueden almacenarse en una variable primitiva disponible en el lenguaje.
Nota: Se usa entrada estándar. 
     */


     public static LinkedList<Integer> convertToLinkedList(String number) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int ii = 0; ii < number.length(); ii++) {
            int digit = Character.getNumericValue(number.charAt(ii));
            list.add(digit);
        }
        
        return list;
    }
    public static void mod(){
        System.out.println("Modulo A % B");
        System.out.println("Ingrese A : ");
        LinkedList<Integer> nmr1 = convertToLinkedList(Scan.getStringInput());
        System.out.println("Ingrese B : ");
        LinkedList<Integer> nmr2 = convertToLinkedList(Scan.getStringInput());
        while(nmr1.size() < nmr2.size()){
            nmr1.addFirst(0);
        }
        while(nmr1.size() > nmr2.size()){
            nmr2.addFirst(0);
        }

        if(!biggerThan(nmr1, nmr2)){
            System.out.println(nmr1.toString());
            
        }else{

            while(biggerOrEqual(nmr1, nmr2)){
                nmr1 = sustract(nmr1, nmr2);
            }
            System.out.println(nmr1);
            



        }

    }
    public static void sustract(){
        System.out.println("Resta A - B");
        System.out.println("Ingrese A : ");
        LinkedList<Integer> nmr1 = convertToLinkedList(Scan.getStringInput());
        System.out.println("Ingrese B : ");
        LinkedList<Integer> nmr2 = convertToLinkedList(Scan.getStringInput());
        LinkedList<Integer> result = new LinkedList<>();

        while(nmr1.size() < nmr2.size()){
            nmr1.addFirst(0);
        }
        while(nmr1.size() > nmr2.size()){
            nmr2.addFirst(0);
        }
        int taked = 0;
        boolean bigger = biggerThan(nmr1, nmr2);

        if(bigger){

            while(!nmr1.isEmpty() && !nmr2.isEmpty()){
                int digit1 = nmr1.pollLast();
                int digit2 = nmr2.pollLast();
    
                int rest = digit1 - digit2 - taked;
    
                if(rest < 0){
                    rest += 10;
                    taked = 1;
                }else{
                    taked = 0;
                }
    
                result.addFirst(rest);
            }
            System.out.println(result.toString());
    

        }else{

            while(!nmr1.isEmpty() && !nmr2.isEmpty()){
                int digit1 = nmr2.pollLast();
                int digit2 = nmr1.pollLast();
    
                int rest = digit1 - digit2 - taked;
    
                if(rest < 0){
                    rest += 10;
                    taked = 1;
                }else{
                    taked = 0;
                }
    
                result.addFirst(rest);
            }

            LinkedList<Integer> negativeResult = new LinkedList<>();
            Iterator<Integer> iterRes = result.iterator();

            while(iterRes.hasNext()){
                negativeResult.add(iterRes.next()*-1);

            }
            
            System.out.println(negativeResult.toString());
        }
        

        
        
    }

    private static LinkedList<Integer> sustract(LinkedList<Integer> nmr1, LinkedList<Integer> nmr2){
        
        LinkedList<Integer> result = new LinkedList<>();

        while(nmr1.size() < nmr2.size()){
            nmr1.addFirst(0);
        }
        while(nmr1.size() > nmr2.size()){
            nmr2.addFirst(0);
        }
        
        int taked = 0;
        boolean bigger = biggerThan(nmr1, nmr2);
        Iterator<Integer> iter1 = nmr1.iteratorInverse();
        Iterator<Integer> iter2 = nmr2.iteratorInverse();

        if(bigger){

            while(iter1.hasNext() && iter2.hasNext()){
                int digit1 = iter1.next();
                int digit2 = iter2.next();
    
                int rest = digit1 - digit2 - taked;
    
                if(rest < 0){
                    rest += 10;
                    taked = 1;
                }else{
                    taked = 0;
                }
    
                result.addFirst(rest);
            }
           return result;
    

        }else{

            
            while(iter1.hasNext() && iter2.hasNext()){
                int digit1 = iter1.next();
                int digit2 = iter2.next();
    
                int rest = digit1 - digit2 - taked;
    
                if(rest < 0){
                    rest += 10;
                    taked = 1;
                }else{
                    taked = 0;
                }
    
                result.addFirst(rest);
            }

            LinkedList<Integer> negativeResult = new LinkedList<>();
            Iterator<Integer> iterRes = result.iterator();

            while(iterRes.hasNext()){
                negativeResult.add(iterRes.next()*-1);

            }
            
            return negativeResult;
        }
        

        
        
    }

    private static boolean biggerThan(LinkedList<Integer> nmr1, LinkedList<Integer> nmr2){
        
        Iterator<Integer> iter1 = nmr1.iterator();
        Iterator<Integer> iter2 = nmr2.iterator();
        
        while(iter1.hasNext() && iter2.hasNext()){
            int digit1 = iter1.next();
            int digit2 = iter2.next();

            if(digit1 > digit2){
                return true;
            }else{
                if(digit1 < digit2){
                    return false;
                }
                
            }
            
        }
        return false;

    }
    private static boolean biggerOrEqual(LinkedList<Integer> nmr1, LinkedList<Integer> nmr2){
        
        Iterator<Integer> iter1 = nmr1.iterator();
        Iterator<Integer> iter2 = nmr2.iterator();
        
        while(iter1.hasNext() && iter2.hasNext()){
            int digit1 = iter1.next();
            int digit2 = iter2.next();

            if(digit1 > digit2){
                return true;
            }else{
                if(digit1 < digit2){
                    return false;
                }
                
            }
            
        }
        return true;

    }
    public static void main(String[] args) {
        mod();
    }
}
