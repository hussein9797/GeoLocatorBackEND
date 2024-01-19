package Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.With;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@With
public class LocateAddressReq implements Serializable {

    String address;
    String mail;
    Double lat;
    Double lang;

}
