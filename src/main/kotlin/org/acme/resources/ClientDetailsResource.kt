package org.acme.resources

import org.acme.models.ClientDetails
import org.acme.services.ClientDetailsService
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response

@Path("api/v1/")
class ClientDetailsResource {
    @Inject
    lateinit var clientDetailsService: ClientDetailsService

    @GET
    @Produces(APPLICATION_JSON)
    fun listAllClientDetails(): Response {
        return Response.ok(clientDetailsService.listAllClientDetails()).build()
    }

    @GET
    @Path("/{id}")
    fun findByIdClientDetails(@PathParam("id") id: Long): Response {
        val clientDetails = clientDetailsService.findByIdClientDetails(id)
        if (clientDetails != null) {
            return Response.ok().build()
        }
        return Response.ok("Client Details does not exist").status(Response.Status.NOT_FOUND).build()
    }

    @GET
    @Path("/{name}")
    fun findByNameClientDetails(@PathParam("name") name: String): Response {
        val clientDetails = clientDetailsService.findByNameClientDetails(name)
        if (clientDetails != null) {
            return Response.ok().build()
        }
        return Response.ok("Client Details does not exist").status(Response.Status.NOT_FOUND).build()
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    fun persistClientDetails(clientDetails: ClientDetails): Response {
        clientDetailsService.persistClientDetails(clientDetails)
        return Response.ok(clientDetails).status(Response.Status.CREATED).build()
    }

    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    fun updateClientDetails(clientDetails: ClientDetails): Response {
        val updateResult = clientDetailsService.updateClientDetails(clientDetails)
        if(updateResult > 0 ){
            return Response.ok(clientDetails).build()
        }
        return Response.ok("Update of Client Details is not successfully").build()
    }

    @DELETE
    @Path("/{id}")
    fun deleteClientDetails(@PathParam("id") id: Long): Response {
        val deleteResult = clientDetailsService.deleteClientDetails(id)
        if (deleteResult) {
            return Response.ok("Client Details deleted").build()
        }
        return Response.ok("Client Details could not be deleted").build()
    }
}