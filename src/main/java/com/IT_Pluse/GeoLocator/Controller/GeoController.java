package com.IT_Pluse.GeoLocator.Controller;


import Dto.GeneralResponse;
import Dto.LocateAddressReq;
import com.IT_Pluse.GeoLocator.service.GeoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("api/geo")
public class GeoController {




    @Autowired
    GeoService geoService;


    @PostMapping("/locate")

    public ResponseEntity<Object> locateAddress(@RequestBody LocateAddressReq locateAddressReq) throws JsonProcessingException, MessagingException, UnsupportedEncodingException {

        try{

            ResponseEntity<GeneralResponse> result = geoService.getGeoLocation(locateAddressReq);
            if ( locateAddressReq.getMail()!=null && result.getStatusCode().is2xxSuccessful()){
                geoService.sendLocationMail(result.getBody().getData(),locateAddressReq.getMail());
            }

            return  new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e)
        {

        throw e;
        }
    }
}
