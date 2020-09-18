/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhony.retomutante;


import com.jhony.retomutante.tipos.Coordenada;
import java.util.regex.Pattern;

/**
 *
 * @author rm
 */
public class Utils {
    
    private static final String REGEX_CHARS_DNA="[ATCG]+";
    
    private static final int HACIA_DERECHA = 0;
    private static final int HACIA_DERECHA_ABAJO = 1;
    private static final int HACIA_ABAJO = 2;
    private static final int HACIA_IZQUIERDA_ABAJO = 3;
    
    /**
     * Metodo que valida el patron de posibles caracteres validos de entrada
     * @param input String con los valores de entrada de un registro
     * @return -1 si no coincide con el patrón, en caso contrtario devuelve la longitud del String
     */
    
    private static int getValidLenMutant(String input) {
        int lenRes = -1;
        
        
        if (Pattern.matches(REGEX_CHARS_DNA, input)) {
            lenRes = input.length();
        }
        
        return lenRes;
    }
    /**
     * metodo que valida las dimensiones NxN de la entrada con base en un patron de caracteres predefinidos en REGEX_CHARS_DNA
     * @param data array
     * @return true en caso que se cumpla el NxN
     */
    public static boolean validateNxN(String[] data) {
        boolean res = true;
        if (data != null) {
            for (String c : data) {
                int length = getValidLenMutant(c);
                if (length != data.length) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
    
    
    /**
     * 
     * @param actual
     * @param max
     * @return 
     */
    public static Coordenada obtenerSiguientePosicion(Coordenada actual, int max) {
        Coordenada siguiente = null;

        int fila = actual.getFila();

        int columna = actual.getColumna();

        if (columna + 1 < max) {
            siguiente = new Coordenada(fila, columna + 1);
        } else {
            if (fila + 1 < max) {
                siguiente = new Coordenada(fila + 1, 0);
            }
        }
        return siguiente;

    }

    /**
 * metodo que determina el sentido del recorrido entre 2 coordenadas consecutivas
 * @param previa
 * @param siguiente
 * @return HACIA_DERECHA,HACIA_DERECHA_ABAJO,HACIA_ABAJO, HACIA_IZQUIERDA_ABAJO o -1 si son valores no validos
 */
    public static int obtenerSentido(Coordenada previa, Coordenada siguiente) {
        int sentido = -1;
        
        if (previa.getFila() == siguiente.getFila()
                && (previa.getColumna()+1) == (siguiente.getColumna())) {
            sentido = HACIA_DERECHA;
        } 
        if ((previa.getFila()+1) == (siguiente.getFila())
                && (previa.getColumna()+1) == (siguiente.getColumna())) {
            sentido = HACIA_DERECHA_ABAJO;
        } 
        if ((previa.getFila()+1) == (siguiente.getFila())
                && previa.getColumna() == siguiente.getColumna()) {
            sentido = HACIA_ABAJO;
        } 
        if ((previa.getFila()+1) == (siguiente.getFila())
                && (previa.getColumna()-1) == (siguiente.getColumna())) {
            sentido = HACIA_IZQUIERDA_ABAJO;
        }
        
        
        return sentido;
    }
    
     /**
     * Metodo que compara el sentido de 2 vectores conformados por 3 coordenadas determinadas, 
     * en caso que coincidan las trayectorias o que no haya una concidencia previa se retornara true
     * @param futura punto final del segundo vector 
     * @param actual punto inicial del segundo vector y final del primer vector
     * @param previa punto inicial del primer vector
     * @param contador valor numerico que determina si existe una coincidencia previa, si es cero no hay coincidencia previa
     * @return: 
     *      true-> para las coincidencias de trayectorias o coincidencias previas en cero
     *      false-> para las trayectorias que no coinciden con coincidencia previa diferente de cero o para trayectorias invalidas
     * 
     *         
     */
    public static boolean validarDireccionPrevia(Coordenada futura, Coordenada actual, Coordenada previa, int contador) {
        boolean res = true;
        if (contador > 0) {
            int sentidoFuturo = Utils.obtenerSentido(actual, futura);
            int sentidoPrevio = Utils.obtenerSentido(previa, actual);
            if (sentidoFuturo != sentidoPrevio) {
                res = false;
            }
            if(sentidoPrevio==-1){
                res = false;
            }
        }
        return res;
    }
    
}
