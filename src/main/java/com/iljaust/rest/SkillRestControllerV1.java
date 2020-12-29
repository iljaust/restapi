package com.iljaust.rest;


import com.iljaust.dto.SkillDTO;
import com.iljaust.model.Account;
import com.iljaust.model.Skill;
import com.iljaust.service.SkillService;
import org.modelmapper.ModelMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/v1/skills")
public class SkillRestControllerV1 {
    private final SkillService skillService = new SkillService();
    private final ModelMapper modelMapper = new ModelMapper();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<SkillDTO> getAllSkills() {

        List<Skill> skills =  skillService.getAll();
        List<SkillDTO> skillDTOS = skills
                .stream()
                .map(skill -> modelMapper.map(skill,SkillDTO.class))
                .collect(Collectors.toList());

        return skillDTOS;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public SkillDTO getSkillById(@PathParam("id") long id) {
        Skill skill = skillService.getById(id);
        SkillDTO skillDTO = modelMapper.map(skill,SkillDTO.class);

        if (skillDTO != null) {
            return skillDTO;
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
    @Path("/{id}")
    public Response updateSkill(Skill skill) {
        skillService.update(skill);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSkill(@PathParam("id") long id) {
        skillService.deleteById(id);
        return Response.ok().build();
    }
}
