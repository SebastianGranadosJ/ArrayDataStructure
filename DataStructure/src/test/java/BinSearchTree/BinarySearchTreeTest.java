package BinSearchTree;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.function.ToIntFunction;

import org.junit.jupiter.api.Test;

import com.edu.upb.nolineal.binsearchtree.BinarySearchTree;

public class BinarySearchTreeTest {

    @Test
    void removeTest(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
            
        });

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(1);
        tree.insert(9);
        tree.insert(10);
        
       


        System.out.println(tree.toString());

        tree.remove(3);

        System.out.println(tree.toString());


    }

    @Test
    void removeTest2(){
        BinarySearchTree<Student> tree = new BinarySearchTree<>(new ToIntFunction<Student>() {

            @Override
            public int applyAsInt(Student value) {
                double data = value.getAverage()*100;
                int ret = (int)data;
                return ret;
            }
            
        });
        Student stu = new Student("Marta", 17, 1.5);
        tree.insert(new Student("Manuel", 18, 2.5));
        tree.insert(stu);
        tree.insert(new Student("Matias", 19, 3.5));
        tree.insert(new Student("Anamaria", 20, 1));
        tree.insert(new Student("Rafael", 20, 2));
        tree.insert(new Student("Sebas", 16, 3));
        tree.insert(new Student("Checo", 10, 4));
        tree.insert(new Student("Marcos", 17, 0.5));
        tree.insert(new Student("Sara", 17, 4.5));
        tree.insert(new Student("Davo", 17, 5));
        
       


        System.out.println(tree.toString());

        tree.remove(stu);
        System.out.println(tree.getMax().toString());

        System.out.println(tree.toString());


    }
    
    @Test
    void testInsert(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
            
        });

        tree.insert(5);

        tree.insert(2);

        System.out.println(tree.toString());


        tree.insert(7);

        tree.insert(3);

        System.out.println(tree.toString());

        tree.insert(1);
        System.out.println(tree.toString());
        tree.insert(8);
        tree.insert(8);
        tree.insert(6);
        tree.insert(5);

        
        System.out.println(tree.toString());
    }

    @Test
    void testSeaech(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
            
        });

        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(8);
        tree.insert(6);
        tree.insert(5);

        
        assertEquals(8, tree.search(8));
        assertEquals(null, tree.search(100));
    }

    @Test
    void testGetMaxValue(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
            
        });

        assertEquals(null, tree.getMax());

        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(8);
        tree.insert(6);
        tree.insert(5);

        assertEquals(8, tree.getMax());
    }

    
    @Test
    void testGetInRange(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new ToIntFunction<Integer>() {

            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
            
        });

       

        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(1);
        tree.insert(8);
        tree.insert(8);
        tree.insert(6);
        tree.insert(5);
        tree.insert(-5);
        tree.insert(10);
        tree.insert(9);
        tree.insert(-1);
        tree.insert(12);
        System.out.println(tree.getInRange(3, 10));
        System.out.println(tree.toString());
    }

    @Test
    void testGetInRange2(){
        BinarySearchTree<Student> tree = new BinarySearchTree<>(new ToIntFunction<Student>() {

            @Override
            public int applyAsInt(Student value) {
                double data = value.getAverage()*100;
                int ret = (int)data;
                return ret;
            }
            
        });
        Student stu = new Student("Marta", 17, 1.5);
        tree.insert(new Student("Manuel", 18, 2.5));
        tree.insert(stu);
        tree.insert(new Student("Matias", 19, 3.5));
        tree.insert(new Student("Anamaria", 20, 1));
        tree.insert(new Student("Rafael", 20, 2));
        tree.insert(new Student("Sebas", 16, 3));
        tree.insert(new Student("Checo", 10, 4));
        tree.insert(new Student("Marcos", 17, 0.5));
        tree.insert(new Student("Sara", 17, 4.5));
        tree.insert(new Student("Davo", 17, 5));
        
       

        System.out.println(tree.getInRange(300, 501));
    }

    
}
