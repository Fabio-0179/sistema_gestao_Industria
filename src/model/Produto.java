package model;

public class Produto {


    private Integer idProdutos;
    private String nomeProduto;
    private String descricao;

    public Produto(Integer idProdutos, String nomeProduto, String descricao) {
        this.idProdutos = idProdutos;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    public Produto() {
    }

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "{" +
                "\"idProdutos\":" + idProdutos + "," +
                "\"nomeProduto\":\"" + nomeProduto + "\"," +
                "\"descricao\":\"" + descricao + "\"" +
                "}";
    }

    public String getNome() {
        return null;
    }

    public int getId() {
        return 0;
    }

    public void setNome(String nome) {
    }

    public void setResponsavel(String responsavel) {
    }

    public void setId(int idProdutos) {

    }
}


