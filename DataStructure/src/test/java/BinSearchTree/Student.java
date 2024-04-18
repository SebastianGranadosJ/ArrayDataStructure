package BinSearchTree;

// Class to test BinarySearchTree
public class Student {

    private String name;
    private int age;
    private double average;




    public Student(String name, int age, double average) {
        this.name = name;
        this.age = age;
        this.average = average;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getAverage() {
        return average;
    }
    public void setAverage(double average) {
        this.average = average;
    }
   
    
    public String toString(){
        String string = "";
        string += name + " " + average;
        return string;
    }

}
