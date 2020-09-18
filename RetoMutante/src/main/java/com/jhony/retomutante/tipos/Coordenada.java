/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhony.retomutante.tipos;

/**
 *
 * @author rm
 */
public class Coordenada {
    private int fila;
    private int columna;

    public Coordenada(int fil, int col){
        fila =fil;
        columna=col;
    }
    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Coordenada)) {
            return false;
        }

        Coordenada otherKey = (Coordenada) object;
        if (otherKey.getFila() != this.getFila()
                || otherKey.getColumna() != this.getColumna()) {
            return false;
        }

        return true;
    }
    
     @Override
    public int hashCode() {
        
        int result = 17; // any prime number
        result = 31 * result + this.fila;
        result = 31 * result + this.columna;
        
        return result;
    }
    
}
