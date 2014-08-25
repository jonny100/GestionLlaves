/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbp;

import entity.Motivo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jonny-PC
 */
@Stateless
public class MotivoFacade extends AbstractFacade<Motivo> {
    @PersistenceContext(unitName = "GestionLlavesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotivoFacade() {
        super(Motivo.class);
    }
    
}
