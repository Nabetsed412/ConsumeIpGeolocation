package org.example.consumeipgeolocation.repository;
import org.example.consumeipgeolocation.model.Geolocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepository extends JpaRepository<Geolocation, Long> {

    @Query("SELECT MIN(g.distance) FROM Geolocation g")
    Double findMinDistance();

    @Query("SELECT MAX(g.distance) FROM Geolocation g")
    Double findMaxDistance();

    @Query("SELECT AVG(distance) FROM Geolocation")
    Double findAverageDistance();

    /*@Query("SELECT AVG(tmp2.a) FROM (SELECT tmp.ic * tmp.distance AS a FROM (SELECT SUM(g.iterationCount) AS ic, g.distance, g.countryName FROM Geolocation as g GROUP BY g.distance, g.countryName) AS tmp) AS tmp2")
    Double findAverageDistance();*/



    @Query("SELECT g.countryName FROM Geolocation g WHERE g.distance = (SELECT MIN(g.distance) FROM Geolocation g)")
    String findCountryWithMinDistance();

    @Query("SELECT g.countryName FROM Geolocation g WHERE g.distance = (SELECT MAX(g.distance) FROM Geolocation g)")
    String findCountryWithMaxDistance();
}
