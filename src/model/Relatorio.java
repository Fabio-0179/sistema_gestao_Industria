package model;

public class Relatorio {
    // Campos genéricos para acomodar diferentes tipos de relatórios
    private String campo1; // Ex: Nome do Setor, Nome do Produto, Nome do Funcionário
    private String campo2; // Ex: Nome do Funcionário, Descrição do Produto, Sobrenome
    private String campo3; // Ex: Responsável, Nome do Setor, Data da Produção
    private Integer campoNumerico; // Ex: Quantidade, Total Produzido
    private String campo4; // Para detalhes adicionais, como nome do produto em um join

    // Construtor flexível para diferentes necessidades de relatório
    public Relatorio(String campo1, String campo2, String campo3, Integer campoNumerico, String campo4) {
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.campo3 = campo3;
        this.campoNumerico = campoNumerico;
        this.campo4 = campo4;
    }

    // Construtores específicos para facilitar a instanciação em cenários comuns
    public Relatorio(String campo1, String campo2) { // Ex: Setor, Funcionário
        this(campo1, campo2, null, null, null);
    }

    public Relatorio(String campo1, String campo2, String campo3) { // Ex: Produto, Data, Quantidade (ou Funcionario, Setor, Produto)
        this(campo1, campo2, campo3, null, null);
    }

    public Relatorio(String campo1, Integer campoNumerico) { // Ex: Funcionário, Total Produzido
        this(campo1, null, null, campoNumerico, null);
    }


    // Getters
    public String getCampo1() {
        return campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public Integer getCampoNumerico() {
        return campoNumerico;
    }

    public String getCampo4() {
        return campo4;
    }

    // Setters (se necessário, mas para relatórios geralmente são apenas leituras)
    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public void setCampoNumerico(Integer campoNumerico) {
        this.campoNumerico = campoNumerico;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Relatorio{");
        if (campo1 != null) sb.append("campo1='").append(campo1).append('\'');
        if (campo2 != null) sb.append(", campo2='").append(campo2).append('\'');
        if (campo3 != null) sb.append(", campo3='").append(campo3).append('\'');
        if (campoNumerico != null) sb.append(", campoNumerico=").append(campoNumerico);
        if (campo4 != null) sb.append(", campo4='").append(campo4).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

