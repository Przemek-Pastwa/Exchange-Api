package com.devopsi.akademia.exchangeapi;

import java.io.Writer;
import java.util.List;

public interface ExportService {

    List<Rate> writeToFile(Writer writer, RateTable rateTable);

}
