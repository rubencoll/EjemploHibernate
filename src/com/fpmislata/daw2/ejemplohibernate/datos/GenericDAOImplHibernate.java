/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.ejemplohibernate.datos;

import com.fpmislata.daw2.ejemplohibernate.negocio.EntidadBancaria;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author alumno
 */
public class GenericDAOImplHibernate<T, ID extends Serializable> implements GenericDAO<T, ID> {

    SessionFactory sessionFactory;

    public GenericDAOImplHibernate() {

        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public T read(ID id) {

        Session session = sessionFactory.openSession(); //Abrimos la sesion

        T t = (T) session.get(getEntityClass(), id);

        session.close();    //Cerramos la session

        return t;
    }

    @Override
    public void insert(T t) {

        Session session = sessionFactory.openSession(); //Abrimos la sesion

        session.beginTransaction(); //Indicamos transferencia

        session.save(t);  //guardamos el objeto

        session.getTransaction().commit();  //Hacemos el commit

        session.close();    //Cerramos la session*/
    }

    @Override
    public void update(T t) {

        Session session = sessionFactory.openSession(); //Abrimos la sesion

        session.beginTransaction();

        session.update(t);

        session.getTransaction().commit();

        session.close();    //Cerramos la session
    }

    @Override
    public void delete(ID id) {

        Session session = sessionFactory.openSession(); //Abrimos la sesion

        T t = (T) session.get(getEntityClass(), id);
        // EntidadBancaria entidadBancariaBorrar = read(idEntidadBancaria);

        session.beginTransaction();

        session.delete(t);

        session.getTransaction().commit();

        session.close();    //Cerramos la session
    }

    @Override
    public List<T> findAll() {

        Session session = sessionFactory.openSession(); //Abrimos la sesion

        Query query = session.createQuery("SELECT t FROM "+getEntityClass().getName()+" t");

        List<T> tList = query.list();

        /*for (EntidadBancaria entidadBancaria : entidadesBancarias) {
         System.out.println(entidadBancaria.toString());
         }*/

        session.close();    //Cerramos la session

        return tList;
    }

    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
