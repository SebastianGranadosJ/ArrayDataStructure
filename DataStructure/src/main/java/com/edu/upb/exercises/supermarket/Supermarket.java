package com.edu.upb.exercises.supermarket;

import java.util.function.Predicate;

import com.edu.upb.array.Array;
import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.queue.list.Queue;
import com.edu.upb.scan.Scan;

/*Un pequeño supermercado dispone en la salida de tres cajas de pago. En el local hay
25 carritos de compra. Escribir un programa que simule el funcionamiento, siguiendo
las siguientes reglas:
• Si cuando llega un cliente no hay ningún carrito disponible, espera a que lo haya.
• Ningún cliente se impacienta y abandona el supermercado sin pasar por alguna de
las colas de las cajas.
• Cuando un cliente finaliza su compra, se coloca en la cola de la caja que hay
menos gente, y no se cambia de cola.
• En el momento en que un cliente paga en la caja, su carrito de la compra queda
disponible.
Representar la lista de carritos de la compra y las cajas de salida mediante colas.  */

public class Supermarket {
    private int availableCarts;
    private Array<Queue<String>> payBoxes;
    private Queue<String> clientsWaiting;
    private LinkedList<String> clientsShopping;

    public Supermarket() {
        availableCarts = 25;
        payBoxes = new Array<>(3);
        clientsWaiting = new Queue<>();
        clientsShopping = new LinkedList<>();
        for(int ii = 0; ii < payBoxes.lenght(); ii++){
            payBoxes.add(new Queue<>());
        }
    }

    public void start(){
        int choice;
        String clientName;
        do{
            System.out.println("--- Patitos SuperMarket ---");
            displayActions();
            choice = menuInput();

            switch (choice) {
                case 1:
                    System.out.println("Enter client's name: ");
                    clientName = Scan.getStringInput();
                    if(clientArrives(clientName)){
                        System.out.println("Client has get his cart");
                    }else{
                        System.out.println("There isnt any available cart, Client is going wait.");
                    }

                    break;
            
                case 2:
                    System.out.println("Enter client's name: ");
                    clientName = Scan.getStringInput();
                    if(clientFinishesShopping(clientName)){
                        System.out.println("Client has finished shopping.");
                    }else{
                        System.out.println("Client was not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter pay box number: ");
                    int queue = payInput() - 1;
                    if(clientPays(queue)){
                        System.out.println("Client has paid.");
                    }else{
                        System.out.println("There isnt any client in that pay box.");
                    }
                    break;
                case 4:
                    generalStatus();
                    break;
                default:
                    break;
            }

        }while(choice != 5);
        
        


    }


    private boolean clientArrives(String name){
        if(availableCarts > 0){
            clientsShopping.add(name);
            availableCarts--;
            return true;
        }else{
            clientsWaiting.insert(name);
            return false;
        }
    }

    private  boolean clientFinishesShopping(String name){

        Predicate<String> predicate  = new Predicate<String>() {
            @Override
            public boolean test(String t) {
                if(t.equals(name)){
                    return true;
                }
                return false;
            }
            
        };

        if(clientsShopping.remove(predicate)){
            int indexQueue = 0;
            int amtClients = payBoxes.get(indexQueue).size();

            for(int ii = 0;ii < payBoxes.lenght(); ii++ ){

                if(amtClients > payBoxes.get(ii).size()){
                    indexQueue = ii;
                    amtClients = payBoxes.get(ii).size();
                }
            }
            payBoxes.get(indexQueue).insert(name);
            return true;
        }
        return false;
    }

    private boolean clientPays(int queue){

        if(!payBoxes.get(queue).isEmpty()){
            payBoxes.get(queue).extract();

            if(!clientsWaiting.isEmpty()){
                clientsShopping.add(clientsWaiting.extract());
            }else{
                availableCarts++;
            }
            
            return true;
        }
        return false;
    }
    

    private void displayActions(){
        System.out.println("Actions Menu: ");

        System.out.println("1. New client arrives");

        System.out.println("2. Client finishes shopping");

        System.out.println("3. Customer pays");

        System.out.println("4. Check General Status");

        System.out.println("5. Close system");
    }

    private int menuInput(){
        int choice = 0;

        while(choice < 1 || choice >5){
            choice = Scan.getValidatedIntInput();
        }
        return choice;
    }

    private int payInput(){
        int payBox = 0;

        while(payBox < 1 || payBox > 3){
            payBox = Scan.getValidatedIntInput();
        }
        return payBox;
    }

    private void generalStatus(){
        System.out.println("Available carts: " + availableCarts);
        System.out.println("Clients waiting for a cart: " + clientsWaiting.toString());
        System.out.println("Clients shopping: " + clientsShopping.toString());

        System.out.println("Pay box 1: "  + payBoxes.get(0).toString() );
        System.out.println("Pay box 2: "  + payBoxes.get(1).toString() );
        System.out.println("Pay box 3: "  + payBoxes.get(2).toString() );

    }


    
}
