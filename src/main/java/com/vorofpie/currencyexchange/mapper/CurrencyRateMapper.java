package com.vorofpie.currencyexchange.mapper;

import com.vorofpie.currencyexchange.domain.CurrencyRate;
import com.vorofpie.currencyexchange.dto.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyRateMapper {
    CurrencyRateMapper INSTANCE = Mappers.getMapper(CurrencyRateMapper.class);

    CurrencyRate toEntity(Rate rate);

    Rate toDto(CurrencyRate currencyRate);
}
