package com.github.nishant141077.sors.resources;

import com.google.inject.Singleton;
import io.swagger.annotations.Api;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/dummy")
@Api("Dummy APIs")
public class DummyResource {

  @GET
  @Path("/fetch")
  public Response fetch() {
    return Response.accepted().build();
  }
}
