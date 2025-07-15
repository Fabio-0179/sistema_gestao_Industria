package model;

public class Produto {

        public Integer getIdProdutos() {
                return idProdutos;
        }

        public void setIdProdutos(Integer idProdutos) {
                this.idProdutos = idProdutos;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        private Integer idProdutos;
        private String nome;
        private String descricao;

        public Produto(Integer idProdutos, String nome, String descricao) {
                this.idProdutos = idProdutos;
                this.nome = nome;
                this.descricao = descricao;
        }

        public Produto() {
        }

        @Override
        public String toString() {
            return "{\n" +
                    "  \"idProdutos\": " + idProdutos + ",\n" +
                    "  \"nome\": \"" + nome + "\",\n" +
                    "  \"descricao\": \"" + descricao + "\",\n" +
                    "}";
        }
}
