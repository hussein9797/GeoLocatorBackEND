package Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureDTO {
    private String type;
    private PropertiesDTO properties;
    private GeometryDTO geometry;
    private double[] bbox;

    // Getters and setters
}