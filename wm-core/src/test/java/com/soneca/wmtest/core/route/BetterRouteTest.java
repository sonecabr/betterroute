package com.soneca.wmtest.core.route;

import com.soneca.wmtest.core.entity.Route;
import com.soneca.wmtest.core.entity.RouteCost;
import junit.framework.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andre
 * @since 06/12/2015 19:31
 */
public class BetterRouteTest {

    private BetterRoute betterRoute;


    @BeforeTest
    public void mock(){
        betterRoute = new BetterRoute();
    }


    @Test
    public void testCalcAutonomy(){
        Assert.assertEquals(6.25, betterRoute.calcAutonomy(25.0, 2.5, 10.0));
    }

    @Test(dependsOnMethods = "testCalcAutonomy")
    public void testFind(){
        List<Route> routes = new ArrayList<>();
        routes.add(
                new Route()
                           .withName("A")
                           .withNeighbor("B")
                           .withDistance(10)
                           .withParentName("São Paulo")

        );
        routes.add(
                new Route()
                        .withName("B")
                        .withNeighbor("D")
                        .withDistance(15)
                        .withParentName("São Paulo")

        );
        routes.add(
                new Route()
                        .withName("A")
                        .withNeighbor("C")
                        .withDistance(15)
                        .withParentName("São Paulo")

        );
        routes.add(
                new Route()
                        .withName("C")
                        .withNeighbor("D")
                        .withDistance(30)
                        .withParentName("São Paulo")

        );
        routes.add(
                new Route()
                        .withName("B")
                        .withNeighbor("E")
                        .withDistance(50)
                        .withParentName("São Paulo")

        );
        routes.add(
                new Route()
                        .withName("D")
                        .withNeighbor("E")
                        .withDistance(50)
                        .withParentName("São Paulo")
        );



                RouteCost cost = new RouteCost();
        cost.setAutonomy(10.0);
        cost.setGasCost(2.5);
        cost.setParentName("São Paulo");
        cost.setStart("A");
        cost.setEnd("D");
        betterRoute.find(cost, routes);
        Assert.assertEquals("A->B->D", cost.getBestRoute().get(0));
        Assert.assertEquals(6.25, cost.getTotalCost());
    }
}
