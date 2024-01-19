package Dto;


import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneralListRequest implements Serializable {

    @Nullable
    private String search;

    @Nullable
    private Integer pageNumber;

    @Nullable
    private Integer pageSize;

}
