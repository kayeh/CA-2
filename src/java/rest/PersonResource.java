package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
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

@Path("person")
public class PersonResource {
    
    Gson gson;
    
    @Context
    private UriInfo context;
    
   // DataFacade facade = new DataFacade(Persistence.createEntityManagerFactory("CA2_Eske_JoniPU"));

    DataFacade facade = new DataFacade(Persistence.createEntityManagerFactory("pu_OPENSHIFT"));
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
    //@Path("/{fields}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createPerson(String jsonObj) {
      //  JsonArray json = new JsonArray();
        
        
        
        JsonObject personInJson = new JsonParser().parse(jsonObj).getAsJsonObject();
        String personFirstName = personInJson.get("firstName").getAsString();
        String personLastName = personInJson.get("lastName").getAsString();
        String personEmail = personInJson.get("email").getAsString();
        String personStreet = personInJson.get("addressStreet").getAsString();
        String personAddressAddInfo = personInJson.get("addressAddInfo").getAsString();
        String personPhoneNo = personInJson.get("phoneNo").getAsString();
        String personPhoneDesc = personInJson.get("phoneDesc").getAsString();
        String personCity = personInJson.get("city").getAsString();
        String personZipcode = personInJson.get("zipCode").getAsString();
        String personHobbyName = personInJson.get("hobbyName").getAsString();
        String personHobbyDesc = personInJson.get("hobbyDesc").getAsString();
        
        
        String fields = personFirstName + "," + personLastName + "," + personEmail + "," + personStreet + "," + personAddressAddInfo + "," + personPhoneNo
                + "," + personPhoneDesc + "," + personCity + "," + personZipcode + "," + personHobbyName + "," + personHobbyDesc;

        facade.createPerson(fields);

//        obj.addProperty("firstName", fieldSplitt[0]);
//        obj.addProperty("lastName", fieldSplitt[1]);
//        obj.addProperty("email", fieldSplitt[2]);
//        obj.addProperty("addressStreet", fieldSplitt[3]);
//        obj.addProperty("addressAddInfo", fieldSplitt[4]);
//        obj.addProperty("phoneNo", fieldSplitt[5]);
//        obj.addProperty("phoneDesc", fieldSplitt[6]);
//        obj.addProperty("city", fieldSplitt[7]);
//        obj.addProperty("zipcode", fieldSplitt[8]);
//        obj.addProperty("hobbyName", fieldSplitt[9]);
//        obj.addProperty("hobbydesc", fieldSplitt[10]);
//        
       // json.add(obj);
        
       // return null; //gson.toJson(json);
        //return fields;

    }

    @POST
    @Path("/generate/{number}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void GeneratePersons(@PathParam("number") int number) {
        
        facade.fillDatabase(number);
        
    }
     @POST
    @Path("/generate/schema")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void GenerateSchema() {
        
        facade.generateSchema();
        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
}
