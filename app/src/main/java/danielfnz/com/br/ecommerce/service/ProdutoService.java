package danielfnz.com.br.ecommerce.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import danielfnz.com.br.ecommerce.R;
import danielfnz.com.br.ecommerce.model.Produto;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class ProdutoService {

    private ArrayList<Produto> produtosList = new ArrayList<Produto>();


    public ProdutoService() {
        this.produtosList = this.generateList();
    }

    public Produto getProdutoById(int id) {
        return this.produtosList.get(id);
    }

    public ArrayList<Produto> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(ArrayList<Produto> produtosList) {
        this.produtosList = produtosList;
    }

    public ArrayList<Produto> generateList() {
        return new ArrayList<>(Arrays.asList(
                new Produto("ALFACE CRESPA VERDE ORGÂNICA",2.5, 50, R.drawable.alface, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "),
                new Produto("ABÓBORA JAPONESA ORGÂNICA 600G",3.5, 50, R.drawable.abobora1, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "),
                new Produto("ABÓBORA BRASILEIROA ORGÂNICA 600G",2.5, 50, R.drawable.abobora2, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "),
                new Produto("AGRIÃO ORGÂNICO",2.5, 50, R.drawable.agriao, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "),
                new Produto("BANANA PRATA ORGÂNICA",2.5, 50, R.drawable.banana, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "),
                new Produto("BERINjELA ORGÂNICA",2.5, 50, R.drawable.berinjela, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! ")
                ));
    }
}
