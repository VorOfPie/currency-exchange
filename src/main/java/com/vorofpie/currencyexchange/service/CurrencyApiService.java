package com.vorofpie.currencyexchange.service;

import com.vorofpie.currencyexchange.domain.CurrencyRate;

import java.time.LocalDate;

public interface CurrencyApiService {

    void loadRates(LocalDate date);

    CurrencyRate loadRateByCode(String currencyCode, LocalDate date);
}
