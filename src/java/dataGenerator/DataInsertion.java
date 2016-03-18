package dataGenerator;

import static dataGenerator.DataGenerator.makeAddInfo;
import static dataGenerator.DataGenerator.makeCompany;
import static dataGenerator.DataGenerator.makeHobby;
import static dataGenerator.DataGenerator.makePerson;
import static dataGenerator.DataGenerator.makePhone;
import static dataGenerator.DataGenerator.makeStreet;
import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataInsertion {

    static String[] fullname;
    static String[] phone;
    static String[] hobby;
    static String[] company;
    static Random random = new Random();
    static int randomNumber = random.nextInt(6) + 1;

    public static void insert2Database(int dataAmount) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2_Eske_JoniPU");
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_OPENSHIFT");

        EntityManager em = emf.createEntityManager();
        for (int i = 0; i < dataAmount; i++) {

            Person p = new Person();
            fullname = makePerson().split(",");
            p.setFirstName(fullname[0]);
            p.setLastName(fullname[1]);

            InfoEntity ie = new InfoEntity();
            p.setEmail(fullname[2]);

            Address a = new Address();
            a.setStreet(makeStreet());
            a.setAdditionalInfo(makeAddInfo());

            Phone ph = new Phone();
            phone = makePhone().split(",");
            ph.setNumber(phone[0]);
            ph.setDescription(phone[1]);

//            for (int j = 0; j < randomNumber; j++) {
//
//                if (randomNumber > 2) {
//
//                    hobby = makeHobby().split("-");
//                    h.setName(hobby[0]);
//                    h.setDescription(hobby[1]);
//                    p.addHobby(h);
//                }
//                if (randomNumber == 1) {
//                    hobby = makeHobby().split("-");
//                    h.setName(hobby[0]);
//                    h.setDescription(hobby[1]);
//                    p.addHobby(h);
//                    j++;
//                } else {
//                    h.setName("No hobbies");
//                    h.setDescription("borring life - sad & depressing");
//                    p.addHobby(h);
//                }
//            }
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

            Hobby h = new Hobby();
            hobby = makeHobby().split("-");
            h.setName(hobby[0]);
            h.setDescription(hobby[1]);

            p.setAddress(a);
            a.setCityInfo(ci);
            p.addHobby(h);
            p.addPhone(ph);
            ph.setInfoEntity(p);
            try {
                em.getTransaction().begin();
                em.persist(p);
                //  em.persist(com);

                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static void createSchema() {
        Persistence.generateSchema("CA2_Eske_JoniPU", null);
        // Persistence.generateSchema("pu_OPENSHIFT," null);
    }
}
