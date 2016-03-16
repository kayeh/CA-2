/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import static DataGenerator.DataGenerator.makeAddInfo;
import static DataGenerator.DataGenerator.makeCompany;
import static DataGenerator.DataGenerator.makeHobby;
import static DataGenerator.DataGenerator.makePerson;
import static DataGenerator.DataGenerator.makePhone;
import static DataGenerator.DataGenerator.makeStreet;
import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {

    static String[] fullname;
    static String[] phone;
    static String[] hobby;
    static String[] company;

    public static void main(String[] args) {
        createSchema();
        insert2Database(10);
        //printTestData(1);
    }

    public static void insert2Database(int dataAmount) {
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

            Phone ph = new Phone();
            phone = makePhone().split(",");
            ph.setNumber(phone[0]);
            ph.setDescription(phone[1]);

            Hobby h = new Hobby();
            hobby = makeHobby().split("-");
            h.setName(hobby[0]);
            h.setDescription(hobby[1]);

            Company com = new Company();
            company = makeCompany().split("¨");
            com.setName(company[0]);
            com.setDescription(company[1]);
            com.setCvr(company[2]);
            com.setNumEmployees(Integer.parseInt(company[3]));
            com.setMarketValue(Integer.parseInt(company[4]));

            CityInfo ci = new CityInfo();
            ci.setCity("Lyngby");
            ci.setZipCode("2100");
            try {
                em.getTransaction().begin();
                em.persist(p);
                p.setAddress(a);

                em.persist(a);
                em.persist(ci);
                em.persist(ph);
                em.persist(h);
                em.persist(com);

                ph.setInfoEntity(p);
                h.setPerson(p);
                com.setAddress(a);
                a.setCityInfo(ci);

                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static void printTestData(int n) {

        for (int i = 1; i < n + 1; i++) {
            System.out.println("Person: " + i);
            fullname = makePerson().split(",");
            System.out.println(fullname[0] + " " + fullname[1]);

            System.out.println(makeAddInfo());
            System.out.println(makeStreet());

            phone = makePhone().split(",");
            System.out.println(phone[0] + " " + phone[1]);

            hobby = makeHobby().split("-");
            System.out.println(hobby[0] + " " + hobby[1]);
            System.out.println("\n" + "\n");

            company = makeCompany().split("¨");
            System.out.println(company[0] + " " + company[1] + " " + company[2] + " " + company[3] + company[4]);

        }

    }

    public static void createSchema() {
        Persistence.generateSchema("CA2_Eske_JoniPU", null);
    }
}
