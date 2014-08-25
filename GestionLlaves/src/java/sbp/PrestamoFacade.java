/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbp;

import entity.Prestamo;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Jonny-PC
 */
@Stateless
public class PrestamoFacade extends AbstractFacade<Prestamo> {
    @PersistenceContext(unitName = "GestionLlavesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamoFacade() {
        super(Prestamo.class);
    }
    
    public List<Prestamo> turnos_por_fecha(Date fecha1){
        EntityManager em2 = getEntityManager();
        Query q = em.createNamedQuery("Prestamo.findByFecha").setParameter("fecha", fecha1, TemporalType.DATE);
        return q.getResultList();
    }
    
}
