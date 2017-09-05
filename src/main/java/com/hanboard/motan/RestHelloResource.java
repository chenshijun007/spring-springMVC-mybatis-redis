package com.hanboard.motan;

import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

public class RestHelloResource implements HelloResource {

    public List<User> hello(int id) {
        return Arrays.asList(new User(id, "de"));
    }

    @Override
    public String testPrimitiveType() {
        return "helloworld";
    }

    @Override
    public Response add(int id, String name) {
        return Response.ok().cookie(new NewCookie("ck", String.valueOf(id))).entity(new User(id, name)).build();
    }

    @Override
    public void testException() {
        throw new UnsupportedOperationException("unsupport");
    }

}