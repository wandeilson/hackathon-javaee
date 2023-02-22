package com.stefanini.resource;

import com.stefanini.models.Usuario;
import com.stefanini.repository.UsuarioRepository;
import com.stefanini.service.UsuarioService;

import javax.inject.Inject;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioRepository usuarioRepository;
    @Inject
    UsuarioService usuarioService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response listar(){
        return Response.ok(usuarioService.listar()).status(Response.Status.OK).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar ( @Valid Usuario usuario) throws Exception {
        return Response.ok(usuarioService.salvar(usuario)).status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletar (@PathParam("id") Long id){
        usuarioService.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("{id}")
    public Response atualizar (@PathParam("id") @Valid Long id, Usuario usuario){
        return Response.ok(usuarioService.atualizar(id, usuario)).build();
    }

    @GET
    @Path("/aniversariantesDoMes")
    public Response anivesariantesDoMes (){
        return Response.ok(usuarioService.anivesariantesDoMes()).build();
    }
}
