package com.edu.upb.util.scan;
import java.util.Scanner;

public class Scan {
    
    @SuppressWarnings("resource")
    public static String getStringInput(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        return input;
    }

    @SuppressWarnings("resource")
    public static int getIntInput() {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        return input;
    }
    @SuppressWarnings("resource")
    public static int getValidatedIntInput() {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            scanner.next(); 
        }
        int input = scanner.nextInt();

        return input;
    }
    @SuppressWarnings("resource")
    public static double getDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();

        return input;
    }
    @SuppressWarnings("resource")
    public static char getCharInput() {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);

        return input;
    }


}
