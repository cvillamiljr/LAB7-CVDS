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
        boolean valor=true;
        try{
            serviciosAlquiler.consultarCliente(3);
        }catch(ExcepcionServiciosAlquiler e){
            valor=false;
        }
        assertTrue(valor);
    }
    
    
}
