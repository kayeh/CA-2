/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eske Wolff
 */
public class DataFacade implements IDataFacade {

    EntityManagerFactory emf;

    public DataFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Person getPerson(long id) {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, id);
            return p;
        } finally {
            em.close();
        }

    }

    // select p, a, c from Person p join fetch p.address a join fetch a.cityInfo c
    
    @Override
    public List<Person> getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Person p").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersonsByZip(int zipCode) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("select p from Person p, Address a, CityInfo i where i.zipCode = '2100'").getResultList();
        } finally {
            em.close();
        }

    }
}
