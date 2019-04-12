package br.ufjf.dcc196.exemplo6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> palavras = new ArrayList<String>(){{
        add("Um");
        add("Segundo");
        add("Três");
        add("Quadro");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rvPalavras);

        PalavraAdapter pAdapter = new PalavraAdapter(this.palavras);
        rv.setAdapter(pAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        pAdapter.setOnpalabraClickListener(new PalavraAdapter.OnPalavraClickListener() {
            @Override
            public void onPalavraClick(View v, int adapterPosition) {
                Toast.makeText(MainActivity.this, palavras.get(adapterPosition) , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
