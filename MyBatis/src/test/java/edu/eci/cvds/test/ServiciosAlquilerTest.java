package edu.eci.cvds.test;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }

    /*
    @Test
    public void emptyDB() {
        int documento;
        for(int i = 0; i < 100; i += 10) {
            documento=i;
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(documento);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
            System.out.println(r);
        };
    }
    */
    
    @Test
    public void deberiaEstarRegistrado(){
        boolean valorUno=true;
        boolean valorDos=true;
        boolean valorTres=true;
        try{
            serviciosAlquiler.consultarCliente(3);
        }catch(ExcepcionServiciosAlquiler e){
            valorUno=false;
        }
        
        try{
            serviciosAlquiler.consultarCliente(8588);
        }catch(ExcepcionServiciosAlquiler e){
            valorDos=false;
        }
        
         try{
            serviciosAlquiler.consultarCliente(1213123);
        }catch(ExcepcionServiciosAlquiler e){
            valorTres=false;
        }
        assertTrue(valorUno);
        assertTrue(valorDos);
        assertTrue(valorTres);
    }
    
    /*
    @Test
    public void noDeberiaEstarRegistrado(){
        boolean valorUno=true;
        boolean valorDos=true;
        boolean valorTres=true;
        Cliente clienteUno = null;
        Cliente clienteDos = null ;
        Cliente clienteTres = null;
        try{
            clienteUno = serviciosAlquiler.consultarCliente(0);
            clienteDos = serviciosAlquiler.consultarCliente(9000);
            clienteTres = serviciosAlquiler.consultarCliente(2000000);
            
            
        }catch(ExcepcionServiciosAlquiler e){         
           System.out.println("vamos a");
        }
        if(clienteUno.equals(null))
            valorUno=false;
        else if(clienteDos.equals(null))
            valorDos=false;
        else if(clienteTres.equals(null))
            valorTres=false;
   
            
        
        assertFalse(valorUno);
        //assertFalse(valorDos);
        //assertFalse(valorTres);
    }
        
    /*
    @Test
    public void deberiaEstarTipoItem(){
       boolean valorUno=true;
        boolean valorDos=true;
        boolean valorTres=true;
        try{
            serviciosAlquiler.consultarTipoItem(12);
        }catch(ExcepcionServiciosAlquiler e){
            valorUno=false;
        }
        
        try{
            serviciosAlquiler.consultarCliente(1);
        }catch(ExcepcionServiciosAlquiler e){
            valorDos=false;
        }
        
         try{
            serviciosAlquiler.consultarCliente(3);
        }catch(ExcepcionServiciosAlquiler e){
            valorTres=false;
        }
        assertFalse(valorUno);
        assertFalse(valorDos);
        assertFalse(valorTres);
    }
    
    @Test
    public void deberiaNoEstarTipoItem(){
       boolean valorUno=true;
        boolean valorDos=true;
        boolean valorTres=true;
        try{
            serviciosAlquiler.consultarTipoItem(10);
        }catch(ExcepcionServiciosAlquiler e){
            valorUno=false;
        }
        
        try{
            serviciosAlquiler.consultarCliente(120);
        }catch(ExcepcionServiciosAlquiler e){
            valorDos=false;
        }
        
         try{
            serviciosAlquiler.consultarCliente(5);
        }catch(ExcepcionServiciosAlquiler e){
            valorTres=false;
        }
        assertFalse(valorUno);
        assertFalse(valorDos);
        assertFalse(valorTres);
    }
    */
}

