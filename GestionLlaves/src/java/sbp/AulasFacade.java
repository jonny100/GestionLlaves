/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sbp;

import entity.Aulas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jonny-PC
 */
@Stateless
public class AulasFacade extends AbstractFacade<Aulas> {
    @PersistenceContext(unitName = "GestionLlavesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AulasFacade() {
        super(Aulas.class);
    }
    
}
