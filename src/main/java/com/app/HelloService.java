package com.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloService {

	@GET
	@Path("/{param}")
	public Response getMessage(@PathParam("param") String msg){
		
		String out = "HI " + msg;
		return Response.status(200).entity(out).build();
	}
}