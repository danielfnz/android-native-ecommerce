package danielfnz.com.br.ecommerce.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import danielfnz.com.br.ecommerce.R;
import danielfnz.com.br.ecommerce.adapter.ProdutoAdapter;
import danielfnz.com.br.ecommerce.model.Produto;
import danielfnz.com.br.ecommerce.service.ProdutoService;

public class Ecommerce extends Activity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        ProdutoService produtoService = new ProdutoService(firebaseDatabase, databaseReference);

        ListView lista = (ListView) findViewById(R.id.lista);
        List<Produto> produtos = produtoService.getProdutosList();

        if(produtos.isEmpty()) {
            View empty = findViewById(R.id.list_empty);
            lista.setEmptyView(empty);
        } else {
            ProdutoAdapter adapter =  new ProdutoAdapter(this, (ArrayList<Produto>) produtos);
            lista.setAdapter(adapter);
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(view.getContext(), ProductDescription.class);
                    startActivity(i);
                }
            });
        }
    }
}
