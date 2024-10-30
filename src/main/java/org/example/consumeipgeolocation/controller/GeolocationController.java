package org.example.consumeipgeolocation.controller;

import org.example.consumeipgeolocation.model.GeolocationStatsResponse;
import org.example.consumeipgeolocation.service.GeolocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/geolocation")
public class GeolocationController {

    @Autowired
    private GeolocationService geolocationService;

    @GetMapping("/stats")
    @RateLimiter(name = "default")  // Aplica rate limiting
    @CircuitBreaker(name = "default") // Aplica circuit breaker
    public ResponseEntity<GeolocationStatsResponse> getGeolocationStats() {
        GeolocationStatsResponse response = geolocationService.getGeolocationStats();
        return ResponseEntity.ok(response);
    }
}
