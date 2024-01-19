package Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.ALWAYS)
@AllArgsConstructor
@Getter
public class MessageDto {
    private Integer code;
    private String message;
}
