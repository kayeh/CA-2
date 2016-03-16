/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Address;
import entity.CityInfo;
import entity.InfoEntity;
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eske Wolff
 */
public class Tester {

    public static void main(String[] args) {

        // Persistence.generateSchema("CA2_Eske_JoniPU", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2_Eske_JoniPU");
        EntityManager em = emf.createEntityManager();

        Person p = new Person();
        p.setFirstName("Kim");
        p.setLastName("Hansen");

        Address a = new Address();
        a.setStreet("Lyngbyvej 30");
        a.setAdditionalInfo("tv");
        
        CityInfo ci = new CityInfo();
        ci.setCity("Lyngby");
        ci.setZipCode("2100");
        try {
            em.getTransaction().begin();
            em.persist(p);
            p.setAddress(a);
            em.persist(a);
            em.persist(ci);
            a.setCityInfo(ci);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
