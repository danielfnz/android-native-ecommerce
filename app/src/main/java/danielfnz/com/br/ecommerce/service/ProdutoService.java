package danielfnz.com.br.ecommerce.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    public ProdutoService(FirebaseDatabase firebaseDatabase, DatabaseReference databaseReference) {
        this.firebaseDatabase = firebaseDatabase;
        this.databaseReference = databaseReference;
        this.getProdutos();
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

    public void getProdutos() {
        databaseReference.child("produtos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produtosList.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Produto p = objSnapshot.getValue(Produto.class);
                    produtosList.add(p);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

   public void gerarProdutos() {
//        this.addProduto(new Produto("ALFACE CRESPA VERDE ORGÂNICA", 2.5, 50, R.drawable.alface, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "));
//        this.addProduto(new Produto("ABÓBORA JAPONESA ORGÂNICA 600G", 3.5, 50, R.drawable.abobora1, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "));
//        this.addProduto(new Produto("ABÓBORA BRASILEIROA ORGÂNICA 600G", 2.5, 50, R.drawable.abobora2, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "));
//        this.addProduto(new Produto("AGRIÃO ORGÂNICO", 2.5, 50, R.drawable.agriao, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "));
//        this.addProduto(new Produto("BANANA PRATA ORGÂNICA", 2.5, 50, R.drawable.banana, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "));
//        this.addProduto(new Produto("TOMATE ORGANICO", 5.0, 50, R.drawable.tomate, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt! "));
    }

    public void addProduto(Produto produto) {
        databaseReference.child("produtos").child(produto.getId()).setValue(produto);
    }

    public DatabaseReference getFirebaseDatabase() {
        return this.firebaseDatabase.getReference();
    }

}
