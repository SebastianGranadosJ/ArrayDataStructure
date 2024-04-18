package com.edu.upb.exercises.treeExercises.CharTree;

import java.util.function.ToIntFunction;

import com.edu.upb.nolineal.binsearchtree.BinarySearchTree;
import com.edu.upb.scan.Scan;

/*Escribir un programa que procese un árbol binario cuyos nodos contengan caracteres,
y a partir del siguiente menú de opciones:
I (seguido de un carácter): Insertar un carácter.
B (seguido de un carácter): Buscar un carácter.
RE: Recorrido en orden.
RP: Recorrido en preorden.
RT: Recorrido postorden.
SA: Salir. */

public class CharTreeMenu {
    
    private BinarySearchTree<Character> charTree;

    public CharTreeMenu(){
        charTree = new BinarySearchTree<>( new ToIntFunction<Character>() {

            @Override
            public int applyAsInt(Character value) {
                return value.hashCode();
            }

        });
    }
    public void start(){
        boolean goodInput;
        String input = "";
       

        do{ 
            printMenu();
            goodInput = false;
            input = Scan.getStringInput();

            if(input.charAt(0) == 'I'&& input.length() == 2){
                insertChar(input.charAt(1));
                goodInput = true;
            }

            if(input.charAt(0) == 'B'&& input.length() == 2){
                buscar(input.charAt(1));
                goodInput = true;
            }

            if(input.equals("RE")){
                System.out.println(charTree.inOrder().toString());
                goodInput = true;
            }
            if(input.equals("RP")){
                System.out.println(charTree.preOrder().toString());
                goodInput = true;
            }
            if(input.equals("RT")){
                System.out.println(charTree.postOrder().toString());
                goodInput = true;
            }
            if(input.equals("T")){
                System.out.println(charTree.toString());
                goodInput = true;
            }
            
            if(!goodInput){
                System.out.println("Ingrese un input correcto.");
            }

        }while(!input.equals("SA"));


    }
    private void printMenu(){
        System.out.println("Ingrese la accion que desea realizar: ");
        System.out.println("I (seguido de un carácter): Insertar un carácter.");
        System.out.println("B (seguido de un carácter): Buscar un carácter.");
        System.out.println("RE: Recorrido en orden.");
        System.out.println("RP: Recorrido en preorden.");
        System.out.println("RT: Recorrido postorden.");
        System.out.println("T: Imprimir arbol.");
        System.out.println("SA: Salir.");

    }
    private boolean insertChar(Character c){
        return charTree.insert(c);
    }

    private boolean buscar(Character c){
        Character searched = charTree.search(c.hashCode());

        if(searched == null){
            return false;
        }

        return true;
    }

}
