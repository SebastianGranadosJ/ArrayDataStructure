import com.edu.upb.array.Array;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ArrayTest {
    

    @Test
    void testGet(){
        Array<Integer> array = new Array<>(10);
        array.add(3);

        assertEquals(3, array.get(0));
    }

    @Test
    void testContains1(){
        Array<Integer> array = new Array<>(10);
        array.add(3);
        assertEquals(true, array.contains(3));
    }
    @Test
    void testContains1False(){
        Array<Integer> array = new Array<>(10);
        array.add(3);
        assertEquals(false, array.contains(2));
    }

    @Test
    void testContains2(){
        Array<Integer> array = new Array<>(10);
        array.add(3);
        array.add(4);
        array.add(6);

        Integer[] inter = {3, 4, 6};
        assertEquals(true, array.contains(inter));
    }
    @Test
    void testContains2False(){
        Array<Integer> array = new Array<>(10);
        array.add(3);
        array.add(4);
        array.add(6);

        Integer[] inter = {1, 4, 6};
        assertEquals(false, array.contains(inter));
    }
    @Test
    void testIsEmpty(){
        Array<Integer> array = new Array<>(10);
        
        assertEquals(true ,array.isEmpty());
    }
    @Test
    void testIsEmptyFalse(){
        Array<Integer> array = new Array<>(10);
        array.add(3);

        assertEquals(false ,array.isEmpty());
    }

    @Test
    void testAdd1(){
        Array<Integer> array = new Array<>(10);
        
        assertEquals(true, array.add(3));
    }
    @Test
    void testAdd1False(){
        Array<Integer> array = new Array<>(1);
        array.add(3);
        assertEquals(false, array.add(3));
    }
    @Test
    void testAdd2(){
        Array<Integer> array = new Array<>(10);
        Integer[] inters = {1,2, 3};
        
        assertEquals(true, array.add(0,inters));
    }
    @Test
    void testAdd2False(){
        Array<Integer> array = new Array<>(5);
        Integer[] inters = {1,2, 3};
        
        assertEquals(false, array.add(5,inters));
    }
    @Test 
    void testRemove1(){
        Array<Integer> array = new Array<>(10);
        Integer[] inters = {1, 2, 3, 4, 5, 6, 7};
        array.add(0, inters);

        assertEquals(true, array.remove(0));

    }
    @Test 
    void testRemoveFalse(){
        Array<Integer> array = new Array<>(10);
        Integer[] inters = {1, 2, 3, 4, 5, 6, 7};
        array.add(0, inters);

        assertEquals(false, array.remove(11));
        assertEquals(false, array.remove(-2));

    }
    @Test 
    void testRemove2(){
        Array<Integer> array = new Array<>(10);
        Integer[] inters = {1, 2, 3, 4, 5, 6, 7};
        array.add(0, inters);

        assertEquals(true, array.remove(1, 4));
        assertEquals(null, array.get(1));
        assertEquals(null, array.get(2));
        assertEquals(null, array.get(3));
        assertEquals(5, array.get(4));
    }

    @Test 
    void testRemove2False(){
        Array<Integer> array = new Array<>(10);
        Integer[] inters = {1, 2, 3, 4, 5, 6, 7};
        array.add(0, inters);

        assertEquals(false, array.remove(11, 14));

    }
    @Test
    void testDimension(){
        Array<Integer> array = new Array<>(10);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);
        array.add(1);

        
        assertEquals(true, array.dimension(3));
        assertEquals(3, array.size());
        System.out.println(array.toString());

    }

    @Test
    void testDimensionFalse(){
        Array<Integer> array = new Array<>(10);
        
        assertEquals(false, array.dimension(-1));
        assertEquals(false, array.dimension(0));
        array.dimension(2);
        assertEquals(false, array.dimension(2));
    }
    @Test
    void testSet(){
        Array<Integer> array = new Array<>(10);

        assertEquals(true, array.set(0, 1));
        assertEquals(1, array.get(0));
        assertEquals(false, array.set(20, 1));
        assertEquals(false, array.set(-1, 1));

    }
    @Test 
    void clear(){
        Array<Integer> array = new Array<>(3);
        array.add(1);
        array.add(1);
        array.add(1);

        assertEquals(true, array.clear());
        assertEquals(null, array.get(0));
        assertEquals(null, array.get(1));
        assertEquals(null, array.get(2));

    }
    @Test
    void reverse(){
        Array<Integer> array = new Array<>(3);
        array.add(1);
        array.add(2);
        array.add(3);

        assertEquals(true, array.reverse());
        assertEquals(3, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(1, array.get(2));

    }

    @Test
    void testIndexOf(){
        Array<Integer> array = new Array<>(3);
        array.add(1);
        array.add(1);
        array.add(3);

        assertEquals(0, array.indexOf(1));
        assertEquals(2, array.indexOf(3));

    }
    @Test
    void testLastIndexOf(){
        Array<Integer> array = new Array<>(3);
        array.add(1);
        array.add(1);
        array.add(3);

        assertEquals(1, array.lastIndexOf(1));
        assertEquals(2, array.lastIndexOf(3));

    }

}
