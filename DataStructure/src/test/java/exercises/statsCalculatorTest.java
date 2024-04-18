package exercises;
import org.junit.jupiter.api.Test;

import com.edu.upb.exercises.statsCal.statsCalculator;
import com.edu.upb.linkedList.doubly.LinkedList;

public class statsCalculatorTest {

    @Test
    void meanTest(){
        LinkedList<Integer> nmrs = new LinkedList<>();
        nmrs.add(5);
        nmrs.add(2);
        nmrs.add(4);
        nmrs.add(5);
        nmrs.add(2);
        nmrs.add(40);
       System.out.println(statsCalculator.mean(nmrs));
    }
    @Test
    void medianTest(){
        LinkedList<Integer> nmrs = new LinkedList<>();
        nmrs.add(5);
        nmrs.add(5);
        nmrs.add(4);
        nmrs.add(2);


       System.out.println(statsCalculator.median(nmrs));
    }
    @Test
    void modeTest(){
        LinkedList<Integer> nmrs = new LinkedList<>();
        nmrs.add(2);
        nmrs.add(5);
        nmrs.add(4);
        nmrs.add(4);
        nmrs.add(2);
        nmrs.add(5);
        nmrs.add(4);
        nmrs.add(6);
        nmrs.add(6);
        nmrs.add(6);
        nmrs.add(6);
        nmrs.add(6);
        nmrs.add(6);
        nmrs.add(6);

       System.out.println(statsCalculator.mode(nmrs));
    }
    @Test
    void minTest(){
        LinkedList<Integer> nmrs = new LinkedList<>();
        nmrs.add(2);
        nmrs.add(5);
        nmrs.add(4);
        nmrs.add(4);
        nmrs.add(2);
        nmrs.add(50);
        nmrs.add(42);
        nmrs.add(41);
        nmrs.add(-1);
        System.err.println(statsCalculator.min(nmrs));

    }
    @Test
    void maxTest(){
        LinkedList<Integer> nmrs = new LinkedList<>();
        nmrs.add(2);
        nmrs.add(5);
        nmrs.add(4);
        nmrs.add(4);
        nmrs.add(2);
        nmrs.add(50);
        nmrs.add(42);
        nmrs.add(41);
        nmrs.add(-1);
        System.err.println(statsCalculator.max(nmrs));

    }
    
}
