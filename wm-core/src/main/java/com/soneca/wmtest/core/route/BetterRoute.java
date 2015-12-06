package com.soneca.wmtest.core.route;

import com.soneca.wmtest.core.entity.Route;
import com.soneca.wmtest.core.entity.RouteCost;
import es.usc.citius.hipster.algorithm.Algorithm;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.model.impl.WeightedNode;
import es.usc.citius.hipster.model.problem.SearchProblem;
import es.usc.citius.hipster.util.graph.GraphBuilder;
import es.usc.citius.hipster.util.graph.GraphSearchProblem;
import es.usc.citius.hipster.util.graph.HashBasedHipsterDirectedGraph;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * @author andre
 * @since 06/12/2015 16:22
 */
@Named
@RequestScoped
public class BetterRoute {

    /**
     * find best route to deliver with minimal cost
     * @param routeCost
     * @param routes
     */
    public void find(RouteCost routeCost, List<Route> routes) {

        GraphBuilder.Assistant assistant = GraphBuilder.create();


        HashBasedHipsterDirectedGraph<String, Integer> graph = HashBasedHipsterDirectedGraph.create();
        for (Route route : routes) {
            graph.add(route.getName());
            graph.add(route.getNeighbor());
            graph.connect(route.getName(), route.getNeighbor(), route.getDistance());
        }

        SearchProblem p = new GraphSearchProblem()
                .startingFrom(routeCost.getStart())
                .in(graph)
                .takeCostsFromEdges()
                .build();

        Algorithm.SearchResult result = Hipster.createDijkstra(p).search(routeCost.getEnd());


        WeightedNode detail = (WeightedNode) result.getGoalNode();
        routeCost.setTotalCost(calcAutonomy((Double) detail.getCost(), routeCost.getGasCost(), routeCost.getAutonomy()));


        for (Object item : result.getOptimalPaths()) {
            StringBuffer buffer = new StringBuffer();
            for (String vertice : (List<String>) item) {
                buffer.append(vertice);
                buffer.append("->");
            }
            routeCost.getBestRoute().add(buffer.toString().substring(0, buffer.length() - 2));

        }
    }

    /**
     * return total cost to deliver
     * @param totalKm
     * @param costPerKm
     * @param autonomy
     * @return Double totalCost
     */
    public Double calcAutonomy(Double totalKm, Double costPerKm, Double autonomy){
        return (totalKm / autonomy)  * costPerKm;
    }

}
