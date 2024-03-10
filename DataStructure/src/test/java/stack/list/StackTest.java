package stack.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.edu.upb.array.Array;
import com.edu.upb.stack.list.Stack;


public class StackTest {

    @Test
    void testPush(){
        Stack<Integer> stack = new Stack<>();
        assertEquals(true, stack.push(1));
        assertEquals(true, stack.push(2));
        assertEquals(true, stack.push(3));

        System.out.println(stack.toString());

    }
    @Test
    void testPeek(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());
        assertNotSame(2, stack.peek());

        System.out.println(stack.toString());

    }

    @Test
    void testPop(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        

        System.out.println(stack.toString());

    }



     @Test
    void testClear(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(true, stack.clear());
        assertEquals(true, stack.isEmpty());
        
    }
    @Test
    void testContains(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);


        assertEquals(true, stack.contains(1));
        assertEquals(false, stack.contains(10));

    }
    @Test
    void testContains2(){
        Stack<Integer> stack = new Stack<>();
        Integer[] inters = {1, 2, 3, 4};
        Integer[] inters2 = {5, 2, 3, 4};
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //list.add(inters);

        assertEquals(true, stack.contains(inters));
        assertEquals(false, stack.contains(inters2));

    }
    @Test
    void testContains3(){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Array<Integer> array = new Array<>(4);

        stack.push(66);
        stack.push(88);
        stack.push(1);
        stack.push(6);

        stack2.push(66);
        stack2.push(88);
        stack2.push(1);
        stack2.push(6);


        array.add(66);
        array.add(88);
        array.add(2343);
        array.add(6);


        assertEquals(true, stack.contains(stack2));
        assertEquals(false, stack.contains(array));
        System.out.println(stack.toString());
    }

    @Test
    void isEmpty(){
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    void reverse(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toString());

        assertEquals(true, stack.reverse());
        assertEquals(3, stack.size());
        assertEquals(1, stack.peek());

        System.out.println(stack.toString());

        

    }
    @Test
    void testSize(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        
    }

}
