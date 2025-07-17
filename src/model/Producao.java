package model;

import java.time.LocalDate;

public class Producao {

    private Integer idProducao;
    private Integer quantidade;
    private String dataProducao;
    private Produto produtos;
    private Funcionario funcionario;
    

    public Producao(Integer idProducao, Integer quantidade, String dataProducao, Produto produtos, Funcionario funcionario) {
        this.idProducao = idProducao;
        this.quantidade = quantidade;
        this.dataProducao = dataProducao;
        this.produtos = produtos;
        this.funcionario = funcionario;
    }

    public Producao() {
    }

    public Producao(Integer id1, Integer id2, Integer id3, String dataproducao, Integer qtde) {
    }

    public Producao(Integer id, Produto produto, Funcionario funcionario, LocalDate data, Integer quantidade) {
    }

    public Producao(Object o, String nome, String responsavel) {
    }


    @Override
    public String toString() {
        return "model.Producao{" +
                "idProducao=" + idProducao +
                ", quantidade=" + quantidade +
                ", dataProducao='" + dataProducao + '\'' +
                ", produtos=" + produtos +
                ", funcionario=" + funcionario +
                '}';
    }

    public Produto getProduto() {
        return null;
    }

    public LocalDate getData() {
        return null;
    }

    public int getQuantidade() {
        return 0;
    }

    public int getId() {
        return 0;
    }

    public void setId(int idProducao) {
    }

    public void setData(LocalDate dataProducao) {
    }

    public void setQuantidade(int quantidade) {

    }
}
