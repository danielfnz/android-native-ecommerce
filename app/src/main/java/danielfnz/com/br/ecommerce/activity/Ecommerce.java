package danielfnz.com.br.ecommerce.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import danielfnz.com.br.ecommerce.R;
import danielfnz.com.br.ecommerce.adapter.ProdutoAdapter;
import danielfnz.com.br.ecommerce.model.Produto;
import danielfnz.com.br.ecommerce.service.ProdutoService;

public class Ecommerce extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce);

        ProdutoService produtoList = new ProdutoService();

        ListView lista = (ListView) findViewById(R.id.lista);
        List<Produto> produtos = produtoList.getProdutosList();

        ProdutoAdapter adapter =  new ProdutoAdapter(this, (ArrayList<Produto>) produtos);
        lista.setAdapter(adapter);

        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (Integer) view.getTag();

                Intent i = new Intent(view.getContext(), ProductDescription.class);
                startActivity(i);
            }
        });
    }
}
