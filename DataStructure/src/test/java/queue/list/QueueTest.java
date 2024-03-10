package queue.list;

import com.edu.upb.queue.list.Queue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class QueueTest {


    @Test
    void clearTest(){
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println(queue.toString());
  

        assertEquals(true, queue.clear());

        System.out.println(queue.toString());

    }

    @Test 
    void reverseTest(){
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println(queue.toString());

        assertEquals(5, queue.size());
        assertEquals(1, queue.peek());
        assertEquals(true, queue.reverse());
        assertEquals(5, queue.peek());

        System.out.println(queue.toString());


        assertEquals(true, queue.reverse());
        assertEquals(1, queue.peek());

        System.out.println(queue.toString());


    }

    @Test 
    void reverseTest1(){
        Queue<Integer> queue = new Queue<>();
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println(queue.toString());

        assertEquals(5, queue.size());
        assertEquals(1, queue.peek());
        assertEquals(true, queue.reverse());
        assertEquals(5, queue.peek());

        System.out.println(queue.toString());

        assertEquals(true, queue.reverse());
        assertEquals(1, queue.peek());

        System.out.println(queue.toString());


    }

    @Test
    void sizeTest(){
        Queue<Integer> queue = new Queue<>();

        assertEquals(0, queue.size());

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        assertEquals(5, queue.size());

        queue.extract();
        queue.extract();
        queue.extract();

        assertEquals(2, queue.size());

        queue.extract();
        queue.extract();

        assertEquals(0, queue.size());
    }

    @Test
    void extractTest(){
        Queue<Integer> queue = new Queue<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        System.out.println(queue.toString());


        assertEquals(1, queue.extract());
        assertEquals(2, queue.extract());
        assertEquals(3, queue.extract());

        System.out.println(queue.toString());

        queue.insert(5);
        assertEquals(4, queue.extract());

        System.out.println(queue.toString());

        assertEquals(5, queue.extract());
        System.out.println(queue.toString());

    }

    @Test
    void extractTest1(){
        Queue<Integer> queue = new Queue<>();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        System.out.println(queue.toString());

        assertEquals(1, queue.extract());
        assertEquals(2, queue.extract());
        assertEquals(3, queue.extract());

        System.out.println(queue.toString());

        queue.insert(5);
        queue.insert(6);
        queue.insert(7);

        System.out.println(queue.toString());

        assertEquals(4, queue.extract());
        System.out.println(queue.toString());

        assertEquals(5, queue.extract());
        assertEquals(6, queue.extract());

        System.out.println(queue.toString());

    }

    @Test
    void insertTest(){
        Queue<Integer> queue = new Queue<>();

        assertEquals(true, queue.insert(1));
        assertEquals(true, queue.insert(2));
        assertEquals(true, queue.insert(3));
        assertEquals(true, queue.insert(4));

        System.out.println(queue.toString());

        queue.extract();
        queue.extract();
        queue.extract();

        assertEquals(true, queue.insert(5));
        assertEquals(true, queue.insert(6));

        System.out.println(queue.toString());
        queue.extract();
        queue.extract();

        System.out.println(queue.toString());

    }

    @Test
    void peekTest(){
        Queue<Integer> queue = new Queue<>();

        assertEquals(true, queue.insert(1));
        assertEquals(true, queue.insert(2));
        assertEquals(true, queue.insert(3));
        assertEquals(true, queue.insert(4));

        assertEquals(1, queue.peek());

        queue.extract();
        queue.extract();
        queue.extract();

        assertEquals(4, queue.peek());

        queue.insert(5);
        queue.insert(6);
        queue.insert(7);

        queue.extract();

        assertEquals(5, queue.peek());

        queue.extract();
        
        assertEquals(6, queue.peek());
    }

    @Test
    void isEmptyTest(){
        Queue<Integer> queue = new Queue<>();
        assertEquals(true, queue.isEmpty());

        assertEquals(true, queue.insert(1));
        assertEquals(true, queue.insert(2));
        assertEquals(true, queue.insert(3));
        assertEquals(true, queue.insert(4));

        assertEquals(false, queue.isEmpty());

        queue.extract();
        queue.extract();
        queue.extract();
        queue.extract();

        
        assertEquals(true, queue.isEmpty());

    }

}
