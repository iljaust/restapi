package com.iljaust.rest;

import com.iljaust.dto.DeveloperDTO;
import com.iljaust.model.Developer;
import com.iljaust.service.DeveloperService;
import org.modelmapper.ModelMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/v1/developers")
public class DeveloperRestControllerV1 {
    public static void main(String[] args) {
        final DeveloperService developerService = new DeveloperService();
        final ModelMapper modelMapper = new ModelMapper();
        List<Developer> developers = developerService.getAll();

        List<DeveloperDTO> developerDTOS = developers
                .stream()
                .map(developer -> modelMapper.map(developer,DeveloperDTO.class))
                .collect(Collectors.toList());

        developerDTOS.forEach(System.out::println);

    }

    private final DeveloperService developerService = new DeveloperService();
    private final ModelMapper modelMapper = new ModelMapper();


    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<DeveloperDTO> getAllDev() {

        List<Developer> developers = developerService.getAll();

        List<DeveloperDTO> developerDTOS = developers
                .stream()
                .map(developer -> modelMapper.map(developer,DeveloperDTO.class))
                .collect(Collectors.toList());

        developers.forEach(System.out::println);

        return  developerDTOS;
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Developer getDevById(@PathParam("id") long id) {
        Developer developer = developerService.getById(id);
        DeveloperDTO developerDTO = modelMapper.map(developer,DeveloperDTO.class);

        if (developerDTO != null) {
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
    @Path("/{id}")
    public Response updateDev(Developer developer) {
        developerService.update(developer);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDev(@PathParam("id") long id) {
        developerService.deleteById(id);
        return Response.ok().build();
    }
}
