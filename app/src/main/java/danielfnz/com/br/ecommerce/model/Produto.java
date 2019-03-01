package danielfnz.com.br.ecommerce.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class Produto implements Parcelable {
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

    protected Produto(Parcel in) {
        id = in.readString();
        nome = in.readString();
        preco = in.readDouble();
        quantidade = in.readInt();
        imagem = in.readInt();
        descrição = in.readString();
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(nome);
        parcel.writeDouble(preco);
        parcel.writeInt(quantidade);
        parcel.writeInt(imagem);
        parcel.writeString(descrição);
    }


}
