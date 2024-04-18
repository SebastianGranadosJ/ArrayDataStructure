package hashmap;

import org.junit.jupiter.api.Test;

import com.edu.upb.nolineal.hashMap.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;


public class HashMapTest {

    @Test
    void hashMap(){
        
        HashMap<Integer> hash = new HashMap<>(1000);
        Random random = new Random();
        assertEquals(true, hash.isEmpty());
        for(int ii = 0; ii < 1000; ii++){
           
            hash.put(Integer.toString( random.nextInt(100000000) ), ii);
            System.out.println(hash.getRepeatedCnt());
        }
        assertEquals(false, hash.isEmpty());
        System.out.println(hash.toString());
    }

    @Test
    void getTest(){
        HashMap<Integer> hash = new HashMap<>(100);
        for(int ii = 0; ii < 10; ii++){
        
            hash.put(Integer.toString( ii ), ii);
        }
        System.out.println(hash.toString());

        assertEquals(0, hash.get(Integer.toString(0)));


    }

    @Test
    void getRemove(){
        HashMap<Integer> hash = new HashMap<>(100);
        for(int ii = 0; ii < 10; ii++){
        
            hash.put(Integer.toString( ii ), ii);
        }
        System.out.println(hash.toString());

        assertEquals(true, hash.remove(Integer.toString(0)));

        System.out.println(hash.toString());

    }

    @Test
    void putTest(){
        HashMap<Integer> hash = new HashMap<>(100);
       hash.put("172", 123);

    }
    
}
