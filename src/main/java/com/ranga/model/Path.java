package com.ranga.model;

/**
 * Created by RANGA on 1/10/2019.
 */
public class Path {

    private String from;
    private String to;
    private Double distance;


    public Path(String from, String to, Double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Double getDistance() {
        return distance;
    }
}
