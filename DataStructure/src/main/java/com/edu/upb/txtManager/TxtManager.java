package com.edu.upb.txtManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.util.iterator.Iterator;

public class TxtManager {

    public static LinkedList<String> readLines(String filePath) {
        LinkedList<String> lines = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void writeLines(String filePath, LinkedList<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            Iterator<String> iter = lines.iterator();
            while (iter.hasNext()) {
                writer.write(iter.next());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Integer> readInts(String filePath) {
        LinkedList<Integer> numbers = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                numbers.add(number);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return numbers;
    }

    public static void writeInts(String filePath, LinkedList<Integer> ints) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            Iterator<Integer> iter = ints.iterator();
            while (iter.hasNext()) {
                writer.write(iter.next().toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInt(String filePath, int number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(Integer.toString(number));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDouble(String filePath, double number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(Double.toString(number));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeString(String filePath, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearFile(String filePath) {
        // Puedes dejar esta función tal como estaba
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
