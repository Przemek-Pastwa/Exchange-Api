package com.devopsi.akademia.exchangeapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Writer;
import java.util.List;

import static com.devopsi.akademia.exchangeapi.DateTime.getCurrentDate;

@Service
@RequiredArgsConstructor
public class ExchangeApiService implements ExchangeService {

    private final NbpClientService nbpClientService;
    private final ExportService exportService;


    @Override
    public List<Rate> getAllRates() {
        return nbpClientService.getForRates().getRates();
    }

    @Override
    public void createCsvFile(Writer writer, String date) {
        String queryDate = date != null ? date : getCurrentDate();
        exportService.writeToFile(writer, nbpClientService.getForRatesDate(queryDate));
    }
}
