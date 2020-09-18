
import com.jhony.retomutante.Persistencia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rm
 */
public class TestPersistencia {

    @Test
    void testConsulta() {
        Persistencia.getStats(null);
    }
    @Test
    void testRespuesta(){
        String res = Persistencia.armarRespuesta(6, 3);
        String compare = "{\"count_human_dna\":3,\"count_mutant_dna\":3,\"ratio\":\"0,50\"}";
        Assertions.assertEquals(res,compare);
    }
    
        @Test
    void testRespuestaCero(){
        String res = Persistencia.armarRespuesta(0, 3);
        String compare = null;
      
        Assertions.assertEquals(res,compare);
    }

}
