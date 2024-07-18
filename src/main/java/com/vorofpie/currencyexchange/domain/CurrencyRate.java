package com.vorofpie.currencyexchange.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "currency_rate")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Currency code cannot be null")
    @Size(min = 3, max = 3, message = "Currency code must be exactly 3 characters long")
    private String currencyCode;

    @NotNull(message = "Date cannot be null")
    private LocalDate date;

    @NotNull(message = "Rate cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Rate must be greater than 0")
    private double rate;

    @NotNull(message = "Scale cannot be null")
    @Min(value = 1, message = "Scale must be at least 1")
    private int scale;
}
