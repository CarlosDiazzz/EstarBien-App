/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.exceptions.NonexistentEntityException;
import control.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.InventarioBajo;

/**
 *
 * @author carlo
 */
public class InventarioBajoJpaController implements Serializable {

    public InventarioBajoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InventarioBajo inventarioBajo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(inventarioBajo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInventarioBajo(inventarioBajo.getIdMedicamento()) != null) {
                throw new PreexistingEntityException("InventarioBajo " + inventarioBajo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InventarioBajo inventarioBajo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            inventarioBajo = em.merge(inventarioBajo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = inventarioBajo.getIdMedicamento();
                if (findInventarioBajo(id) == null) {
                    throw new NonexistentEntityException("The inventarioBajo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InventarioBajo inventarioBajo;
            try {
                inventarioBajo = em.getReference(InventarioBajo.class, id);
                inventarioBajo.getIdMedicamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inventarioBajo with id " + id + " no longer exists.", enfe);
            }
            em.remove(inventarioBajo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InventarioBajo> findInventarioBajoEntities() {
        return findInventarioBajoEntities(true, -1, -1);
    }

    public List<InventarioBajo> findInventarioBajoEntities(int maxResults, int firstResult) {
        return findInventarioBajoEntities(false, maxResults, firstResult);
    }

    private List<InventarioBajo> findInventarioBajoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InventarioBajo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public InventarioBajo findInventarioBajo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InventarioBajo.class, id);
        } finally {
            em.close();
        }
    }

    public int getInventarioBajoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InventarioBajo> rt = cq.from(InventarioBajo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
