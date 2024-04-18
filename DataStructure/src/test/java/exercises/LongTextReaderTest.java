package exercises;
import org.junit.jupiter.api.Test;

import com.edu.upb.exercises.treeExercises.longTextReader.LongTextReader;


public class LongTextReaderTest {
    
    @Test
    void LongTextReaderTest1(){
        
        String txt = "El sol brillaba intensamente sobre el mar El mar reflejaba el brillo del sol de una manera hipnótica Las olas chocaban contra las rocas con un sonido constante y relajante Cada vez que una ola golpeaba las rocas las rocas parecían absorber el impacto El impacto resonaba en el aire creando una melodía natural La naturalidad del entorno era asombrosa Asombrosa como pocas cosas en la vida";
        LongTextReader txtReader = new LongTextReader(txt);
        System.out.println(txtReader.toString());
        System.out.println(txtReader.searchWordFrenquency("mar"));

    }
}
