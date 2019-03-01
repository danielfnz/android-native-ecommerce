package danielfnz.com.br.ecommerce.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.text.ParseException;

import danielfnz.com.br.ecommerce.R;
import danielfnz.com.br.ecommerce.model.Produto;

import static danielfnz.com.br.ecommerce.util.Util.CIFRA_DINHEIRO;
import static danielfnz.com.br.ecommerce.util.Util.formataVirgula;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompraProdutoDescricaoFragment extends Fragment {


    EditText editQuantidadeDeItens;
    TextView valorTotal;
    Produto produto;

    public CompraProdutoDescricaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compra_produto_descricao, container, false);

        produto = getArguments().getParcelable("produto");

        TextView preco = (TextView) view.findViewById(R.id.precoProdutoDetalhe);
                valorTotal = (TextView) view.findViewById(R.id.valorTotalProdutoDetalhe);

        editQuantidadeDeItens = (EditText) view.findViewById(R.id.editQuantidadeDeItens);
        editQuantidadeDeItens.setText("1");

        Button botaoDiminuirQuantidadeItens = (Button) view.findViewById(R.id.botaoDiminuir1Item),
                botaoAumentarQuantidadeItens = (Button) view.findViewById(R.id.botaoAumentar1Item),
                botaoLancarItem = (Button) view.findViewById(R.id.adicionarProdutoNoCarrinho);


        preco.setText(new StringBuilder(CIFRA_DINHEIRO).append(formataVirgula(produto.getPreco())));
        valorTotal.setText(new StringBuilder(CIFRA_DINHEIRO).append(formataVirgula(produto.getPreco())));

        botaoDiminuirQuantidadeItens.setOnClickListener(diminuirUmItem());
        botaoAumentarQuantidadeItens.setOnClickListener(aumentarUmItem());
        botaoLancarItem.setOnClickListener(lancarItemNoCarrinho());

        return view;
    }

    private View.OnClickListener lancarItemNoCarrinho() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
    }


    private View.OnClickListener diminuirUmItem() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editQuantidadeDeItens.getText().toString().equals("1")) {
                    editQuantidadeDeItens.setText(String.valueOf(Integer.parseInt(editQuantidadeDeItens.getText().toString()) - 1));
                    recalculaValores();
                }
            }
        };

    }



    private View.OnClickListener aumentarUmItem() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editQuantidadeDeItens.setText(String.valueOf(Integer.parseInt(editQuantidadeDeItens.getText().toString()) + 1));
                recalculaValores();
            }
        };
    }

    private void recalculaValores() {
         valorTotal.setText(new StringBuilder(CIFRA_DINHEIRO).append(formataVirgula(produto.getPreco() * Integer.parseInt(editQuantidadeDeItens.getText().toString()))).toString());
    }

}
