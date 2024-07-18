package com.vorofpie.currencyexchange.service;

import java.time.LocalDate;

public interface CurrencyApiService {

    void loadRates(LocalDate date);

}
