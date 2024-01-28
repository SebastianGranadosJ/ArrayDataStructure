package com.edu.upb;

import java.util.function.Predicate;

import com.edu.upb.array.Array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(10);

        System.out.println("--------------Add---------------");
        array.add(1);
        array.add(2);
        array.add(3);

        System.out.println(array.toString());

        System.out.println("--------------Add testing with Nulls---------------");

        array.set(1, null);
        System.out.println(array.toString());
        array.add(123);
        System.out.println(array.toString());
        
        System.out.println("---------------Add with array--------------");
        Integer[] inters = {0,0, 0};
        array.add(1, inters);
        System.out.println(array.toString());

        System.out.println("---------------Desgrafment--------------");
        array.set(9, 12);
        array.set(7, 3);
        array.set(5, 9);
        System.out.println(array.toString());
        array.defragment();
        System.out.println(array.toString());

        System.out.println("---------------Remove--------------");
        array.remove(1);
        System.out.println(array.toString());

        System.out.println("---------------Remove from to--------------");
        array.remove(2, 4);
        System.out.println(array.toString());

        System.out.println("---------------Dimension--------------");
        array.dimension(2);
        System.out.println(array.toString());
        array.dimension(12);
        System.out.println(array.toString());
        

        System.out.println("---------------Clear--------------");
        
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);

        System.out.println(array.toString());

        array.clear();

        System.out.println(array.toString());

        System.out.println("---------------Reverse--------------");
        
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);

        System.out.println(array.toString());

        array.reverse();

        System.out.println(array.toString());

        System.out.println("---------------Reverse--------------");
        Predicate<Integer> positivPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer nmr) {
                if(nmr == null){
                    return false;
                }

                return nmr > 0;
            }
        };

        array.add(-1);
        array.add(-100);
        array.add(-2);
        array.add(-1);
       

        System.out.println(array.toString());
        array.remove(positivPredicate);

        System.out.println(array.toString());
        

    }
}
