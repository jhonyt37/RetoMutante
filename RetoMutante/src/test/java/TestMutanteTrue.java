/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jhony.retomutante.Mutante;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author rm
 */
public class TestMutanteTrue {
    @Test
    void horizontalTest() {
        
        String[] dataInput = {"ATTTTA","CAATGC","AAGTGT","AGAAGG","CCCCTA","TCACTG"};

        Mutante mutant = new Mutante();
        mutant.setDataArray(dataInput);

        assertEquals(mutant.isMutant(), true);

    }
    
        @Test
    void verticalTest() {
        
        String[] dataInput = {"ATATTA","CTATGC","ATGTGT","ATAAGG","CCCCTA","TCACTG"};

        Mutante mutant = new Mutante();
        mutant.setDataArray(dataInput);

        assertEquals(mutant.isMutant(), true);

    }
    
            @Test
    void oblicuoTest() {
        
        String[] dataInput = {"ATGTTA","CGAGGC","ATGTGT","ATAAGG","CCCCTA","TCACTG"};

        Mutante mutant = new Mutante();
        mutant.setDataArray(dataInput);

        assertEquals(mutant.isMutant(), true);

    }
    
                @Test
    void oblicuoInversoTest() {
        
        
        String[] dataInput = {"ATGTTA","CGTGGC","ATGTGT","TTAAGG","CCCCTA","TCACTG"};

        Mutante mutant = new Mutante();
        mutant.setDataArray(dataInput);

        assertEquals(mutant.isMutant(), true);

    }
    

    
    
}
