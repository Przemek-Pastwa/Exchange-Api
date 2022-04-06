package com.devopsi.akademia.exchangeapi;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.Writer;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service

public class CsvExportService implements ExportService{

    private static final Logger log = getLogger(CsvExportService.class);

    @Override
    public List<Rate> writeToFile(Writer writer, RateTable rateTable) {
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            rateTable.getRates().forEach((rate) ->  {
                try {
                    csvPrinter.printRecord(
                            rate.getCurrency(),
                            rate.getCode(),
                            rate.getMid()
                    );
                } catch (IOException e) {
                    log.error("Error file writing CSV", e);
                }
            }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
