package com.IT_Pluse.GeoLocator.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Geo")
public class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "address")

    String address;

    @Column(name = "latitude")

    Double lat;
    @Column(name = "longitude")

    Double longt;


    public Geo() {
    }

    public Geo(String address, Double lat, Double longt) {
        this.address = address;
        this.lat = lat;
        this.longt = longt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongt() {
        return longt;
    }

    public void setLongt(Double longt) {
        this.longt = longt;
    }
}
