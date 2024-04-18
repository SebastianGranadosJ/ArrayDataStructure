package com.edu.upb.exercises.treeExercises.longTextReader;

public class WordCounter {

    private String word;
    private int counter;

    

    public WordCounter(String word) {
        this.word = word;
        counter = 1;
    }

    public void sumCounter(){
        counter++;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return word + " : " + counter ;
    }
    

    
}
