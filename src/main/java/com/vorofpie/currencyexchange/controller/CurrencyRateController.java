package com.vorofpie.currencyexchange.controller;

import com.vorofpie.currencyexchange.domain.CurrencyRate;
import com.vorofpie.currencyexchange.service.CurrencyApiService;
import com.vorofpie.currencyexchange.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyRateController {

    private final CurrencyApiService currencyApiService;
    private final CurrencyRateService currencyRateService;

    @GetMapping("/load")
    public String showLoadPage() {
            return "load";
    }

    @PostMapping("/load")
    public String loadRates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                            Model model) {
        currencyApiService.loadRates(date);
        model.addAttribute("message", "Data loaded successfully for date: " + date);
        return "load";
    }

    @GetMapping("/rate")
    public String getRate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                          @RequestParam String currencyCode,
                          Model model) {
        Optional<CurrencyRate> rateOptional = currencyRateService.getRateByDateAndCode(date, currencyCode);
        if (rateOptional.isPresent()) {
            model.addAttribute("rate", rateOptional.get());
        } else {
            model.addAttribute("message", "Rate not found for date: " + date + " and currency code: " + currencyCode);
        }
        return "rate";
    }
}
