
import com.jhony.retomutante.Handler;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
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
public class TestHandler {
    
    @Test
    void testApiNull() {
        Handler h = new Handler();
        try {
            h.handleRequest(null, null, null);
        } catch (IOException ex) {
            Assertions.fail("fallo el metodo");

        }
    }
    
        @Test
    void testApiInput() {
        Handler h = new Handler();
        try {
            InputStream in = new InputStream() {
                @Override
                public int read() throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            h.handleRequest(in, null, null);
        } catch (IOException ex) {
            Assertions.fail("fallo el metodo");

        }
    }
    
    @Test
    void testApiInputLine() {
        Handler h = new Handler();
        
        try {
            
            InputStream stream = new ByteArrayInputStream("hola mundo".getBytes(StandardCharsets.UTF_8));
            
            h.handleRequest(stream, null, null);
        } catch (IOException ex) {
            Assertions.fail("fallo el metodo");

        }
    }
    
     @Test
    void testApiInputLinejSon() {
        Handler h = new Handler();
        
        try {
            
            InputStream stream = new ByteArrayInputStream("{\"dna\": [\"mundo\",\" \"]}".getBytes(StandardCharsets.UTF_8));
            
            h.handleRequest(stream, null, null);
        } catch (IOException ex) {
            Assertions.fail("fallo el metodo");

        }
    }
    
     @Test
    void testApiInputLinejSonNoDna() {
        Handler h = new Handler();
        
        try {
            
            InputStream stream = new ByteArrayInputStream("{\"otro\": [\"mundo\",\" \"]}".getBytes(StandardCharsets.UTF_8));
            
            h.handleRequest(stream, null, null);
        } catch (IOException ex) {
            Assertions.fail("fallo el metodo");

        }
    }

    @Test
    void testApiOutput() {
        Handler h = new Handler();

        try {
            File f = new File("savedMessage.txt");
            String filename = "savedMessage.txt";
            OutputStream os = new FileOutputStream(filename, true);
          
            h.handleRequest(null, os, null);
        } catch (IOException ex) {
            Assertions.fail("fallo el metodo");

        }
    }
    
     @Test
    void testApiMutantTrue() {
        Handler h = new Handler();
        
        try {
            
            InputStream stream = new ByteArrayInputStream("{\"dna\": [\"ATATTA\",\"CTATGC\",\"ATGTGT\",\"ATAAGG\",\"CCCCTA\",\"TCACTG\"]}".getBytes(StandardCharsets.UTF_8));
            
            h.handleRequest(stream, null, null);
        } catch (IOException ex) {
            Assertions.fail("fallo el metodo");

        }
    }
    
}
