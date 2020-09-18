/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhony.retomutante;


import com.jhony.retomutante.tipos.Coordenada;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author rm
 */
public class Mutante {

    /**
     * @return the lenMatrix
     */
    public int getLenMatrix() {
        return lenMatrix;
    }

    /**
     * @param lenMatrix the lenMatrix to set
     */
    public void setLenMatrix(int lenMatrix) {
        this.lenMatrix = lenMatrix;
    }

    /**
     * @return the dataArray
     */
    public String[] getDataArray() {
        return dataArray;
    }

    /**
     * @param dataArray the dataArray to set
     */
    public void setDataArray(String[] dataArray) {
        this.dataArray = dataArray;
    }

    /**
     * setea la matriz con estrucutura fila,Columna -> contenido
     */
    private void setDatosMatriz() {
        int fila = 0;
        int columna = 0;

        setMatrixData(new ConcurrentHashMap<>());
        for (String registro : getDataArray()) {
            for (byte tipo : registro.getBytes()) {
                Coordenada llave = new Coordenada(fila, columna);
                getMatrixData().put(llave, tipo);
                columna++;
            }
            fila++;
            columna = 0;
        }

    }
    /**
     * Metodo que retorna una lista de coordenadas posibles con base en una posicion de fila y columna inicial y una trayectoria previa
     * @param filaActual
     * @param colActual
     * @param filaPrevia
     * @param colPRevio
     * @return
     */
    private List<Coordenada> encuentraLimitesValidos(Coordenada actual) {
        int filaActual = actual.getFila();
        int colActual = actual.getColumna();
        List<Coordenada> lista = new ArrayList<>();

        
        //limite derecho
        if (colActual + 1 < getLenMatrix()) {
            lista.add(new Coordenada(filaActual, colActual + 1));

        }

        //limite inferior derecho
        if ((filaActual + 1) < getLenMatrix() && (colActual + 1) < getLenMatrix()) {
            lista.add(new Coordenada(filaActual + 1, colActual + 1));
        }

        //limite inferior
        if (filaActual + 1 < getLenMatrix()) {
            lista.add(new Coordenada(filaActual + 1, colActual));
        }

        //limite inferior izquierdo
        if ((filaActual + 1) < getLenMatrix() && (colActual - 1) >= 0) {
            lista.add(new Coordenada(filaActual + 1, colActual - 1));
        }

        
        return lista;

    }

    

    

    private int findEquals(Coordenada actual, Coordenada previa, Coordenada raiz, int contador) {
        int res = 0;
        if (raiz.getFila() == getLenMatrix() - 1 && raiz.getColumna() == getLenMatrix() - 1) {
            return 2;
        }

        byte content = getMatrixData().get(actual);

        List<Coordenada> lista = encuentraLimitesValidos(actual);

        for (Coordenada posicion : lista) {

            byte compare = getMatrixData().get(posicion);

            if (compare == content
                    && Utils.validarDireccionPrevia(posicion, actual, previa, contador)) {

                contador++;

                if (contador <= 2) {
                    res = findEquals(posicion, actual, raiz, contador);
                } else {
                    res = 1;
                    break;
                }

            }

        }

        if (res == 0) {
            Coordenada pos = Utils.obtenerSiguientePosicion(raiz,getLenMatrix());
            if (pos != null) {
                res = findEquals(pos, previa, pos, 0);
            }
        }

        return res;
    }

    private boolean isMatrixMutant() {
        boolean res = false;
        int rowIni = 0;
        int colIni = 0;
        
        if (1 == findEquals(new Coordenada(colIni, colIni),
                new Coordenada(rowIni, colIni),
                new Coordenada(rowIni, colIni), 0)) {
            res = true;
        }
        return res;
    }
    /**
     * Metodo que permite identificar si una entrada de array String coincide con el patron de ADN de un mutante
     * Se requiere una inicializacion del atributo dataArray
     * @return true si el ADN corresponde a un mutante
     */
    public boolean isMutant(){
        boolean res=false;
        
        if(Utils.validateNxN(dataArray)){
            setLenMatrix(dataArray.length);
            setDatosMatriz();
            res = isMatrixMutant();
            
            
        }
        
        return res;
    }
    
    
    private String[] dataArray; 
    private int lenMatrix;
    private Map<Coordenada, Byte> matrixData;

    /**
     * @return the matrixData
     */
    public Map<Coordenada, Byte> getMatrixData() {
        return matrixData;
    }

    /**
     * @param matrixData the matrixData to set
     */
    public void setMatrixData(Map<Coordenada, Byte> matrixData) {
        this.matrixData = matrixData;
    }
    
}
