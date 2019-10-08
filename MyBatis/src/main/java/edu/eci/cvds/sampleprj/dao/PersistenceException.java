/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

/**
 *
 * @author David Herrera
 */
public class PersistenceException extends Exception{

    private static final long serialVersionUID = 1L;
    
    public PersistenceException(String mensaje, Throwable e){
        super(mensaje,e);
    } 
}
