package com.vorofpie.currencyexchange.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record Rate(
        @NotNull(message = "Currency ID cannot be null")
        @Min(value = 1, message = "Currency ID must be at least 1")
        int Cur_ID,

        @NotNull(message = "Date cannot be null")
        LocalDate Date,

        @NotBlank(message = "Currency abbreviation cannot be blank")
        String Cur_Abbreviation,

        @NotNull(message = "Scale cannot be null")
        @Min(value = 1, message = "Scale must be at least 1")
        int Cur_Scale,

        @NotBlank(message = "Currency name cannot be blank")
        String Cur_Name,

        @NotNull(message = "Official rate cannot be null")
        @DecimalMin(value = "0.0", inclusive = false, message = "Official rate must be greater than 0")
        double Cur_OfficialRate
) {}
