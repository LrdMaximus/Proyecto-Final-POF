/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pof.entidades.clases;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pof.entidades.Propietario;

/**
 *
 * @author cetecom
 */
@Stateless
public class PropietarioFacade extends AbstractFacade<Propietario> {

    @PersistenceContext(unitName = "proyectpof4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropietarioFacade() {
        super(Propietario.class);
    }
    
}
