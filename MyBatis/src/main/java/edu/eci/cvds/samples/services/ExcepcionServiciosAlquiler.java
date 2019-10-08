/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services;

/**
 *
 * @author David Herrera
 */
public class ExcepcionServiciosAlquiler extends Exception {
    private static final long serialVersionUID = 1L;
    public ExcepcionServiciosAlquiler(String mensaje, Throwable e){
        super(mensaje, e);
    }
    
    public ExcepcionServiciosAlquiler(String mensaje){
        super(mensaje);
    } 
    
}
