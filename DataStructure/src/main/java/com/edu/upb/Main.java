package com.edu.upb;

import com.edu.upb.util.scan.Scan;

public class Main {
    public static void main(String[] args) {

        System.out.println("Ingrese un input: ");

        String str = Scan.getStringInput();

        System.out.println("Input: " + str);

        //--------

        System.out.println("Ingrese un input: ");

        int nmr = Scan.getIntInput();

        System.out.println("Input: " + nmr);

        System.out.println(10 + nmr);

        //--------


        System.out.println("Ingrese un input: ");

        double dou = Scan.getIntInput();

        System.out.println("Input: " + dou);

        System.out.println(10 + dou);


        //--------


        System.out.println("Ingrese un input : ");

        int nmr2 = Scan.getValidatedIntInput();

        System.out.println("Input: " + nmr2);

        System.out.println(10 + nmr2);

        //--------

        System.out.println("Ingrese un input(char): ");

        char c = Scan.getCharInput();

        System.out.println("Input: " + c);

    }
}
