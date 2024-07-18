package com.vorofpie.currencyexchange.controller;

import com.vorofpie.currencyexchange.domain.CurrencyRate;
import com.vorofpie.currencyexchange.service.CurrencyApiService;
import com.vorofpie.currencyexchange.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/currency")
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyApiService currencyApiService;
    private final CurrencyRateService currencyRateService;

    @PostMapping("/load")
    public ResponseEntity<String> loadRates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        currencyApiService.loadRates(date);
        return ResponseEntity.ok("Data loaded successfully for date: " + date);
    }

    @GetMapping("/rate")
    public ResponseEntity<CurrencyRate> getRate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                @RequestParam String currencyCode) {
        Optional<CurrencyRate> rateOptional = currencyRateService.getRateByDateAndCode(date, currencyCode);
        return rateOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
