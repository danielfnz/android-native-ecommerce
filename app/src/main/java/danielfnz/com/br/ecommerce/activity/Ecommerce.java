package danielfnz.com.br.ecommerce.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
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

    public static final int REQUEST_CODE = 100;
    public static final int PERMISSION_REQUEST = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecommerce);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
        }

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
        Button button = (Button) findViewById(R.id.botao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ecommerce.this, ScannerActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        startActivity(new Intent(this, ProductDescription.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.leitor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.abrirLeitor) {
            Intent intent = new Intent(this, ScannerActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            if(data != null) {
                Barcode barcode = data.getParcelableExtra("barcode");
                Toast.makeText(this, barcode.displayValue, Toast.LENGTH_LONG).show();
            }
        }
    }
}
