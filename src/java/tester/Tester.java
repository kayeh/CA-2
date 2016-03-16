/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import static DataGenerator.DataGenerator.makeAddInfo;
import static DataGenerator.DataGenerator.makePerson;
import static DataGenerator.DataGenerator.makePhone;
import static DataGenerator.DataGenerator.makeStreet;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import facade.DataFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Eske Wolff
 */
public class Tester {

    static String[] fullname;
    static String[] phone;
    //static String[] street = makeStreet().split(",");

    public static void main(String[] args) {

        // Persistence.generateSchema("CA2_Eske_JoniPU", null);
        
        //fullname = makePerson().split(",");
        //System.out.println(fullname[0] + " " + fullname[1]);
        //System.out.println(makeStreet());
        // System.out.println(makeAddInfo());
        Insert2Database(20);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2_Eske_JoniPU");
//        EntityManager em = emf.createEntityManager();
//        DataFacade facade = new DataFacade(emf);
//       // System.out.println(df.getAllPersons());
//        List<Person> persons = facade.getAllPersons();
//        JsonArray json = new JsonArray();
//       
//        System.out.println("START");
//        for (Person person : persons) {
//            JsonObject obj = new JsonObject();
//             JsonArray hobbies = new JsonArray();
//             for (int i = 0; i < person.getHobbies().size(); i++) {
//                Hobby h = person.getHobbies().get(i); 
//                hobbies.add(h.getName());
//              //   System.out.println(hobbies);
//            }
//            System.out.println("END");
//            obj.addProperty("firstName", person.getFirstName());
//            obj.addProperty("lastName", person.getLastName());
//            obj.addProperty("street", person.getAddress().toString());
//            obj.add("hobbies", hobbies);
//            json.add(obj);
//        }
//        System.out.println(json);
//
//    
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

            Phone ph = new Phone();
           phone = makePhone().split(",");
            ph.setNumber(phone[0]);
            ph.setDescription(phone[1]);
            
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
                ph.setInfoEntity(p);
                a.setCityInfo(ci);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }
}
