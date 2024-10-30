package org.example.consumeipgeolocation.model;

public class GeolocationStatsResponse {

    private Double minDistance;
    private Double maxDistance;
    private Double averageDistance;
    private String minDistanceCountry;
    private String maxDistanceCountry;

    // Getters y Setters

    public Double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(Double minDistance) {
        this.minDistance = minDistance;
    }

    public Double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Double maxDistance) {
        this.maxDistance = maxDistance;
    }

    public Double getAverageDistance() {
        return averageDistance;
    }

    public void setAverageDistance(Double averageDistance) {
        this.averageDistance = averageDistance;
    }

    public String getMinDistanceCountry() {
        return minDistanceCountry;
    }

    public void setMinDistanceCountry(String minDistanceCountry) {
        this.minDistanceCountry = minDistanceCountry;
    }

    public String getMaxDistanceCountry() {
        return maxDistanceCountry;
    }

    public void setMaxDistanceCountry(String maxDistanceCountry) {
        this.maxDistanceCountry = maxDistanceCountry;
    }
}
