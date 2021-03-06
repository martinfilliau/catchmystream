package com.martinfilliau.catchmystream.ws.input;

import com.martinfilliau.catchmystream.data.ws.ItemRepresentation;
import com.martinfilliau.catchmystream.services.InsertIntoCms;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author martinfilliau
 */

@Path("/items")
public class ItemsResource {
    @Context
    private UriInfo context;
    @EJB
    private InsertIntoCms service;

    /** Creates a new instance of ItemsResource */
    public ItemsResource() {
    }

    /**
     * POST method for creating an instance of ItemResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(ItemRepresentation item) {
        
        // TODO check key
        // TODO check format (date format for example)
        
        service.insert(item);
        
        // warning: this means that it is not possible to directly obtain
        // the ID of the new resource created
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
