///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rest;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import entity.CityInfo;
//import facade.DataFacade;
//import java.util.List;
//import javax.persistence.Persistence;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//import javax.ws.rs.Produces;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.core.MediaType;
//
///**
// * REST Web Service
// *
// * @author Eske Wolff
// */
//@Path("city")
//public class CityInfoResource {
//
//    Gson gson;
//
//    @Context
//    private UriInfo context;
//
//    DataFacade facade = new DataFacade(Persistence.createEntityManagerFactory("CA2_Eske_JoniPU"));
//    //DataFacade facade = new DataFacade(Persistence.createEntityManagerFactory("pu_OPENSHIFT"));
//
//    /**
//     * Creates a new instance of person
//     */
//    public CityInfoResource() {
//        gson = new GsonBuilder().setPrettyPrinting().create();
//    }
//
//    /**
//     * Retrieves representation of an instance of rest.PersonResource
//     *
//     * @return an instance of java.lang.String
//     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    @GET
//    @Path("/complete")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPlaces() {
//        List<CityInfo> cityInfoes = facade.getAllZips();
//        JsonArray json = new JsonArray();
//
//        for (CityInfo cityInfo : cityInfoes) {
//            JsonObject obj = new JsonObject();
//            JsonArray hobbies = new JsonArray();
//
//            obj.addProperty("zipCode", cityInfo.getZipCode());
//            obj.addProperty("city", cityInfo.getCity());
//
//            json.add(obj);
//        }
//        return gson.toJson(json);
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getCityByZip(@PathParam("zipCode") String zipCode) {
//        CityInfo ci = facade.getCityByZip(zipCode);
//        JsonArray json = new JsonArray();
//
//        JsonObject obj = new JsonObject();
//        obj.addProperty("city", ci.getCity());
//        obj.addProperty("zipCode", ci.getZipCode());
//        json.add(obj);
//
//        return gson.toJson(json);
//        //  throw new UnsupportedOperationException();
//    }
//
//}
