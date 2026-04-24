package com.parkease.veiculospring.conserto;

import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data deve estar no formato dd/MM/yyyy")
        String dataSaida,

        String nomeMecanico,
        Integer anosExperienciaMecanico

) {}
