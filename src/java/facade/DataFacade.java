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

/**
 *
 * @author Eske Wolff
 */
public class DataFacade implements IDataFacade{

    EntityManagerFactory emf;

    public DataFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, id);
            return p;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("select p from Person p").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons(int zipCode) {
              EntityManager em = getEntityManager();
        try {
            return em.createQuery("select p from Person p, Address a, CityInfo i where i.zipCode = '2100'").getResultList();
        } finally {
            em.close();
        }
    
    }

    //    public Person getPerson(int id) {
//        EntityManager em = getEntityManager();
//        
////        e.setOfficeCode(em.find(Office.class, "1"));
////        try {
////            em.getTransaction().begin();
////            em.persist(p);
////            em.getTransaction().commit();
////        } finally {
////            em.close();
////        }
//        return e;
//    }
//    public Customer updateCustomer(Customer cust, int index, String name) {
//        EntityManager em = getEntityManager();
//        cust = em.find(Customer.class, index);
//        try {
//            cust.setCustomerName(name);
//            em.getTransaction().begin();
//            em.merge(cust);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//        return cust;
//    }
}
