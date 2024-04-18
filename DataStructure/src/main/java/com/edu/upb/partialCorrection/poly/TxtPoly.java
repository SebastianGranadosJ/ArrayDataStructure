package com.edu.upb.partialCorrection.poly;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.util.iterator.Iterator;
public class TxtPoly {
    // <6, -1, 0, 3, 0, 12> 


    public static LinkedList<Integer> readInts(String filePath) {
        LinkedList<Integer> numbers = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            line = line.substring(1, line.length() - 1);
            String[] splitedLine = line.split(",");
            
            for(int ii = 0; ii < splitedLine.length; ii++){
                numbers.add(Integer.parseInt(splitedLine[ii]));
            }
                
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return numbers;
    }

    public static void writeInts(String filePath, LinkedList<Integer> ints) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            Iterator<Integer> iter = ints.iterator();
            int last = ints.size() - 1;
            int cnt = 0;
            writer.write("<");
            while (iter.hasNext()) {
                if(cnt == last){
                    writer.write(iter.next().toString());
                }else{
                    writer.write(iter.next().toString() + ",");
                }
                cnt++;
            }
            writer.write(">");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
