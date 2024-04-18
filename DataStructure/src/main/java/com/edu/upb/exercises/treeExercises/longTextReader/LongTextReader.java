package com.edu.upb.exercises.treeExercises.longTextReader;

import java.util.function.ToIntFunction;



import com.edu.upb.array.Array;
import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.nolineal.binsearchtree.BinarySearchTree;
import com.edu.upb.util.iterator.Iterator;
    /*13.2. Escribir un programa que lea un texto de longitud indeterminada y que produzca
como resultado la lista de todas las palabras diferentes contenidas en el texto, así
como su frecuencia de aparición. Hacer uso de la estructura árbol binario de búsqueda para localizar cada nodo del árbol que tenga una palabra y su frecuencia. 
 */

public class LongTextReader {
    BinarySearchTree<WordCounter> tree;
    
    public LongTextReader(String text){
        tree = getTreeByText(text);
    }  

    public int searchWordFrenquency(String word){
        WordCounter ret = tree.search(word.hashCode());
        if(ret == null){
            return 0;
        }
        return ret.getCounter();

    }

    public String toStringTree(){
        return tree.toString();
    }

    
    public BinarySearchTree<WordCounter> getTreeByText(String text){
        LinkedList<WordCounter> wordsCounter = getWordsFrenList(text);
        Iterator<WordCounter> iter = wordsCounter.iterator();
        BinarySearchTree<WordCounter> tree = new BinarySearchTree<>(new ToIntFunction<WordCounter>() {

            @Override
            public int applyAsInt(WordCounter value) {
                return value.getWord().hashCode();
            }
            
        });

        while(iter.hasNext()){
            tree.insert(iter.next());
        }
        return tree;

    }

    public LinkedList<WordCounter> getWordsFrenList(String text){
        String[] words = text.split(" ");
        Array<WordCounter> wordsCounterArray = new Array<>(words.length);
        boolean exist;
        for(int ii = 0; ii < words.length; ii++){
            String word = words[ii];
            exist = false;

            for(int jj = 0; jj < wordsCounterArray.size(); jj++){
                if(wordsCounterArray.get(jj).getWord().equals(word)){
                    exist = true;
                    wordsCounterArray.get(jj).sumCounter();
                }
            }

            if(!exist){
                wordsCounterArray.add(new WordCounter(word));
            }

        }   
        LinkedList<WordCounter> retList = new LinkedList<>();
        retList.add(wordsCounterArray);

        return retList;



    }

    

}
