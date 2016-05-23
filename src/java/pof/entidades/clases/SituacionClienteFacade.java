/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades.clases;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pof.entidades.SituacionCliente;

/**
 *
 * @author cetecom
 */
@Stateless
public class SituacionClienteFacade extends AbstractFacade<SituacionCliente> {

    @PersistenceContext(unitName = "proyectpof4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SituacionClienteFacade() {
        super(SituacionCliente.class);
    }
    
}
