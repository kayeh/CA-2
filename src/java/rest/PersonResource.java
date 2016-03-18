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
import com.google.gson.JsonPrimitive;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.DataFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
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
    //DataFacade facade = new DataFacade(Persistence.createEntityManagerFactory("pu_OPENSHIFT"));

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
    @Path("/complete")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Person> persons = facade.getAllPersons();
        JsonArray json = new JsonArray();

        for (Person person : persons) {
            JsonObject obj = new JsonObject();
            JsonArray hobbies = new JsonArray();
            for (int i = 0; i < person.getHobbies().size(); i++) {
                Hobby h = person.getHobbies().get(i);
                hobbies.add(new JsonPrimitive(h.getName()));
            }
            JsonArray phones = new JsonArray();
            for (int i = 0; i < person.getPhone().size(); i++) {
                Phone ph = person.getPhone().get(i);
                phones.add(new JsonPrimitive(ph.getNumber()));
            }

            obj.addProperty("firstName", person.getFirstName());
            obj.addProperty("lastName", person.getLastName());
            obj.addProperty("street", person.getAddress().toString());
            obj.add("phones", phones);
            obj.add("hobbies", hobbies);
            json.add(obj);
        }
        return gson.toJson(json);
    }

    @GET
    @Path("/complete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id) {
        Person person = facade.getPerson(id);
        JsonArray json = new JsonArray();

        JsonObject obj = new JsonObject();
        obj.addProperty("firstName", person.getFirstName());
        obj.addProperty("lastName", person.getLastName());
        json.add(obj);

        return gson.toJson(json);

    }

    @POST
    @Path("/{fields}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createPerson(@PathParam("fields") String fields) {
        JsonArray json = new JsonArray();
        String[] fieldSplitt = fields.split(",");
        JsonObject obj = new JsonObject();
        obj.addProperty("firstName", fieldSplitt[0]);
        obj.addProperty("lastName", fieldSplitt[1]);
        obj.addProperty("email", fieldSplitt[2]);
        obj.addProperty("adressstreet", fieldSplitt[3]);
        obj.addProperty("adressAddInfo", fieldSplitt[4]);
        obj.addProperty("phoneNo", fieldSplitt[5]);
        obj.addProperty("phoneDesc", fieldSplitt[6]);
        obj.addProperty("city", fieldSplitt[7]);
        obj.addProperty("zipcode", fieldSplitt[8]);
        obj.addProperty("hobbyName", fieldSplitt[9]);
        obj.addProperty("hobbydesc", fieldSplitt[10]);

        json.add(obj);
        facade.createPerson(fields);
        
        return gson.toJson(json);
        //return fields;

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
