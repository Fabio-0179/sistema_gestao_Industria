package model;

public class Funcionario {

/*    private Integer idFuncionario;
    private String nome;
    private String sobrenome;
    private model.Setor setor;

    @Override
    public String toString() {
        return "{\n" +
                "  \"idFuncionario\": " + idFuncionario + ",\n" +
                "  \"nome\": \"" + nome + "\",\n" +
                "  \"sobrenome\": \"" + sobrenome + "\",\n" +
                "  \"setor\": " + setor + "\n" +
                "}";
    }*/


        private Integer idFuncionario;
        private String nome;
        private String sobrenome;
        private Integer idSetor; // Foreign key

        public Funcionario(Integer idFuncionario, String nome, String sobrenome, Integer idSetor) {
            this.idFuncionario = idFuncionario;
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.idSetor = idSetor;
        }

        public Funcionario(String nome, String sobrenome, Integer idSetor) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.idSetor = idSetor;
        }

        public Integer getIdFuncionario() {
            return idFuncionario;
        }

        public void setIdFuncionario(Integer idFuncionario) {
            this.idFuncionario = idFuncionario;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        public Integer getIdSetor() {
            return idSetor;
        }

        public void setIdSetor(Integer idSetor) {
            this.idSetor = idSetor;
        }

        @Override
        public String toString() {
            return "model.Funcionario{" +
                    "idFuncionario=" + idFuncionario +
                    ", nome='" + nome + '\'' +
                    ", sobrenome='" + sobrenome + '\'' +
                    ", idSetor=" + idSetor +
                    '}';
        }
    }



