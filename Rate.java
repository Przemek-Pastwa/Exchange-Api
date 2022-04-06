package com.devopsi.akademia.exchangeapi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Rate {

    private String currency;
    private String code;
    private Float mid;
}
