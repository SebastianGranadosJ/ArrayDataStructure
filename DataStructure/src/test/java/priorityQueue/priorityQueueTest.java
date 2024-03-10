package priorityQueue;
import com.edu.upb.priorityQueue.PriorityQueue;
import com.edu.upb.util.iterator.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class priorityQueueTest {

    @Test
    void peekTest(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);
        
        pQueue.insert(0, 3);
        pQueue.insert(0, 4);
        pQueue.insert(0, 5);

        pQueue.insert(1, 6);
        pQueue.insert(1, 2);

        pQueue.insert(2, 6);
        pQueue.insert(2, 1);
        pQueue.insert( 100);

        assertEquals(3, pQueue.peek());

    }

    @Test 
    void extractTest(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);

        pQueue.insert(0, 3);
        pQueue.insert(0, 4);
        pQueue.insert(0, 5);

        pQueue.insert(1, 6);
        pQueue.insert(1, 2);

        pQueue.insert(2, 6);
        pQueue.insert(2, 1);
        pQueue.insert( 100);

        System.out.println(pQueue.toString());

        assertEquals(3, pQueue.extract());

        assertEquals(4,  pQueue.extract());

        assertEquals(5,  pQueue.extract());

        assertEquals(6,  pQueue.extract());

        assertEquals(4, pQueue.size());

        System.out.println(pQueue.toString());

        assertEquals(2,  pQueue.extract());

        assertEquals(6,  pQueue.extract());

        assertEquals(1,  pQueue.extract());

        System.out.println(pQueue.toString());

        assertEquals(100,  pQueue.extract());

        assertEquals(null,  pQueue.extract());

        assertEquals(0, pQueue.size());
        System.out.println(pQueue.toString());

    }

    @Test
    void insertTest(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);
        
        assertEquals(true, pQueue.insert(0, 3));
        assertEquals(true, pQueue.insert(0, 4));
        assertEquals(true, pQueue.insert(0, 5));

        assertEquals(true, pQueue.insert(1, 6));
        assertEquals(true, pQueue.insert(1, 2));

        assertEquals(true, pQueue.insert(2, 6));
        assertEquals(true, pQueue.insert(2, 1));
        assertEquals(true, pQueue.insert(2, 7));
        assertEquals(true, pQueue.insert(2, 8));
        assertEquals(true, pQueue.insert( 100));
        assertEquals(3, pQueue.peek());

        assertEquals(10, pQueue.size());

        System.out.println(pQueue.toString());

    }

    @Test
    void reverseTest(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);

        pQueue.insert(0, 3);
        pQueue.insert(0, 4);
        pQueue.insert(0, 5);

        pQueue.insert(1, 6);
        pQueue.insert(1, 2);

        pQueue.insert(2, 6);
        pQueue.insert(2, 100);

        assertEquals(3, pQueue.peek());

        System.out.println(pQueue.toString());

        assertEquals(true, pQueue.reverse());

        assertEquals(100, pQueue.peek());

        System.out.println(pQueue.toString());

    }

    @Test
    void clearTest(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);

        pQueue.insert(0, 3);
        pQueue.insert(0, 4);
        pQueue.insert(0, 5);

        pQueue.insert(1, 6);
        pQueue.insert(1, 2);

        pQueue.insert(2, 6);
        pQueue.insert(2, 100);

        System.out.println(pQueue.toString());

        assertTrue(pQueue.clear());
        assertTrue(pQueue.isEmpty());

        System.out.println(pQueue.toString());

    }

    @Test
    
    void iteratorTEst(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);
        Iterator<Integer> iter = pQueue.iterator();
        pQueue.insert(0, 3);
        pQueue.insert(0, 4);
        pQueue.insert(0, 5);

        pQueue.insert(1, 6);
        pQueue.insert(1, 2);

        pQueue.insert(2, 6);
        pQueue.insert(2, 100);

      
        assertTrue(iter.hasNext());
        assertEquals(3, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(4, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(5, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(6, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(2, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(6, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(100, iter.next());

        assertFalse(iter.hasNext());

    }

    @Test

    void sizeTest(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);
        assertEquals(0, pQueue.size());

        pQueue.insert(0, 3);
        pQueue.insert(0, 4);
        pQueue.insert(0, 5);

        pQueue.insert(1, 6);
        pQueue.insert(1, 2);

        pQueue.insert(2, 6);
        pQueue.insert(2, 100);

        assertEquals(7, pQueue.size());


    }

    @Test
    void isEmptyTest(){
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(3);
        assertTrue( pQueue.isEmpty());

        pQueue.insert(0, 3);
        pQueue.insert(0, 4);
        pQueue.insert(0, 5);

        pQueue.insert(1, 6);
        pQueue.insert(1, 2);

        pQueue.insert(2, 6);
        pQueue.insert(2, 100);

        assertFalse( pQueue.isEmpty());

        pQueue.extract();
        pQueue.extract();
        pQueue.extract();
        pQueue.extract();
        pQueue.extract();
        pQueue.extract();
        pQueue.extract();

        assertTrue( pQueue.isEmpty());

    }
    
}
