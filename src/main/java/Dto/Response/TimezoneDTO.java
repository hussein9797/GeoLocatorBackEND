package Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimezoneDTO {
    private String name;
    private String offset_STD;
    private int offset_STD_seconds;
    private String offset_DST;
    private int offset_DST_seconds;
    private String abbreviation_STD;
    private String abbreviation_DST;

    // Getters and setters
}