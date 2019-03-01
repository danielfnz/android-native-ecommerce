package danielfnz.com.br.ecommerce.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import danielfnz.com.br.ecommerce.R;
import danielfnz.com.br.ecommerce.adapter.DescricaoProdutoPageAdapter;
import danielfnz.com.br.ecommerce.model.Produto;
import danielfnz.com.br.ecommerce.util.Util;

import static danielfnz.com.br.ecommerce.util.Util.CIFRA_DINHEIRO;
import static danielfnz.com.br.ecommerce.util.Util.formataVirgula;

public class ProductDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ImageView imagem = (ImageView) findViewById(R.id.imgProdutoDetalhe);
        TextView preco = (TextView) findViewById(R.id.precoProdutoDetalhe),
        quantidade = (TextView) findViewById(R.id.quantidadeProdutoDetalhe),
        nome = (TextView) findViewById(R.id.nomeProdutoDescricao);

        Produto produto = new Produto("ALFACE CRESPA VERDE ORGÂNICA", 2.5, 50, R.drawable.alface,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad aspernatur culpa deleniti, eaque eligendi est ipsum sed. Ab enim fugiat laudantium quaerat, quis reiciendis reprehenderit saepe suscipit voluptates. Dignissimos, nesciunt!"
        );

        imagem.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Util.dpToPx(this, 120)));
        imagem.setImageResource(produto.getImagem());
        preco.setText(new StringBuilder(CIFRA_DINHEIRO).append(formataVirgula(produto.getPreco())));
        quantidade.setText(String.valueOf(produto.getQuantidade()));
        nome.setText(produto.getNome());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.addTab(tabLayout.newTab().setText("COMPRAR"));
        tabLayout.addTab(tabLayout.newTab().setText("DESCRICAO"));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        DescricaoProdutoPageAdapter pageAdapter = new DescricaoProdutoPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), produto);
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
