///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facade;
//
//import entity.Person;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Eske Wolff
// */
//public class DataFacadeTest{
//    
//     DataFacade facade = new DataFacade(Persistence.createEntityManagerFactory("CA2_Eske_JoniPU_Test"));
//
//    public DataFacadeTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {      
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        
//            EntityManager em = facade.getEntityManager();
//    try {
//      em.getTransaction().begin();
//    //  em.createQuery("delete from Person").executeUpdate();
//      Person p = new Person();
//      p.setFirstName("Hans");
//      p.setLastName("Ole");
//      em.persist(p);
//      em.getTransaction().commit();
//    } finally {
//      em.close();
//    }
//    }
//
//    @After
//    public void tearDown() {
//    }
//    /**
//     * Test of getEntityManager method, of class DataFacade.
//     */
//    @Test
//    public void testGetEntityManager() {
//        System.out.println("getEntityManager");
//        DataFacade instance = null;
//        EntityManager expResult = null;
//        EntityManager result = instance.getEntityManager();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPerson method, of class DataFacade.
//     */
//    @Test
//    public void testGetPerson() {
//        System.out.println("getPerson");
//        int id = 0;
//        DataFacade instance = null;
//        Person expResult = null;
//        Person result = instance.getPerson(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersons method, of class DataFacade.
//     */
//    @Test
//    public void testGetPersons_0args() {
//        System.out.println("getPersons");
//        DataFacade instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersons();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersons method, of class DataFacade.
//     */
//    @Test
//    public void testGetPersons_int() {
//        System.out.println("getPersons");
//        int zipCode = 0;
//        DataFacade instance = null;
//        List<Person> expResult = null;
//        List<Person> result = instance.getPersons(zipCode);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//}
