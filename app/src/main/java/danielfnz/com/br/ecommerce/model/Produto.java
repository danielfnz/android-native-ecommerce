package danielfnz.com.br.ecommerce.model;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class Produto {
    private String nome;
    private float preco;
    private int quantidade;
    private int imagem;


    public Produto(String nome, float preco, int quantidade, int imagem) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
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
}
