package com.soneca.wmtest.api.entrypoint;

import com.soneca.wmtest.core.entity.Probe;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author andre
 * @since 06/12/2015 12:18
 */
@Path("/probe")
@Produces(MediaType.APPLICATION_JSON)
public class ProbeEntrypont {

    @GET
    public Probe get(){
        return new Probe().withStatus("OK");
    }
}
