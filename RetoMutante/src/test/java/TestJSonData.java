
import com.jhony.retomutante.tipos.JsonEntrada;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class TestJSonData {
    
         @Test
    void testValidate() {
        String[] data = {"ATGCGA","ATGCGA"};
             JsonEntrada j = new JsonEntrada();
             j.setDna(data);
             String[] compare = j.getDna();
        
             
        assertEquals(compare, data);

    }
    
}

