
import com.jhony.retomutante.Utils;
import com.jhony.retomutante.tipos.Coordenada;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhony
 */
public class TestUtils {
    
    @Test 
        void testSiguientePos(){
            Coordenada c = new Coordenada(2, 2);
            assertEquals(Utils.obtenerSiguientePosicion(c,1), null);
            
        }
    
}
