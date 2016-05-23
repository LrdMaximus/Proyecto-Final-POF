/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades.clases;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pof.entidades.Inspecciones;

/**
 *
 * @author cetecom
 */
@Stateless
public class InspeccionesFacade extends AbstractFacade<Inspecciones> {

    @PersistenceContext(unitName = "proyectpof4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InspeccionesFacade() {
        super(Inspecciones.class);
    }
    
}
