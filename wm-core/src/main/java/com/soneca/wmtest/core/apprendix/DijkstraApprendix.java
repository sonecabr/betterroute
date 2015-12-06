package com.soneca.wmtest.core.apprendix;

import es.usc.citius.hipster.algorithm.Algorithm;
import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.model.problem.SearchProblem;
import es.usc.citius.hipster.util.graph.GraphBuilder;
import es.usc.citius.hipster.util.graph.GraphSearchProblem;
import es.usc.citius.hipster.util.graph.HipsterDirectedGraph;

/**
 * @author andre
 * @since 06/12/2015 11:51
 */
public class DijkstraApprendix {
    /**
     * @author andre
     * @since 06/12/2015 11:06
     */
    public static class RouteTest {

        public static void main(String []args){

            HipsterDirectedGraph<String, Double> graph = GraphBuilder.create()
                    .connect("A").to("B").withEdge(10d)
                    .connect("B").to("D").withEdge(15d)
                    .connect("A").to("C").withEdge(20d)
                    .connect("C").to("D").withEdge(30d)
                    .connect("B").to("E").withEdge(50d)
                    .connect("D").to("E").withEdge(30d)
                    .buildDirectedGraph();

            SearchProblem p = new GraphSearchProblem()
                    .startingFrom("A")
                    .in(graph)
                    .takeCostsFromEdges()
                    .build();

            Algorithm.SearchResult result = Hipster.createDijkstra(p).search("D");


            System.out.println(Hipster.createDijkstra(p).search("D"));

        }
    }
}
