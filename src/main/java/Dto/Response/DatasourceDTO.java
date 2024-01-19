package Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatasourceDTO {
    private String sourcename;
    private String attribution;
    private String license;
    private String url;

    // Getters and setters
}
