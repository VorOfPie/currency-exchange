package com.vorofpie.currencyexchange.service;

import com.vorofpie.currencyexchange.domain.CurrencyRate;

import java.time.LocalDate;
import java.util.Optional;

public interface CurrencyRateService {

    CurrencyRate saveRate(CurrencyRate currencyRate);

    Optional<CurrencyRate> getRateByDateAndCode(LocalDate date, String currencyCode);
}
