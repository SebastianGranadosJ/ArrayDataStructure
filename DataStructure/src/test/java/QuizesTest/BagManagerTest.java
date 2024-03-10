package QuizesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.edu.upb.linkedList.singly.LinkedList;
import com.edu.upb.quizes.quizBag.BagManager;
import com.edu.upb.quizes.quizBag.Item;
import com.edu.upb.quizes.quizBag.Type;


public class BagManagerTest {

    @Test
    void addBagTest(){

        BagManager bag = new BagManager();

        assertEquals(true, bag.addBag(8));
        assertEquals(true, bag.addBag(3));
        assertEquals(true, bag.addBag(12));
        assertEquals(false, bag.addBag(12));

        System.out.println(bag.toString());
        


    }

    @Test
    void addItem(){

        BagManager bag = new BagManager();
        Item item = new Item("Cimitarra", 12, Type.CLOTH, 1 , "C");
        Item item2 = new Item("Machete", 12, Type.CLOTH, 1 , "C");
        Item item3 = new Item("w", 12, Type.CLOTH, 1 , "C");
        Item item4 = new Item("1", 12, Type.CLOTH, 1 , "C");
        Item item5 = new Item("3", 12, Type.CLOTH, 1 , "C");
        Item item6 = new Item("4", 12, Type.CLOTH, 1 , "C");
        Item item7 = new Item("10", 12, Type.CLOTH, 1 , "C");


        assertEquals(true, bag.addItem(item));
        assertEquals(true, bag.addItem(item));
        assertEquals(true, bag.addItem(item2));
        assertEquals(true, bag.addItem(item3));
        assertEquals(true, bag.addItem(item4));
        assertEquals(true, bag.addItem(item5));
        assertEquals(true, bag.addItem(item6));
        assertEquals(false, bag.addItem(item7));



        System.out.println(bag.toString());
        


    }
  
    @Test
    void displayItems(){
        BagManager bag = new BagManager();
        Item item = new Item("Cimitarra", 2, Type.CLOTH, 1 , "C");
        Item item2 = new Item("Machete", 12, Type.CLOTH, 1 , "C");
        Item item3 = new Item("w", 120, Type.CLOTH, 1 , "C");
        Item item4 = new Item("1", 112, Type.CLOTH, 1 , "C");
        Item item5 = new Item("3", 2, Type.CLOTH, 1 , "C");
        Item item6 = new Item("4", 19, Type.CLOTH, 1 , "C");
        Item item7 = new Item("10", 999, Type.CLOTH, 1 , "C");


        assertEquals(true, bag.addItem(item));
        assertEquals(true, bag.addItem(item));
        assertEquals(true, bag.addItem(item2));
        assertEquals(true, bag.addItem(item3));
        assertEquals(true, bag.addItem(item4));
        assertEquals(true, bag.addItem(item5));
        assertEquals(true, bag.addItem(item6));
        assertEquals(false, bag.addItem(item7));

        LinkedList<Item> ret = bag.displayItems();

        System.out.println(ret.toString());
    }

    @Test
    void sortTaskByTRange(){

        BagManager bag = new BagManager();
        Item item = new Item("Cimitarra", 2, Type.CLOTH, 1 , "C");
        Item item2 = new Item("Machete", 12, Type.CLOTH, 1 , "C");
        Item item3 = new Item("w", 120, Type.CLOTH, 1 , "C");
        Item item4 = new Item("1", 112, Type.CLOTH, 1 , "C");
        Item item5 = new Item("3", 2, Type.CLOTH, 1 , "C");
        Item item6 = new Item("4", 19, Type.CLOTH, 1 , "C");
        Item item7 = new Item("10", 999, Type.CLOTH, 1 , "C");


        assertEquals(true, bag.addItem(item));
        assertEquals(true, bag.addItem(item));
        assertEquals(true, bag.addItem(item2));
        assertEquals(true, bag.addItem(item3));
        assertEquals(true, bag.addItem(item4));
        assertEquals(true, bag.addItem(item5));
        assertEquals(true, bag.addItem(item6));
        assertEquals(false, bag.addItem(item7));

        LinkedList<Item> s = bag.sortItemsByTRange();


        System.out.println(s.toString());

        System.out.println(bag.toString());
        


    }

    
}
