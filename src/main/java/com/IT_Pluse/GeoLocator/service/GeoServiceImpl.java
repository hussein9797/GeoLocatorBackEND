package com.IT_Pluse.GeoLocator.service;

import Dto.GeneralResponse;
import Dto.LocateAddressReq;
import com.IT_Pluse.GeoLocator.model.Geo;

import Dto.Response.ResponseDTO;
import com.IT_Pluse.GeoLocator.repository.GeoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

@Service
public class GeoServiceImpl implements GeoService{


    @Autowired
    GeoRepository geoRepository;

    @Autowired
    ResponseHandler responseHandler;

    @Value("${google.api.key}")
    private String googleApiKey;
    @Autowired
    private JavaMailSender mailSender;


    @Override
    public ResponseEntity<GeneralResponse> getGeoLocation(LocateAddressReq locateAddressReq) throws JsonProcessingException, MessagingException, UnsupportedEncodingException {


        Geo geoByAddress = geoRepository.findByAddress(locateAddressReq.getAddress());

        if (geoByAddress==null){

          return this.fetchAndSaveGeolocation(locateAddressReq.getAddress());
        }

    return responseHandler.success(geoByAddress, HttpStatus.OK);




    }


    public ResponseEntity<GeneralResponse> fetchAndSaveGeolocation(String address) throws JsonProcessingException {

        String apiUrl = "https://api.geoapify.com/v1/geocode/search?text={address}&apiKey={apiKey}";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class, address, googleApiKey);
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseDTO locationDTO = objectMapper.readValue(response, ResponseDTO.class);


        if (locationDTO.getFeatures().length!=0) {


            double lat = locationDTO.getFeatures()[0].getProperties().getLat();
            double lon = locationDTO.getFeatures()[0].getProperties().getLon();



             Geo geolocation = new Geo(address, lat, lon);
            geoRepository.save(geolocation);

            return responseHandler.success(geolocation);
        }



        return responseHandler.badRequest("address.not.found",new Object[]{});
    }



    @Override
    public void sendLocationMail (Object geolocation,String email) throws MessagingException, UnsupportedEncodingException {
        try {
           Geo info= (Geo) geolocation;

            String toAddress = email;
            String fromAddress = "husseinyousf505@gmail.com";
            String senderName = "husseinyousf505@gmail.com";
            String subject = "this is the geoLocation for the address you requested";
            String content = "address [[address]],<br>"
                    + "lat [[lat]]:<br>"
                    + "lang [[lang]]:<br>";

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);

            content = content.replace("[[address]]",  info.getAddress());
            content = content.replace("[[lat]]", info.getLat().toString());

            content = content.replace("[[lang]]", info.getLongt().toString());

            helper.setText(content, true);

            mailSender.send(message);

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}
