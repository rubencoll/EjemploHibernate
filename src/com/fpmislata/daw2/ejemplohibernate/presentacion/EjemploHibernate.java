/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.ejemplohibernate.presentacion;


import com.fpmislata.daw2.ejemplohibernate.negocio.EntidadBancaria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author alumno
 */
public class EjemploHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        SessionFactory sessionFactory;

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        
        //Prueva para guardar en la base de datos

        EntidadBancaria entidadBancaria = new EntidadBancaria(10,"101","Caja Rural","121212");
        
        Session session = sessionFactory.openSession(); //Abrimos la sesion

        session.beginTransaction(); //Indicamos transferencia
        
        session.save(entidadBancaria);  //guardamos el objeto
        
        session.getTransaction().commit();  //Hacemos el commit
        
        //session.getTransaction().rollback();
        
        session.close();    //Cerramos la session

    }

    public void close(SessionFactory sessionFactory) {
        sessionFactory.close();
    }
}
