package com.vorofpie.currencyexchange.service.impl;

import com.vorofpie.currencyexchange.domain.CurrencyRate;
import com.vorofpie.currencyexchange.dto.Rate;
import com.vorofpie.currencyexchange.exception.NoCurrencyRatesFoundException;
import com.vorofpie.currencyexchange.mapper.CurrencyRateMapper;
import com.vorofpie.currencyexchange.repository.CurrencyRateRepository;
import com.vorofpie.currencyexchange.service.CurrencyApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyApiServiceImpl implements CurrencyApiService {

    private static final String API_URL = "https://api.nbrb.by/exrates/rates?ondate={date}&periodicity=0";

    private final RestTemplate restTemplate;
    private final CurrencyRateRepository currencyRateRepository;

    @Override
    public void loadRates(LocalDate date) {
        String url = API_URL.replace("{date}", date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        Rate[] rates = restTemplate.getForObject(url, Rate[].class);
        if (rates != null && rates.length > 0) {
            List<Rate> rateList = Arrays.asList(rates);
            rateList.forEach(rate -> {
                CurrencyRate currencyRate = CurrencyRateMapper.INSTANCE.toEntity(rate);
                currencyRateRepository.save(currencyRate);
            });
        } else {
            String message = "No currency rates found for date: " + date;
            throw new NoCurrencyRatesFoundException(message);
        }
    }
}
