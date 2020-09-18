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
public class TestMutanteFalse {
    
                        @Test
    void otroTest() {
        
        String[] dataInput = {"ATGTTA","CGAGGC","ATGTGT","TTAAGT","CCTCTA","TCACTG"};

        Mutante mutant = new Mutante();
        mutant.setDataArray(dataInput);

        assertEquals(mutant.isMutant(), false);

    }
    
    @Test
    void otrodosTest() {

        String[] dataInput = {"ATTTAG","CGGACC","GTCAGT","AGTCAC","TAATCG","AATTGG"};

        Mutante mutant = new Mutante();
        mutant.setDataArray(dataInput);

        assertEquals(mutant.isMutant(), false);

    }
    
}
