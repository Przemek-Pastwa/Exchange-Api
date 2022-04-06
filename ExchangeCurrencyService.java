package com.devopsi.akademia.exchangeapi;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExchangeCurrencyService {

    public BigDecimal calculateRate(List<Rate> rates, String toCode, BigDecimal quantity){
        Rate Currency = rates.stream()
                .filter(rate -> toCode.equals(rate.getCode()))
                .findAny()
                .orElse(null);
        assert Currency != null;
        BigDecimal calculate = (quantity.multiply(BigDecimal.valueOf(Currency.getMid())));
        return calculate;
    }
}
