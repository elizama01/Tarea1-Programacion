package javaapplication1;


import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Esteban
 */
class SesionesPelicula {
Pelicula pelicula;
Vector sesionesStrpelicula;
    public SesionesPelicula(Pelicula pelicula, Vector sesionesStrPelicula) {
    this.pelicula=pelicula;
    this.sesionesStrpelicula=sesionesStrPelicula;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Vector getSesionesStrpelicula() {
        return sesionesStrpelicula;
    }

    public void setSesionesStrpelicula(Vector sesionesStrpelicula) {
        this.sesionesStrpelicula = sesionesStrpelicula;
    }
    
}
