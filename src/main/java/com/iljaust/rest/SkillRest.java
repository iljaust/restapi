package com.iljaust.rest;


import com.iljaust.model.Account;
import com.iljaust.model.Skill;
import com.iljaust.service.SkillService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/skills")
public class SkillRest {
    private final SkillService skillService = new SkillService();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Skill> getAllSkills() {
        return skillService.getAll();
    }

    @GET
    @Path("skill/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Skill getSkillById(@PathParam("id") long id) {
        Skill skill = skillService.getById(id);
        if (skill != null) {
            return skill;
        }
        return null;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response addSkill(Skill skill) {
        skillService.save(skill);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("skill/{id}")
    public Response updateSkill(Skill skill) {
        skillService.update(skill);
        return Response.ok().build();
    }

    @DELETE
    @Path("skill/{id}")
    public Response deleteSkill(@PathParam("id") long id) {
        skillService.deleteById(id);
        return Response.ok().build();
    }
}
