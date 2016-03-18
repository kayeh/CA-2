package facade;

import dataGenerator.DataInsertion;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.InfoEntity;
import entity.Person;
import entity.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class DataFacade implements IDataFacade {
    
    Person p = new Person();
    InfoEntity ie = new InfoEntity();
    Address a = new Address();
    Phone ph = new Phone();
    CityInfo ci = new CityInfo();
    Hobby h = new Hobby();
    EntityManagerFactory emf;
    
    public DataFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<CityInfo> getAllZips() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT ci FROM CityInfo ci").getResultList();
        } finally {
            em.close();
        }
    }
//

    public CityInfo getCityByZip(String zipcode) {
        EntityManager em = getEntityManager();
        try {
            CityInfo ci = em.find(CityInfo.class, zipcode);
            return ci;
        } finally {
            em.close();
        }
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
    
    @Override
    public void createPerson(String fields) {
        
        String inputs[] = fields.split(",");
        EntityManager em = getEntityManager();
        
        p.setFirstName(inputs[0]);
        p.setLastName(inputs[1]);
        p.setEmail(inputs[2]);
        a.setStreet(inputs[3]);
        a.setAdditionalInfo(inputs[4]);
        ph.setNumber(inputs[5]);
        ph.setDescription(inputs[6]);
        ci.setCity(inputs[7]);
        ci.setZipCode(inputs[8]);
        h.setName(inputs[9]);
        h.setDescription(inputs[10]);
        
        p.setAddress(a);
        a.setCityInfo(ci);
        p.addHobby(h);
        p.addPhone(ph);
        ph.setInfoEntity(p);
        
        try {
            em.getTransaction().begin();
            em.persist(p);
            
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
    
    public void fillDatabase(int amount) {
        DataInsertion.insert2Database(amount);
    }

    public void generateSchema() {
        DataInsertion.createSchema();
    }
    
}
