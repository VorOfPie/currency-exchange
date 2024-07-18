package com.vorofpie.currencyexchange.repository;

import com.vorofpie.currencyexchange.domain.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
    Optional<CurrencyRate> findByDateAndCurrencyCode(LocalDate date, String currencyCode);
}
