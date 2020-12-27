package com.iljaust.rest;

import com.iljaust.model.Developer;
import com.iljaust.service.DeveloperService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/developers")
public class DeveloperRest {
    private final DeveloperService developerService = new DeveloperService();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Developer> getAllDev() {

        return developerService.getAll();
    }

    @GET
    @Path("developer/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Developer getDevById(@PathParam("id") long id) {
        Developer developer = developerService.getById(id);
        if (developer != null) {
            return developer;
        }
        return null;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response addDev(Developer developer) {
        developerService.save(developer);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("developer/{id}")
    public Response updateDev(Developer developer) {
        developerService.update(developer);
        return Response.ok().build();
    }

    @DELETE
    @Path("developer/{id}")
    public Response deleteDev(@PathParam("id") long id) {
        developerService.deleteById(id);
        return Response.ok().build();
    }
}
