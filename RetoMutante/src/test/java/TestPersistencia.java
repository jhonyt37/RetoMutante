
import com.jhony.retomutante.Persistencia;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.fail;
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
    void testSave(){
        String [] data={"",""};
        Persistencia.save("humano", data,"");
    }
    
    @Test
    void testCalculaLlave(){
        String[] data ={"123","456"};
        String compare ="123456";
        int hash= Persistencia.calcularLlave(data);
        Assertions.assertEquals(hash,compare.hashCode());
    }
    
}
