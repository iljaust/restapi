package com.iljaust.rest;

import com.iljaust.dto.AccountDTO;
import com.iljaust.model.Account;
import com.iljaust.respository.AccountRepository;
import com.iljaust.respository.hibernate.AccountRepositoryImpl;
import org.modelmapper.ModelMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/v1/accounts")
public class AccountRestControllerV1 {
    private final AccountRepository accountRepository = new AccountRepositoryImpl();
    private final ModelMapper modelMapper = new ModelMapper();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<AccountDTO> getAllAcc() {

        List<Account> accounts =  accountRepository.getAll();

        List<AccountDTO> accountDTOS = accounts
                .stream()
                .map(account -> modelMapper.map(account,AccountDTO.class))
                .collect(Collectors.toList());

        return  accountDTOS;
    }


    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getAccById(@PathParam("id") long id) {
        Account account = accountRepository.getById(id);
        AccountDTO accountDTO = modelMapper.map(account,AccountDTO.class);

        if (accountDTO != null) {
            return Response.ok(accountDTO, MediaType.APPLICATION_JSON).build();
        }
        return null;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response add(Account account) {
        accountRepository.save(account);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(Account account) {
        accountRepository.update(account);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        Account account = accountRepository.getById(id);
        accountRepository.deleteById(id);
        return Response.ok().build();
    }
}

