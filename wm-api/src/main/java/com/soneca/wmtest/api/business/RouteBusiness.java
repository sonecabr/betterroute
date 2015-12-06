package com.soneca.wmtest.api.business;

import com.soneca.wmtest.api.exception.WmBusinessException;
import com.soneca.wmtest.core.route.BetterRoute;
import com.soneca.wmtest.core.entity.Route;
import com.soneca.wmtest.core.entity.RouteCost;
import com.soneca.wmtest.persistence.dao.RouteDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * @author andre
 * @since 06/12/2015 13:34
 */
@Named
@RequestScoped
public class RouteBusiness {

    @Inject
    private RouteDAO dao;

    @Inject
    private BetterRoute betterRoute;

    /**
     * Add a route to routes
     * @param route
     * @return Route with id
     * @throws WmBusinessException
     */
    public Route addRoute(Route route) throws WmBusinessException {
        if(route.getDistance() == null || route.getNeighbor() == null || route.getParentName() == null ){
            throw new WmBusinessException("Invalid route");
        }
        return dao.save(route);
    }

    /**
     * Fin a route
     * @param id
     * @return Route
     * @throws WmBusinessException
     */
    public Route get(Long id) throws WmBusinessException {
        if(id == null){
            throw new WmBusinessException("Invalid route");
        }
        return dao.get(id);
    }


    /**
     * List all routes based on parentNeme
     * @param parentName
     * @return List<Route>
     * @throws WmBusinessException
     */
    public List<Route> listRoutes(String parentName) throws WmBusinessException {
        if(parentName == null){
            throw new WmBusinessException("Invalid route");
        }
        return dao.findRoutes(parentName);
    }

    public RouteCost findBestRoute(RouteCost routeCost) throws WmBusinessException {
        if(routeCost == null || routeCost.getParentName() == null || routeCost.getAutonomy() == null
           || routeCost.getStart() == null || routeCost.getEnd() == null || routeCost.getGasCost() == null){
            throw new WmBusinessException("Invalid request");
        }
        List<Route> routes = dao.findRoutes(routeCost.getParentName());
        validateRouteCoast(routes, routeCost);
        betterRoute.find(routeCost, routes);
        return routeCost;
    }

    public Boolean validateRouteCoast(List<Route> routes, RouteCost routeCoast){
        //verify routeStart and end
        Boolean startMatch = false;
        Boolean endMatch = false;
        for(Route route : routes){
            if(route.getName().equals(routeCoast.getStart())){
                startMatch = true;
                if(endMatch){
                    break;
                }
            }
            if(route.getName().equals(routeCoast.getEnd())){
                endMatch = true;
                if(startMatch){
                    break;
                }
            }
        }

        return startMatch && endMatch;
    }
}
