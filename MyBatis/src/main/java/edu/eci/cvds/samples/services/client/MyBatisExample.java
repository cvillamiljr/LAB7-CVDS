/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        SqlSession sqlss = sessionfact.openSession();

        
        //Crear el mapper y usarlo: 
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
        cm.actualizarCliente(50, 0);
        
        //System.out.println(cm.consultarCliente(6));
        
        //Cliente david = new Cliente("David nadal",102431,"32323", "tu casa", "david@gmail.migente");
        //cm.insertarCliente(david);
        
        //ItemMapper cm2=sqlss.getMapper(ItemMapper.class);
        //Item items = new Item(new TipoItem(1,"holamu ndo1"),4567564,"holamundo2","holamundo2",new Date(), 1L,"no se","no soy cientifico");
        //cm2.insertarItem(items);
        
        ItemMapper cm3=sqlss.getMapper(ItemMapper.class);
        
        //cm3.actualizarTarifaItem(900, 200000);
        //System.out.println(cm3.consultarItems());
        
        TipoItemMapper cm4=sqlss.getMapper(TipoItemMapper.class);
        //TipoItem prueba = new TipoItem(12,"hola mundo");
        //System.out.println(cm4.consultarTipoItem(15));
        
        
        ItemRentadoMapper cm5=sqlss.getMapper(ItemRentadoMapper.class);
        //System.out.println(cm5.consultarItemRentado(1));
        
        
        
        sqlss.commit();
        
        sqlss.close();

        
        
    }


}
