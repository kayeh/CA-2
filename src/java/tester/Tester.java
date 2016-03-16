/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import static DataGenerator.DataGenerator.makeAddInfo;
import static DataGenerator.DataGenerator.makePerson;
import static DataGenerator.DataGenerator.makeStreet;
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

    static String[] fullname;
    //static String[] street = makeStreet().split(",");

    public static void main(String[] args) {

        // Persistence.generateSchema("CA2_Eske_JoniPU", null);
        //test data
        System.out.println(fullname[0] + " " + fullname[1]);
        System.out.println(makeStreet());
        System.out.println(makeAddInfo());

    }

    public static void Insert2Database(int dataAmount) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2_Eske_JoniPU");
        EntityManager em = emf.createEntityManager();
        for (int i = 0;
                i < dataAmount;
                i++) {

            Person p = new Person();
            fullname = makePerson().split(",");
            p.setFirstName(fullname[0]);
            p.setLastName(fullname[1]);

            Address a = new Address();
            a.setStreet(makeStreet());
            a.setAdditionalInfo(makeAddInfo());

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
}
