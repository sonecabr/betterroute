package com.soneca.wmtest.api.entrypoint;

import com.soneca.wmtest.api.business.RouteBusiness;
import com.soneca.wmtest.api.exception.WmBusinessException;
import com.soneca.wmtest.core.entity.Route;
import com.soneca.wmtest.core.entity.RouteCost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author andre
 * @since 06/12/2015 12:29
 */
@Path("/route")
@Produces(MediaType.APPLICATION_JSON)
public class RouteEntrypoint {

    @Inject
    private RouteBusiness business;

    private Logger LOG = LoggerFactory.getLogger(RouteEntrypoint.class);


    /**
     * Add a Route to repository
     * @param route
     * @return Route
     */
    @PUT
    public Route add(Route route){
        try {
            route = business.addRoute(route);
            return route;
        } catch (WmBusinessException e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

    /**
     * Add multiple routes to repository
     * @param routes
     * @return List<Route>
     */
    @PUT
    @Path("/_bulk")
    public List<Route> bulk(List<Route> routes){
        try {
            for(Route route : routes){
                route = business.addRoute(route);
            }
            return routes;
        } catch (WmBusinessException e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

    /**
     * List all routes based on parentName
     * @param parentName
     * @return List<Route>
     */
    @GET
    @Path("/list/{parentName}")
    public List<Route> list(
            @PathParam("parentName") String parentName){

        try {
            return business.listRoutes(parentName);
        } catch (WmBusinessException e) {
            LOG.error(e.getMessage());
        }
        return null;

    }

    /**
     * Get a route from repository
     * @param id
     * @return Route
     */
    @GET
    @Path("/{id}")
    public Route get(@PathParam("id") Long id){
        try {
            return business.get(id);
        } catch (WmBusinessException e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

    /**
     * Find best route
     * @param routeCoast
     * @return RouteCoast with best path
     */
    @POST
    @Path("/best")
    public RouteCost best(RouteCost routeCoast) {
        try {
            business.findBestRoute(routeCoast);
        } catch (WmBusinessException e) {
            LOG.error(e.getMessage());
            routeCoast.setMessage("Rota invalida para a carga informada");
        }
        return routeCoast;
    }

}
