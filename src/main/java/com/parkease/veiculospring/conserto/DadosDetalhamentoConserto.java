package com.parkease.veiculospring.conserto;

public record DadosDetalhamentoConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marcaVeiculo,
        String modeloVeiculo
) {
    public DadosDetalhamentoConserto(Conserto c) {
        this(
                c.getId(),
                c.getDataEntrada(),
                c.getDataSaida(),
                c.getMecanico().getNome(),
                c.getVeiculo().getMarca(),
                c.getVeiculo().getModelo()
        );
    }
}
