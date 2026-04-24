package com.parkease.veiculospring.conserto;

import com.parkease.veiculospring.mecanico.Mecanico;
import com.parkease.veiculospring.veiculo.Veiculo;

public record DadosListagemConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        DadosMecanico mecanico,
        DadosVeiculo veiculo,
        Boolean ativo
) {
    public DadosListagemConserto(Conserto c) {
        this(
                c.getId(),
                c.getDataEntrada(),
                c.getDataSaida(),
                new DadosMecanico(c.getMecanico()),
                new DadosVeiculo(c.getVeiculo()),
                c.getAtivo()
        );
    }

    public record DadosMecanico(String nome, Integer anosExperiencia) {
        public DadosMecanico(Mecanico m) {
            this(m.getNome(), m.getAnosExperiencia());
        }
    }

    public record DadosVeiculo(String marca, String modelo, String ano, String cor) {
        public DadosVeiculo(Veiculo v) {
            this(v.getMarca(), v.getModelo(), v.getAno(), v.getCor());
        }
    }
}
