package com.IT_Pluse.GeoLocator.service;

import Dto.GeneralResponse;
import Dto.LocateAddressReq;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;

public interface GeoService {


    ResponseEntity<GeneralResponse> getGeoLocation(LocateAddressReq locateAddressReq) throws JsonProcessingException, MessagingException, UnsupportedEncodingException;

    public void sendLocationMail (Object geolocation,String email) throws MessagingException, UnsupportedEncodingException;

}
