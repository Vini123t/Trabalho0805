/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.mavenproject2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author vinid
 */
public class Mavenproject2 {

    public static void main(String[] args) {

        File pasta = new File("C:\\TestePasta");
        pasta.mkdir();

        File arquivo = new File(pasta.getAbsolutePath() + "\\TestArquivo.txt");

        if (arquivo.exists()) {
            System.out.println("Arquivo já existente");
        } else {
            try {

                if (arquivo.createNewFile()) {
                    System.out.println("Arquivo de texto criado");
                } else {
                    System.out.println("Falha ao criar o arquivo");
                }
            } catch (IOException ex) {
                System.out.println("Erro ao gerar arquivo: " + ex.getMessage());
            }
        }

        try (PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(arquivo)))) {
            for (int i = 1; i <= 10; i++) {
                escritor.println(i + " x 9 = " + (i * 9));
            }
            System.out.println("Tabuada do 9 foi escrita no arquivo");
        } catch (IOException ex) {
            System.out.println("Erro ao escrever no arquivo: " + ex.getMessage());
        }

        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo: " + ex.getMessage());
        }

        if (arquivo.delete()) {
            System.out.println("Arquivo excluído com sucesso");
        } else {
            System.out.println("Falha ao excluir o arquivo");
        }
    }
}
