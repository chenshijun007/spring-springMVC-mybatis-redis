package com.hanboard.motan;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rest")
public interface HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<User> hello(@CookieParam("uid") int uid);

    @GET
    @Path("/primitive")
    @Produces(MediaType.TEXT_PLAIN)
    String testPrimitiveType();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    Response add(@FormParam("id") int id, @FormParam("name") String name);

    @GET
    @Path("/exception")
    @Produces(MediaType.APPLICATION_JSON)
    void testException();

    public static class User {
        private int id;
        private String name;

        public User() {
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

}