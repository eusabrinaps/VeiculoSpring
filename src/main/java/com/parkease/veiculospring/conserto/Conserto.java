package com.parkease.veiculospring.conserto;

import com.parkease.veiculospring.mecanico.Mecanico;
import com.parkease.veiculospring.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consertos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEntrada;
    private String dataSaida;

    @Embedded
    private Mecanico mecanico;

    @Embedded
    private Veiculo veiculo;

    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanico = new Mecanico(dados.mecanico().nome(), dados.mecanico().anosExperiencia());
        this.veiculo = new Veiculo(dados.veiculo().marca(), dados.veiculo().modelo(), dados.veiculo().ano(), dados.veiculo().cor());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.dataSaida() != null) this.dataSaida = dados.dataSaida();
        String nome = dados.nomeMecanico() != null ? dados.nomeMecanico() : this.mecanico.getNome();
        Integer anos = dados.anosExperienciaMecanico() != null ? dados.anosExperienciaMecanico() : this.mecanico.getAnosExperiencia();
        this.mecanico = new Mecanico(nome, anos);
    }

    public void excluir() {
        this.ativo = false;
    }
}
