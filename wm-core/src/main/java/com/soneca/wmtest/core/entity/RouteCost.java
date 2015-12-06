package com.soneca.wmtest.core.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andre
 * @since 06/12/2015 16:15
 */
public class RouteCost {

    private String parentName;
    private String start;
    private String end ;
    private Double autonomy;
    private Double gasCost;
    private List<String> bestRoute = new ArrayList<>();
    private Double totalCost;
    private String message;

    /**
     * Getter for property 'parentName'.
     *
     * @return Value for property 'parentName'.
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * Setter for property 'parentName'.
     *
     * @param parentName Value to set for property 'parentName'.
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * Getter for property 'start'.
     *
     * @return Value for property 'start'.
     */
    public String getStart() {
        return start;
    }

    /**
     * Setter for property 'start'.
     *
     * @param start Value to set for property 'start'.
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * Getter for property 'end'.
     *
     * @return Value for property 'end'.
     */
    public String getEnd() {
        return end;
    }

    /**
     * Setter for property 'end'.
     *
     * @param end Value to set for property 'end'.
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Getter for property 'autonomy'.
     *
     * @return Value for property 'autonomy'.
     */
    public Double getAutonomy() {
        return autonomy;
    }

    /**
     * Setter for property 'autonomy'.
     *
     * @param autonomy Value to set for property 'autonomy'.
     */
    public void setAutonomy(Double autonomy) {
        this.autonomy = autonomy;
    }

    /**
     * Getter for property 'gasCost'.
     *
     * @return Value for property 'gasCost'.
     */
    public Double getGasCost() {
        return gasCost;
    }

    /**
     * Setter for property 'gasCost'.
     *
     * @param gasCost Value to set for property 'gasCost'.
     */
    public void setGasCost(Double gasCost) {
        this.gasCost = gasCost;
    }

    /**
     * Getter for property 'bestRoute'.
     *
     * @return Value for property 'bestRoute'.
     */
    public List<String> getBestRoute() {
        return bestRoute;
    }

    /**
     * Setter for property 'bestRoute'.
     *
     * @param bestRoute Value to set for property 'bestRoute'.
     */
    public void setBestRoute(List<String> bestRoute) {
        this.bestRoute = bestRoute;
    }

    /**
     * Getter for property 'totalCost'.
     *
     * @return Value for property 'totalCost'.
     */
    public Double getTotalCost() {
        return totalCost;
    }

    /**
     * Setter for property 'totalCost'.
     *
     * @param totalCost Value to set for property 'totalCost'.
     */
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Getter for property 'message'.
     *
     * @return Value for property 'message'.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter for property 'message'.
     *
     * @param message Value to set for property 'message'.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
