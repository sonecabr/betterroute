package com.soneca.wmtest.core.entity;

import javax.persistence.*;

/**
 * @author andre
 * @since 06/12/2015 12:30
 */
@Entity
@Table(name = "route")
public class Route implements IEntity {

    @Id
    @Column(name = "id", nullable = false, precision = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, precision = 200)
    private String name;

    @Column(name = "parentname", nullable = false, precision = 200)
    private String parentName;

    @Column(name = "neighbor", precision = 100, nullable = false)
    private String neighbor;

    @Column(name = "distance", nullable = false)
    private Integer distance;

    public Route withName(String name){
        setName(name);
        return this;
    }
    public Route withParentName(String parentName){
        setParentName(parentName);
        return this;
    }
    public Route withNeighbor(String neighbor){
        setNeighbor(neighbor);
        return this;
    }
    public Route withDistance(Integer distance){
        setDistance(distance);
        return this;
    }


    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Long id) {
        this.id = id;
    }

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
     * Getter for property 'neighbor'.
     *
     * @return Value for property 'neighbor'.
     */
    public String getNeighbor() {
        return neighbor;
    }

    /**
     * Setter for property 'neighbor'.
     *
     * @param neighbor Value to set for property 'neighbor'.
     */
    public void setNeighbor(String neighbor) {
        this.neighbor = neighbor;
    }

    /**
     * Getter for property 'distance'.
     *
     * @return Value for property 'distance'.
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Setter for property 'distance'.
     *
     * @param distance Value to set for property 'distance'.
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
