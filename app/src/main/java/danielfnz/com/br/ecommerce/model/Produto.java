package danielfnz.com.br.ecommerce.model;

import java.util.Random;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private int imagem;
    private String descrição;

    public Produto(String nome, double preco, int quantidade, int imagem, String descrição) {
        this.id = generateId();
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
        this.descrição = descrição;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public int generateId() {
        int leftLimit = 1;
        int rightLimit = 100;
        return leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
    }
}
