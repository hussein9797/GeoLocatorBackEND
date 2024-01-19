package Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RankDTO {
    private double importance;
    private double popularity;
    private int confidence;
    private int confidence_city_level;
    private String match_type;

    // Getters and setters
}
