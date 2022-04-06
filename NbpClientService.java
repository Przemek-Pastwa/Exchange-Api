package com.devopsi.akademia.exchangeapi;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;


@Service

public class NbpClientService {


    public RateTable getForRates() {
        String Url = "http://api.nbp.pl/api/exchangerates/tables/a/";
        RestTemplate restTemplate = new RestTemplate();
        RateTable[] rateTable = restTemplate.getForObject(Url, RateTable[].class);
        assert rateTable != null;
        return Arrays.stream(rateTable).findFirst().orElseThrow();
    }

    public RateTable getForRatesDate(String date) {
        String Url = "http://api.nbp.pl/api/exchangerates/tables/a/";
        RestTemplate restTemplate = new RestTemplate();
        RateTable[] rateTable = restTemplate.getForObject(Url + date, RateTable[].class);
        assert rateTable != null;
        return Arrays.stream(rateTable).findFirst().orElseThrow();
    }

}