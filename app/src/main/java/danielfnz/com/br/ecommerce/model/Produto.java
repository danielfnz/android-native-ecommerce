package danielfnz.com.br.ecommerce.model;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class Produto {
    private String id;
    private String nome;
    private double preco;
    private int quantidade;
    private int imagem;
    private String descrição;

    public Produto() {

    }

    public Produto(String nome, double preco, int quantidade, int imagem, String descrição) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
        this.descrição = descrição;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
