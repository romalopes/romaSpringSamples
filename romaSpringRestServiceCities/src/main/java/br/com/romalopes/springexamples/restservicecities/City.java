package br.com.romalopes.springexamples.restservicecities;

public class City {

    private final long id;

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    private final String shortName;
    private final String longName;

    public City(long id, String shortName, String longName) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
    }

    public long getId() {
        return id;
    }
    public String toString() {
        return shortName + " " + longName;
    }

}