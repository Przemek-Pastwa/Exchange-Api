package com.devopsi.akademia.exchangeapi;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/nbp")
@AllArgsConstructor

public class ExchangeApiController {


    private final ExchangeApiService exchangeApiService;
    private final ExchangeService exchangeService;
    private final ExchangeCurrencyService exchangeCurrencyService;

    @GetMapping("/rates")
    public ResponseEntity<List<Rate>> getAllRates() {
        return ResponseEntity.ok(exchangeApiService.getAllRates());
    }

    @GetMapping ("toCsv")
    public ResponseEntity<Void> writeToFile(HttpServletResponse servletResponse, String date) {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=rates.csv");
        try{
            exchangeService.createCsvFile(servletResponse.getWriter(), date);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }
    //Bez pełnej funkcjonalniości ale już coś liczy :) (przelicza z PLN na inne waluty)
    @GetMapping("/exchange/{toCode}/{quantity}")
    ResponseEntity<BigDecimal> calculate(
            @PathVariable(value = "toCode") final String toCode,
            @PathVariable(value = "quantity") final BigDecimal quantity){
        List<Rate> rates = exchangeService.getAllRates();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exchangeCurrencyService.calculateRate(rates,toCode,quantity));

    }
}

