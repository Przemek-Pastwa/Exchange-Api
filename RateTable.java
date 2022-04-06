package com.devopsi.akademia.exchangeapi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RateTable {

    public String table;
    public String no;
    public String effectiveDate;
    public List<Rate> rates = null;
}
