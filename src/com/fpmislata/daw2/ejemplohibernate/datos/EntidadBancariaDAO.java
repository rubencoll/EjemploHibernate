/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.ejemplohibernate.datos;

import com.fpmislata.daw2.ejemplohibernate.negocio.EntidadBancaria;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaDAO extends GenericDAO<EntidadBancaria, Integer>{


    public List<EntidadBancaria> findByCodigo(String codigo);
    public List<EntidadBancaria> findByNombre(String nombre);
    
}
