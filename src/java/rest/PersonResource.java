/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entity.Person;
import facade.DataFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Eske Wolff
 */
@Path("person")
public class PersonResource {

    Gson gson;

    @Context
    private UriInfo context;

    DataFacade facade = new DataFacade(Persistence.createEntityManagerFactory("CA2_Eske_JoniPU"));

    /**
     * Creates a new instance of person
     */
    public PersonResource() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Retrieves representation of an instance of rest.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/{complete}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Person> persons = facade.getAllPersons();
        JsonArray json = new JsonArray();
        
        // return gson.toJson();
        for (Person person : persons) {
            JsonObject obj = new JsonObject();
            obj.addProperty("firstName", person.getFirstName());
            json.add(obj);
        }
        return gson.toJson(json);
        // throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPersonById() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
}
