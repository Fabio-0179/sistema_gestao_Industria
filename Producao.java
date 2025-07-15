package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.time.LocalDate;


/*
public class model.Producao {


        private Integer idProducao;
        private model.Produto produto;
        private model.Funcionario funcionario;
        private LocalDate dataProducao;
        private Integer quantidade;

        @Override
        public String toString() {
            return "{\n" +
                    "  \"idProducao\": " + idProducao + ",\n" +
                    "  \"model.Produto\": \"" + produto + "\",\n" +
                    "  \"funcionario\": \"" + funcionario + "\",\n" +
                    "  \"quantidade\": \"" + quantidade + "\",\n" +
                    "  \"dataProducao\": \"" + dataProducao + "\",\n" +
                    "}";
        }

}*/


public class Producao {
        private Integer idProducao;
        private Integer idProdutos; // Foreign key
        private Integer idFuncionario; // Foreign key
        private String dataProducao;
        private Integer quantidade;

        public Producao(Integer idProducao, Integer idProdutos, Integer idFuncionario, String dataProducao, Integer quantidade) {
                this.idProducao = idProducao;
                this.idProdutos = idProdutos;
                this.idFuncionario = idFuncionario;
                this.dataProducao = dataProducao;
                this.quantidade = quantidade;
        }

        public Producao(Integer idProdutos, Integer idFuncionario, String dataProducao, Integer quantidade) {
                this.idProdutos = idProdutos;
                this.idFuncionario = idFuncionario;
                this.dataProducao = dataProducao;
                this.quantidade = quantidade;
        }

        public Integer getIdProducao() {
                return idProducao;
        }

        public void setIdProducao(Integer idProducao) {
                this.idProducao = idProducao;
        }

        public Integer getIdProdutos() {
                return idProdutos;
        }

        public void setIdProdutos(Integer idProdutos) {
                this.idProdutos = idProdutos;
        }

        public Integer getIdFuncionario() {
                return idFuncionario;
        }

        public void setIdFuncionario(Integer idFuncionario) {
                this.idFuncionario = idFuncionario;
        }

        public String getDataProducao() {
                return dataProducao;
        }

        public void setDataProducao(String dataProducao) {
                this.dataProducao = dataProducao;
        }

        public Integer getQuantidade() {
                return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
                this.quantidade = quantidade;
        }

        @Override
        public String toString() {
                return "model.Producao{" +
                        "idProducao=" + idProducao +
                        ", idProdutos=" + idProdutos +
                        ", idFuncionario=" + idFuncionario +
                        ", dataProducao='" + dataProducao + '\'' +
                        ", quantidade=" + quantidade +
                        '}';
        }
}
