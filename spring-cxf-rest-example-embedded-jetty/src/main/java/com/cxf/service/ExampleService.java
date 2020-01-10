package com.cxf.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cxf.model.ExampleModel;

@Path("/example")
@Produces("application/json")
public interface ExampleService {

	@GET
    @Path("/{id}")
    public ExampleModel get(@PathParam("id") String id);
	 
}
