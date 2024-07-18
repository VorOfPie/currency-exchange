package com.vorofpie.currencyexchange.mapper;

import com.vorofpie.currencyexchange.domain.CurrencyRate;
import com.vorofpie.currencyexchange.dto.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyRateMapper {
    CurrencyRateMapper INSTANCE = Mappers.getMapper(CurrencyRateMapper.class);

    @Mapping(source = "Cur_Abbreviation", target = "currencyCode")
    @Mapping(source = "Date", target = "date")
    @Mapping(source = "Cur_OfficialRate", target = "rate")
    @Mapping(source = "Cur_Scale", target = "scale")
    CurrencyRate toEntity(Rate rate);
}
