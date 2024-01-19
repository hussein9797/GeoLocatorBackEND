package Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class ResponseDTO {
    private String type;
    private FeatureDTO[] features;
    private QueryDTO query;

    // Getters and setters
}