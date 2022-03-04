package occ.ues.edu.sv.bachestpi.control;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import occ.ues.edu.sv.bachestpi.entity.Estado;

public class EstadoBean implements Serializable{

    public boolean crear(Estado nuevo){

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
        }
        return false;
    }

    public boolean eliminar(Estado eliminar){
        
        return false;
    }
}