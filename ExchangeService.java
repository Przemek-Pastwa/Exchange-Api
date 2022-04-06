package com.devopsi.akademia.exchangeapi;

import java.io.Writer;
import java.util.List;

public interface ExchangeService {

    List<Rate> getAllRates();
    void createCsvFile(Writer writer, String date);
}
