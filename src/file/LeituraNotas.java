package file;

import java.io.*;

public class LeituraNotas {
    public static void main(String[] args) {

        String caminho = "D:\\BD\\backup\\backup dia 02Jul\\industria\\src\\file\\notas.txt";

        File arquivo = new File(caminho);

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            Integer qtdLinhas = 0;
            Double soma = 0.0, media = 0.0;


            while ((linha = br.readLine()) !=null){
                String [] colunas = linha.split(",");
                soma += Double.parseDouble(colunas[1]);
                qtdLinhas++;
            }
            media = soma/qtdLinhas;
            System.out.println("Media das notas da turma: "+ media);

        }catch (FileNotFoundException e) {
            System.out.println("Erro Arquivo Não encontrado");

        }catch (IOException e){
            System.out.println("Erro não foi possivel ler o arquivo");
        }


        }
    }

