package com.vorofpie.currencyexchange.service.impl;

import com.vorofpie.currencyexchange.domain.CurrencyRate;
import com.vorofpie.currencyexchange.repository.CurrencyRateRepository;
import com.vorofpie.currencyexchange.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyRateServiceImpl implements CurrencyRateService {


    private final CurrencyRateRepository rateRepository;

    @Override
    public CurrencyRate saveRate(CurrencyRate currencyRate) {
        return rateRepository.save(currencyRate);
    }

    @Override
    public Optional<CurrencyRate> getRateByDateAndCode(LocalDate date, String currencyCode) {
        return rateRepository.findByDateAndCurrencyCode(date, currencyCode);
    }
}
