package BinTree;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.edu.upb.nolineal.bintree.BinTree;

public class BinTreeTest {

    @Test
    void testPreOrder(){
        BinTree<String> tree = new BinTree<>("+");

        tree.insert("*");
        tree.insert("/");
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");

        System.out.println(tree.preOrder().toString());

    }

    @Test
    void tesInOrder(){
        BinTree<String> tree = new BinTree<>("+");

        tree.insert("*");
        tree.insert("/");
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");

        System.out.println(tree.inOrder().toString());

    }
    
    @Test
    void testPostOrder(){
        BinTree<String> tree = new BinTree<>("+");

        tree.insert("*");
        tree.insert("/");
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");

        System.out.println(tree.postOrder().toString());

    }

    @Test
    void testEnAmplitud(){
        BinTree<String> tree = new BinTree<>("+");

        tree.insert("*");
        tree.insert("/");
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        System.out.println(tree.inAmplitude().toString());

    }

    @Test
    void testGetHeight(){
        BinTree<String> tree = new BinTree<>("+");

        tree.insert("*");
        tree.insert("/");
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        tree.insert("e");
        tree.insert("f");

        System.out.println(tree.getHeight());

    }

    @Test
    void testIsFull(){

        BinTree<String> tree = new BinTree<>();
        
        assertFalse(tree.isFull());

        tree.insert("+");

        tree.insert("*");
        tree.insert("/");

        tree.insert("a");
        tree.insert("b");

        tree.insert("c");

        assertFalse(tree.isFull());

        tree.insert("d");

        assertTrue(tree.isFull());

        System.out.println(tree.toString());

    }

    @Test
    void testIsFull2(){

        BinTree<String> tree = new BinTree<>();
        
        assertFalse(tree.isFull());
        
        tree.insert("+");
        
        assertTrue(tree.isFull());
        
        tree.insert("*");
        tree.insert("/");
        
        tree.insert("a");
        tree.insert("b");
        
        tree.insert("d");
        
        assertFalse(tree.isFull());
        
        tree.insert("c");
        
        assertTrue(tree.isFull());

        System.out.println(tree.toString());

    }


    @Test
    void testInsert(){
        BinTree<String> tree = new BinTree<>();

        tree.insert("+");

        tree.insert("*");

        System.out.println(tree.toString());

        assertFalse(tree.isFull());

        tree.insert("/");

        tree.insert("1");

        System.out.println(tree.toString());

        assertFalse(tree.isFull());


        tree.insert("2");
        tree.insert("3");
        tree.insert("4");

        assertTrue(tree.isFull());
        
        System.out.println(tree.toString());


    }

    @Test
    void removeTest(){
        BinTree<String> tree = new BinTree<>("+");
        tree.insert("*");
        tree.insert("/");
        tree.insert("a");
        tree.insert("b");
        tree.insert("c");
        tree.insert("d");
        tree.insert("e");
        tree.insert("f");
        tree.insert("h");
        tree.insert("i");
        tree.insert("j");
        tree.insert("k");
        tree.insert("ñ");
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");
        tree.insert("4");
        tree.insert("5");
        tree.insert("6");
        tree.insert("7");
        tree.insert("8");
        tree.insert("9");
        tree.insert("10");
        tree.insert("11");
        tree.insert("12");
        tree.insert("13");
        tree.insert("14");
        tree.insert("15");
        tree.insert("16");
        tree.insert("17");
        tree.insert("18");
        tree.insert("19");
        tree.insert("20");
        tree.insert("21");
        tree.insert("22");
        tree.insert("23");
        tree.insert("24");




        System.out.println(tree.toString());

        tree.remove("a");

        System.out.println(tree.toString());


    }

    
}
