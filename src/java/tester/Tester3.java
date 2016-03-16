/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Hobby;
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eske Wolff
 */
public class Tester3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2_Eske_JoniPU");
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, 1L);
        Hobby h = p.getHobbies().get(0);
        System.out.println("hobby: "+h.getName());
    }
}
