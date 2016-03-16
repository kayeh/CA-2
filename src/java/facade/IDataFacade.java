/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;

/**
 *
 * @author Eske Wolff
 */
public interface IDataFacade {
    
    public Person getPerson(int id);
    public List<Person> getPersons();
    public List<Person> getPersons(int zipCode);
    
}
