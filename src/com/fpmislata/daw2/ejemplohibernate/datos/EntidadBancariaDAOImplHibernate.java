/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.ejemplohibernate.datos;

import com.fpmislata.daw2.ejemplohibernate.negocio.EntidadBancaria;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplHibernate extends GenericDAOImplHibernate<EntidadBancaria, Integer> implements EntidadBancariaDAO {

    @Override
    public List<EntidadBancaria> findByCodigo(String codigo) {

        Session session = sessionFactory.openSession(); //Abrimos la sesion

        Query query = session.createQuery("SELECT entidadBancaria FROM EntidadBancaria entidadBancaria WHERE codigoentidadbancaria='" + codigo + "'");

        List<EntidadBancaria> entidadesBancarias = query.list();

        session.close();    //Cerramos la session

        return entidadesBancarias;
    }

    
    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        
        Session session = sessionFactory.openSession(); //Abrimos la sesion

        Query query = session.createQuery("SELECT entidadBancaria FROM EntidadBancaria entidadBancaria WHERE nombre='" + nombre + "'");

        List<EntidadBancaria> entidadesBancarias = query.list();

        session.close();    //Cerramos la session

        return entidadesBancarias;
    }
    
    //
//    @Override
//    public EntidadBancaria read(Integer idEntidadBancaria) {
//
//        Session session = sessionFactory.openSession(); //Abrimos la sesion
//
//        EntidadBancaria entidadBancariaLeer = (EntidadBancaria) session.get(EntidadBancaria.class, idEntidadBancaria);
//
//        session.close();    //Cerramos la session
//
//        return entidadBancariaLeer;
//    }
//
//
//    @Override
//    public void insert(EntidadBancaria t) {
//
//        Session session = sessionFactory.openSession(); //Abrimos la sesion
//
//        session.beginTransaction(); //Indicamos transferencia
//
//        session.save(t);  //guardamos el objeto
//
//        session.getTransaction().commit();  //Hacemos el commit
//
//        session.close();    //Cerramos la session*/
//    }
//
//    @Override
//    public void update(EntidadBancaria t) {
//
//        Session session = sessionFactory.openSession(); //Abrimos la sesion
//
//        session.beginTransaction();
//
//        session.update(t);
//
//        session.getTransaction().commit();
//
//        session.close();    //Cerramos la session
//    }
//
//    @Override
//    public void delete(Integer idEntidadBancaria) {
//
//        Session session = sessionFactory.openSession(); //Abrimos la sesion
//
//        EntidadBancaria entidadBancariaBorrar = (EntidadBancaria) session.get(EntidadBancaria.class, idEntidadBancaria);
//         EntidadBancaria entidadBancariaBorrar = read(idEntidadBancaria);
//
//        session.beginTransaction();
//
//        session.delete(entidadBancariaBorrar);
//
//        session.getTransaction().commit();
//
//        session.close();    //Cerramos la session
//    }
//
//    @Override
//    public List<EntidadBancaria> findAll() {
//
//        Session session = sessionFactory.openSession(); //Abrimos la sesion
//
//        Query query = session.createQuery("SELECT entidadBancaria FROM EntidadBancaria entidadBancaria");
//
//        List<EntidadBancaria> entidadesBancarias = query.list();
//
//        /*for (EntidadBancaria entidadBancaria : entidadesBancarias) {
//         System.out.println(entidadBancaria.toString());
//         }*/
//
//        session.close();    //Cerramos la session
//
//        return entidadesBancarias;
//    }

}
