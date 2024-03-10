package linkedList.singly.circular;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import org.junit.jupiter.api.Test;

import com.edu.upb.array.Array;
import com.edu.upb.linkedList.singly.circular.LinkedList;

public class LinkedListTest {
    @Test
    void testClear(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);


        System.out.println(list.toString());
        assertEquals(true, list.clear());
        System.out.println(list.toString());
    }
    @Test
    void testContains(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1000);


        assertEquals(true, list.contains(1000));
        assertEquals(false, list.contains(10));

    }
    @Test
    void testContains2(){
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] inters = {1, 2, 3, 4};
        Integer[] inters2 = {5, 2, 3, 4};
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //list.add(inters);

        assertEquals(true, list.contains(inters));
        assertEquals(false, list.contains(inters2));

    }
    @Test
    void testContains3(){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        Array<Integer> array = new Array<>(4);

        list.add(66);
        list.add(88);
        list.add(1);
        list.add(6);

        list2.add(66);
        list2.add(88);
        list2.add(1);
        list2.add(6);

        array.add(66);
        array.add(88);
        array.add(2343);
        array.add(6);


        assertEquals(true, list.contains(list2));
        System.out.println(list.toString());
    }
    @Test
    void testContains4(){
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        Array<Integer> array = new Array<>(4);

        String var = "labebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasdlabebsitabebelinybebewikifumamarihuanaytambiensemeteelpickyselagonanidickielrasdasdasdasdasdasdasdasdasdasdasd";

        list.add(var);
        list.add("b");
        list.add("c");
        list.add("d");

        list2.add(var);
        list2.add("b");
        list2.add("c");
        list2.add("d");

        array.add(66);
        array.add(88);
        array.add(2343);
        array.add(6);


        assertEquals(true, list.contains(list2));
        System.out.println(list.toString());
    }



    @Test
    void reverse(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.toString());

        assertEquals(true, list.reverse());
        assertEquals(2, list.size());

        System.out.println(list.toString());

        

    }
    @Test
    void testSize(){
        LinkedList<Integer> list = new LinkedList<>();
        Array<Integer> array = new Array<>(3);
        Integer[] inters = {1, 2, 3, 4};

        array.add(1);
        array.add(2);
        array.add(111);

        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(2, list.size());
        assertEquals(true, list.add(array ));
        assertEquals(5, list.size());
        assertEquals(true, list.add(inters ));
        assertEquals(9, list.size());
        
        }

    @Test
    void testAdd1(){
       LinkedList<Integer> list = new LinkedList<>();

       assertEquals(true, list.add(1));

       assertEquals(true, list.add(2));
       assertEquals(2, list.size());
       assertEquals(true, list.add(3));

       System.out.println(list.toString());
       
      }

  
    @Test
    void testAdd2(){
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] inters = {1, 2, 3, 4};

        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(inters ));
        
        System.out.println(list.toString());
         
        }

    @Test
    void testAdd3(){
        LinkedList<Integer> list = new LinkedList<>();
        Array<Integer> array = new Array<>(3);
        array.add(1);
        array.add(2);
        array.add(111);

        assertEquals(true, list.add(1));
        assertEquals(true, list.add(2));
        assertEquals(true, list.add(array ));
        
        System.out.println(list.toString());
         
        }
   
    
    @Test
    void testAddFirst1(){
        LinkedList<Integer> list = new LinkedList<>();

        assertEquals(true, list.addFirst(1));
        assertEquals(true, list.addFirst(2));
        assertEquals(true, list.addFirst(3 ));

        System.out.println(list.toString());
        
    }

    
    @Test
    void testAddFirst2(){
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] inters = {1, 2, 3, 4};

        assertEquals(true, list.addFirst(1));
        assertEquals(true, list.addFirst(2));
        assertEquals(true, list.addFirst(inters ));
        
        System.out.println(list.toString());
            
        }

    @Test
    void testAddFirst3(){
        LinkedList<Integer> list = new LinkedList<>();
        Array<Integer> array = new Array<>(3);


        array.add(1);
        array.add(2);
        array.add(111);

        assertEquals(true, list.addFirst(1));
        assertEquals(true, list.addFirst(2));
        assertEquals(true, list.addFirst(array ));
        
        System.out.println(list.toString());
            
        }
    @Test
    void testPeek(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);

        assertEquals(1, list.peek());

    }
    @Test
    void testPeekLast(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);



        assertEquals(1, list.peekLast());

    }
    @Test
    void testPeekArray(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(1);

        Object[] array = list.peekArray(2);


        assertEquals( array[0] , 5);
        assertEquals( array[1] , 3);

    }
    @Test
    void testPeekLastArray(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(1);

        Object[] array = list.peekLastArray(2);


        assertEquals( array[0] , 3);
        assertEquals( array[1] , 1);

    }

    @Test
    void testPeekCollection(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(1);

        LinkedList<Integer> retList = (LinkedList<Integer>) list.peekCollection(2);


        assertEquals( retList.peek() , 5);
        assertEquals( retList.peekLast() , 3);

    }
    @Test
    void testPeekLastCollection(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(1);

        LinkedList<Integer> retList = (LinkedList<Integer>) list.peekLastCollection(2);


        assertEquals( retList.peek() , 3);
        assertEquals( retList.peekLast(), 1);

    }

    @Test
    void testPoll(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(50000);
        list.add(3);
        list.add(1);
        list.add(3);

        assertEquals(50000, list.poll());
        assertEquals(3, list.poll());
        assertNotSame(5, list.peek());
        assertEquals(1, list.peek());

        System.out.println(list.toString());
    }

    @Test
    void testPollLast(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(30000);

        assertEquals(30000, list.pollLast());
        assertEquals(1, list.pollLast());
        assertEquals(3, list.pollLast());
        assertEquals(5, list.pollLast());


        System.out.println(list.toString());
    }
    @Test
    void testPollArray(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);

        Object[] array = list.pollArray(3);

        assertEquals(5, array[0]);
        assertEquals(3, array[1]);
        assertEquals(1, array[2]);
      
        System.out.println(array.toString());
    }
    @Test
    void testPollLastArray(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);

        Object[] array = list.pollLastArray(5);

        System.out.println(list.toString());

        assertEquals(5, array[0]);
        assertEquals(3, array[1]);
        assertEquals(1, array[2]);
      
        System.out.println(list.toString());
        for(int ii = 0; ii < array.length; ii++){
            System.out.println(array[ii]);
        }
        
    }
    @Test
    void testPollCollection(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);

        LinkedList<Integer> collec  = (LinkedList<Integer>) list.pollCollection(2);

        System.out.println(list.toString());

        assertEquals(5, collec.peek());
        assertEquals(3, collec.peekLast());
        
      
        System.out.println(list.toString());
    }
    @Test
    void testPollLastCollection(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(3);

        LinkedList<Integer> collec  = (LinkedList<Integer>) list.pollLastCollection(2);

        System.out.println(list.toString());

        assertEquals(1, collec.peek());
        assertEquals(3, collec.peekLast());
        
      
        System.out.println(list.toString());
    }
    @Test
    void testRemove(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(2);

        System.out.println(list.toString());
        assertEquals(true, list.remove(5));
        assertEquals(false, list.remove(10000));
        assertEquals(true, list.remove(2));

        
        System.out.println(list.toString());
        
       
    }

    @Test
    void testRemove2(){
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] toRemove = {1, 2, 6};
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(6);


        assertEquals(5, list.size());
        System.out.println(list.toString());

        assertEquals(true, list.remove(toRemove));
        assertEquals(false, list.remove(toRemove));
        assertEquals(false, list.contains(toRemove));
        assertEquals(2, list.size());

        System.out.println(list.toString());
    }
    @Test
    void testRemove3(){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> toRemove = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(6000);

        toRemove.add(5);
        toRemove.add(6000);
        toRemove.add(2);

        assertEquals(5, list.size());
        System.out.println(list.toString());

        assertEquals(true, list.remove(toRemove));
        assertEquals(false, list.remove(toRemove));
        assertEquals(false, list.contains(toRemove));
        assertEquals(2, list.size());

        System.out.println(list.toString());
    }

    @Test
    void testRemove4(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(-3);
        list.add(-1);
        list.add(2);
        list.add(6);

        Predicate<Integer> positivePredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer nmr) {
                if(nmr == null){
                    return false;
                }

                return nmr > 0;
            }
        };

    
        assertEquals(5, list.size());
        System.out.println(list.toString());

        assertEquals(true, list.remove(positivePredicate));
        assertEquals(false, list.contains(2));
        assertEquals(false, list.contains(6));
        assertEquals(false, list.contains(5));
        assertEquals(2, list.size());

        System.out.println(list.toString());
    }
    @Test
    void testReplace(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(-3);
        list.add(-1);
        list.add(2);
        list.add(6);

        Predicate<Integer> positivePredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer nmr) {
                if(nmr == null){
                    return false;
                }

                return nmr > 0;
            }
        };

        assertEquals(true, list.replace(6, -6, positivePredicate));
        assertEquals(-6, list.peekLast());
        assertEquals(false, list.replace(-1, 6, positivePredicate));
        assertEquals(false, list.replace(-1000, 6, positivePredicate));
        System.out.println(list.toString());
        
    }
    @Test
    void testReplace2(){
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] toRemove = {1, 2, 6};
        Integer[] toRemove2 = {1, -3};
        Integer[] toRemove3 = {1, 1000};
        Integer[] toReplace = {0, 0, 0};


        list.add(5);
        list.add(-3);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(6);



        Predicate<Integer> positivePredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer nmr) {
                if(nmr == null){
                    return false;
                }

                return nmr > 0;
            }
        };
        System.out.println("Initial  " + list.toString());
        assertEquals(true, list.replace(toRemove, toReplace, positivePredicate));
        System.out.println("1  " + list.toString());
        assertEquals(false, list.replace(toRemove2, toReplace, positivePredicate));
        System.out.println("2  " + list.toString());
        assertEquals(false, list.replace(toRemove3, toReplace, positivePredicate));
        System.out.println("3  " + list.toString());
        
        
    }
    @Test
    void testReplace3(){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> toRemove1 = new LinkedList<>();
        LinkedList<Integer> toRemove2 = new LinkedList<>();
        LinkedList<Integer> toRemove3 = new LinkedList<>();
        LinkedList<Integer> toReplace = new LinkedList<>();
        Integer[] r1 = {1, 2, 6};
        Integer[] r2 = {1, -3};
        Integer[] r3 = {1, 1000};
        Integer[] replace = {0, 0, 0};
        toRemove1.add(r1);
        toRemove2.add(r2);
        toRemove3.add(r3);
        toReplace.add(replace);


        list.add(5);
        list.add(-3);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(6);



        Predicate<Integer> positivePredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer nmr) {
                if(nmr == null){
                    return false;
                }

                return nmr > 0;
            }
        };
        System.out.println("Initial  " + list.toString());
        assertEquals(true, list.replace(toRemove1, toReplace, positivePredicate));
        System.out.println("1  " + list.toString());
        assertEquals(false, list.replace(toRemove2, toReplace, positivePredicate));
        System.out.println("2  " + list.toString());
        assertEquals(false, list.replace(toRemove3, toReplace, positivePredicate));
        System.out.println("3  " + list.toString());
        
        
    }
    @Test
    void testRetain1(){
        LinkedList<Integer> list = new LinkedList<>();
        Integer[] retain = {1, 2, 6};
        Integer[] retain2 = {1, 2, 6, 7};

        list.add(3);
        
        list.add(9);
        list.add(4);

        list.add(1);
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(5);       
        


        assertEquals(true, list.retain(retain));
        assertEquals(false, list.retain(retain2));
        assertEquals(false, list.contains(4));
        assertFalse(list.contains(-3));
        assertFalse(list.contains(7));


        System.out.println( list.toString());

    }
    @Test
    void testRetain2(){
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> retain1 = new LinkedList<>();
        LinkedList<Integer> retain2 = new LinkedList<>();
        Integer[] r1 = {1, 2, 6};
        Integer[] r2 = {1, 2, 6, 7};
        retain1.add(r1);
        retain2.add(r2);

        list.add(5);
        list.add(-3);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(7);

        assertEquals(true, list.retain(retain1));
        assertFalse(list.contains(5));
        assertFalse(list.contains(-3));
        assertFalse(list.contains(7));

        assertEquals(false, list.retain(retain2));

        System.out.println( list.toString());

    }
    @Test
    void testSet(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(7);   
        System.out.println("Initial" + list.toString());
        assertEquals(true, list.set(5, 100));
        System.out.println("1   " + list.toString());
        assertEquals(true, list.set(7, 200));
        System.out.println( "2   " +list.toString());
        assertEquals(true, list.set(1, 300));
        System.out.println( "3   " + list.toString());
        assertEquals(false, list.set(10, 300));
    }
    @Test
    void testSubList(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(7);   
     
        LinkedList<Integer> subList = (LinkedList<Integer>) list.subList(5, 5);
        assertEquals(5, subList.peek());
        System.out.println(subList.toString());
        subList = (LinkedList<Integer>) list.subList(5, 2);

        assertEquals(5, subList.peek());
        assertEquals(1, subList.peekLast());
        System.out.println(subList.toString());

        subList = (LinkedList<Integer>) list.subList(7, 1);
        assertEquals(true, subList.isEmpty());
        System.out.println(subList.toString());
    }
    @Test
    void testToArray(){
        LinkedList<Integer> list = new LinkedList<>();
    
        list.add(1);
        list.add(2);
        list.add(111);
        assertEquals(true, list.add(1));


        Object[] array = list.toArray();

        System.out.println(array[1]); 

    }
    @Test
    void testSort(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(7);

        ToIntFunction<Integer> toInt = new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value*100;
            }
            
        };
        assertEquals(true, list.sort(toInt));
        System.out.println(list.toString());

    }  



}
