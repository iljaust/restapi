package com.iljaust.rest;

import com.iljaust.model.Account;
import com.iljaust.respository.AccountRepository;
import com.iljaust.respository.hibernate.AccountRepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/accounts")
public class AccountRest {
    private final AccountRepository accountRepository = new AccountRepositoryImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Account> getAllAcc() {
        return accountRepository.getAll();
    }


    @GET
    @Path("account/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getAccById(@PathParam("id") long id) {
        Account account = accountRepository.getById(id);
        if (account != null) {
            return Response.ok(account, MediaType.APPLICATION_JSON).build();
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
    @Path("account/{id}")
    public Response update(Account account) throws Exception {
        accountRepository.update(account);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) throws Exception {
        Account account = accountRepository.getById(id);
        accountRepository.deleteById(id);
        return Response.ok().build();
    }
}

