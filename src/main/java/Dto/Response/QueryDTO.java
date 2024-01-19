package Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryDTO {
    private String text;
    private ParsedDTO parsed;

    // Getters and setters
}
