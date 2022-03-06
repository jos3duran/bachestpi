/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package occ.ues.edu.sv.bachestpi.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import occ.ues.edu.sv.bachestpi.control.exceptions.NonexistentEntityException;
import occ.ues.edu.sv.bachestpi.entity.TipoObjeto;

/**
 *
 * @author magdiel
 */
public class TipoObjetoBean {
    
 public boolean crear(TipoObjeto nuevo){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bachesUP");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(nuevo);
            tx.commit();
            return true;
            
        } catch (Exception e) {
            tx.rollback();
        }finally {
           if (em!=null){
            em.close();
        }
        }
        return false;
    }
 
    public boolean eliminar(Integer id) throws NonexistentEntityException{
        TipoObjeto eliminar;
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("bachesUP");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        eliminar=em.getReference(TipoObjeto.class,id);
        
        try {
            tx.begin();
            eliminar.getIdTipoObjeto();
            em.remove(eliminar);
            tx.commit();
            return true;
            
        } catch (Exception e) {
            tx.rollback();
        }finally {
           if (em!=null){
            em.close();
        }
        }
        return false;
    }
}
