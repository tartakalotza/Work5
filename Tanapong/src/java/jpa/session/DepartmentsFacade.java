/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Departments;

/**
 *
 * @author Dafunk
 */
@Stateless
public class DepartmentsFacade extends AbstractFacade<Departments> {

    @PersistenceContext(unitName = "TanapongPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentsFacade() {
        super(Departments.class);
    }
    
}
