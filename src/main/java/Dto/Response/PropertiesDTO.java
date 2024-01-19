package Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertiesDTO {
    private DatasourceDTO datasource;
    private String name;
    private String country;
    private String country_code;
    private String state;
    private String county;
    private String city;
    private double lon;
    private double lat;
    private String formatted;
    private String address_line1;
    private String address_line2;
    private String category;
    private TimezoneDTO timezone;
    private String plus_code;
    private String plus_code_short;
    private String result_type;
    private RankDTO rank;
    private String place_id;

    // Getters and setters
}
