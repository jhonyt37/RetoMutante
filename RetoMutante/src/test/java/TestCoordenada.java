

import com.jhony.retomutante.tipos.Coordenada;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class TestCoordenada {
    
         @Test
    void testValidate() {
        
             Coordenada punto= new Coordenada(1, 1);

        

        assertEquals(punto.getFila(), 1);
        
        assertEquals(punto.getColumna(), 1);

    }
    
    @Test
    public void testConstructor() {
        try {
            new Coordenada(0, 0);
            new Coordenada(1, 1);
            new Coordenada(2, 2);
        } catch (Exception e) {
            fail(e.getMessage());
        }
}
    
        @Test
    void testEquals() {

        Coordenada punto = new Coordenada(1, 1);
        Object data = null;

        assertEquals(punto.equals(data), false);


    }
    
        
        @Test
    void testEqualsOk() {

        Coordenada punto = new Coordenada(1, 1);
        Coordenada otro = new Coordenada(1, 2);

        assertEquals(punto.equals(otro), false);


    }
    
    
        @Test
    void testSetters() {

        Coordenada punto = new Coordenada(1, 1);
        punto.setFila(2);
        punto.setColumna(2);
        Coordenada otro = new Coordenada(2, 2);

        assertEquals(punto.equals(otro), true);


    }
    
    
}

