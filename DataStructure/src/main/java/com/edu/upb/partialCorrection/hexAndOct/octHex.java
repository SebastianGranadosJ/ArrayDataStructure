package com.edu.upb.partialCorrection.hexAndOct;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.txtManager.TxtManager;
import com.edu.upb.util.iterator.Iterator;

/*
 * Desarrollar una rutina para cambiar entre sistemas numéricos octal a hexadecimal, hexadecimal a octal
para números muy largos, es decir números que no pueden almacenarse en una variable primitiva
disponible en el lenguaje.
Nota: Se usa entrada por archivo que depende del formato de entrada (in.hex o in.oct) y se da salida por
archivo que depende del formato de entrada (out.hex o out.oct). Es decir, a una entrada “numero.hex”
su salida correspondiente es un “numero.oct”y viceversa. 
 */

public class octHex {
 
        private static LinkedList<Integer> octalToBinary() {
            LinkedList<Integer> binaryNumber = new LinkedList<>();
            String octalNumber = TxtManager.readLines("in.oct").peek();
            System.out.println(octalNumber);

            for (int ii = 0; ii < octalNumber.length(); ii++) {
                int digit = Character.getNumericValue(octalNumber.charAt(ii));
              
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(digit));
                while (binary.length() < 3) {
                    binary.insert(0, "0");
                }
          
                for (int jj = 0; jj < binary.length(); jj++) {
                    binaryNumber.add(Character.getNumericValue(binary.charAt(jj)));
                }
            }
            while(binaryNumber.peek() == 0){
                binaryNumber.poll();
            }
            System.out.println(binaryNumber.toString());
            return binaryNumber;
        }
        public static void octToHex() {
            LinkedList<Integer> binaryNumber = octalToBinary();
            StringBuilder hexadecimal = new StringBuilder();
            
            while (binaryNumber.size() % 4 != 0) {
                binaryNumber.addFirst(0);
            }
            Iterator<Integer> iter = binaryNumber.iterator();
            while(iter.hasNext()) {
                int dec = iter.next() * 8 + iter.next() * 4 + iter.next() * 2 + iter.next();
                hexadecimal.append(Integer.toHexString(dec).toUpperCase());
            }
            TxtManager.writeString("out.hex", hexadecimal.toString());
        }   

        private static LinkedList<Integer> hexToBinary() {
            LinkedList<Integer> binaryNumber = new LinkedList<>();
            String hexNumber = TxtManager.readLines("in.hex").peek();
           

            for (int ii = 0; ii < hexNumber.length(); ii++) {
                char digit =  hexNumber.charAt(ii) ;
              
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(hexaToDec(digit)));

                while (binary.length() < 4) {
                    binary.insert(0, "0");
                }
           
                for (int jj = 0; jj < binary.length(); jj++) {
                    binaryNumber.add(Character.getNumericValue(binary.charAt(jj)));
                }
            }
            while(binaryNumber.peek() == 0){
                binaryNumber.poll();
            }
            System.out.println(binaryNumber.toString());
            return binaryNumber;
        }

        public static void hexToOct() {
            LinkedList<Integer> binaryNumber = hexToBinary();
            StringBuilder octal = new StringBuilder();
            
            while (binaryNumber.size() % 3 != 0) {
                binaryNumber.addFirst(0);
            }
            Iterator<Integer> iter = binaryNumber.iterator();

            while(iter.hasNext()) {
                int dec =  iter.next() * 4 + iter.next() * 2 + iter.next();
                octal.append(Integer.toOctalString(dec));
            }
            TxtManager.writeString("out.oct", octal.toString());
        }

       
        private static int hexaToDec(char hexadecimal) {
            String hec = "0123456789ABCDEF";
            int decimal = hec.indexOf(hexadecimal);
            return decimal;
        }
        public static void main(String[] args) {
            hexToOct();
        }
    }

