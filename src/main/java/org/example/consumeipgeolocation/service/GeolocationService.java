package org.example.consumeipgeolocation.service;
import org.example.consumeipgeolocation.model.GeolocationStatsResponse;
import org.example.consumeipgeolocation.repository.GeolocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeolocationService {

    @Autowired
    private GeolocationRepository geolocationRepository;

    public GeolocationStatsResponse getGeolocationStats() {
        GeolocationStatsResponse response = new GeolocationStatsResponse();

        // Obtener la distancia mínima
        Double minDistance = geolocationRepository.findMinDistance();
        response.setMinDistance(minDistance);

        // Obtener el país con la distancia mínima
        String minDistanceCountry = geolocationRepository.findCountryWithMinDistance();
        response.setMinDistanceCountry(minDistanceCountry);

        // Obtener la distancia máxima
        Double maxDistance = geolocationRepository.findMaxDistance();
        response.setMaxDistance(maxDistance);

        // Obtener el país con la distancia máxima
        String maxDistanceCountry = geolocationRepository.findCountryWithMaxDistance();
        response.setMaxDistanceCountry(maxDistanceCountry);

        // Obtener la distancia promedio
        Double averageDistance = geolocationRepository.findAverageDistance();
        response.setAverageDistance(averageDistance);

        return response;
    }
}