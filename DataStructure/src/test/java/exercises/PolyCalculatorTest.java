package exercises;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.edu.upb.exercises.quizes.polynomials.PolyCalculator;
import com.edu.upb.linkedList.doubly.LinkedList;

public class PolyCalculatorTest {

    @Test
    void evaluateTest(){
        PolyCalculator cal = new PolyCalculator();
        LinkedList<Integer> poly = new LinkedList<>();
        poly.add(5);
        poly.add(2);
        poly.add(4);

        assertEquals(25, cal.evaluate(poly, 2));

    }
    @Test
    void derivateTest(){
        PolyCalculator cal = new PolyCalculator();
        LinkedList<Integer> poly = new LinkedList<>();
        poly.add(5);
        poly.add(2);
        poly.add(4);
        poly.add(1);
        poly.add(2);
        poly.add(3);

       System.out.println(cal.derivate(poly).toString());

    }

    @Test
    void sumTwoPolinomials(){
        PolyCalculator cal = new PolyCalculator();
        LinkedList<Integer> poly1 = new LinkedList<>();
        poly1.add(5);
        poly1.add(2);
        poly1.add(4);

        LinkedList<Integer> poly2 = new LinkedList<>();
        poly2.add(5);
        poly2.add(2);
        poly2.add(4);
        poly2.add(1);


       System.out.println(cal.sumTwoPolinomials(poly1, poly2).toString());

    }
    
}
