package danielfnz.com.br.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import danielfnz.com.br.ecommerce.R;
import danielfnz.com.br.ecommerce.model.Produto;

/**
 * Created by Alunoinf_2 on 02/02/2019.
 */

public class ProdutoAdapter  extends ArrayAdapter<Produto> {

    private final Context context;
    private final ArrayList<Produto> elementos;

    public ProdutoAdapter(Context context, ArrayList<Produto>elementos){
        super(context, R.layout.item, elementos);
        this.context = context;
        this.elementos = elementos;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item,parent,false);

        TextView nomeProduto = (TextView) rowView.findViewById(R.id.nomeProduto);
        TextView preco = (TextView) rowView.findViewById(R.id.preco);
        TextView qtdEstoque = (TextView) rowView.findViewById(R.id.qntEstoque);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);

        nomeProduto.setText(elementos.get(position).getNome());
        preco.setText(Double.toString(elementos.get(position).getPreco()));
        qtdEstoque.setText(Integer.toString(elementos.get(position).getQuantidade()) + " em estoque");
        imagem.setImageResource(elementos.get(position).getImagem());


        return rowView;
    }

}
