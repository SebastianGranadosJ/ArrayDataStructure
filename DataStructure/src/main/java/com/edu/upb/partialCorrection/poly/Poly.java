package com.edu.upb.partialCorrection.poly;

import com.edu.upb.linkedList.doubly.LinkedList;
import com.edu.upb.util.iterator.Iterator;

public class Poly {
    /*
     * La comunidad de científicos locos tiene grandes cantidades de datos en archivos de caracteres. Cada 
archivo representa un polinomio. Por Ejemplo: 12x^5+3x^3-x+6 es representado como: <6, -1, 0, 3, 0, 12> 
Los científicos quieren aplicar operaciones entre ellos. Pero se han encontrado con la dificultad que no 
pueden cargar los datos en ningún tipo de dato disponible en el lenguaje de programación. Por lo tanto, 
le solicitan que por favor desarrolle funciones con la capacidad para gestionar la cantidad de datos. Entre 
ellas, restar polinomios, derivar un polinomio y evaluar un polinomio en un intervalo x = (a, b]. la salida 
debería conservar el formato y guardarse en archivo de resultados (result.poly). 
     */
    

    public static void evaluate(String polyPath, int from, int to){
        LinkedList<Integer> poly = TxtPoly.readInts(polyPath);
        LinkedList<Integer> results = new LinkedList<>();
        int x = from + 1;
        
        

        while(x <= to){
            Iterator<Integer> iter = poly.iterator();
            int sum = 0;
            int pow = 0;
            while(iter.hasNext()){
                Integer nmr = iter.next();
                sum += Math.pow(x, pow)*nmr;
                pow++;
            }
            results.add(sum);
            x++;
            
        }
        TxtPoly.writeInts("result.poly", results);
    }

    public static void derivate(String polyPath){
        LinkedList<Integer> poly = TxtPoly.readInts(polyPath);
        LinkedList<Integer> toWrite = new LinkedList<>();
        Iterator<Integer> iter = poly.iterator();
        int pow = 1;

        iter.next();
        while(iter.hasNext()){
            toWrite.add(iter.next()*pow);
            pow++;

        }


        TxtPoly.writeInts("result.poly", toWrite);
        
    }

    public  static void sumTwoPolinomials(String polyPath1, String polyPath2){
        LinkedList<Integer> toWrite = new LinkedList<>();
        LinkedList<Integer> poly1 = TxtPoly.readInts(polyPath1);
        LinkedList<Integer> poly2 = TxtPoly.readInts(polyPath2);
        Iterator<Integer> iter1 = poly1.iterator();
        Iterator<Integer> iter2 = poly2.iterator();

        while(iter1.hasNext() && iter2.hasNext()){
            toWrite.add(iter1.next() + iter2.next());
        }
        while(iter1.hasNext()){
            toWrite.add(iter1.next());
        }
        while(iter2.hasNext()){
            toWrite.add(iter2.next());
        }
        TxtPoly.writeInts("result.poly", toWrite);
    }

}
