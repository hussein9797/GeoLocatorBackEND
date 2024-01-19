package com.IT_Pluse.GeoLocator.repository;

import com.IT_Pluse.GeoLocator.model.Geo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoRepository extends JpaRepository<Geo, Long> {


    Geo findByAddress(String address);



}
