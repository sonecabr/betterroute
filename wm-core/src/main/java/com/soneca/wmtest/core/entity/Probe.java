package com.soneca.wmtest.core.entity;

/**
 * @author andre
 * @since 06/12/2015 12:26
 */
public class Probe {

    private String status;

    /**
     * Getter for property 'status'.
     *
     * @return Value for property 'status'.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter for property 'status'.
     *
     * @param status Value to set for property 'status'.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Probe withStatus(String status){
        setStatus(status);
        return this;
    }
}
