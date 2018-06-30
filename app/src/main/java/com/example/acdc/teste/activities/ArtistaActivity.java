package com.example.acdc.teste.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


import com.example.acdc.teste.R;
import com.example.acdc.teste.adapter.ArtistaAdapter;
import com.example.acdc.teste.model.Artista;
import com.example.acdc.teste.model.Musica;

import java.util.ArrayList;
import java.util.List;

public class ArtistaActivity extends AppCompatActivity {

    private RecyclerView recyclerViewArtistas;
    private List<Artista> listaMusicas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artista);

        recyclerViewArtistas = findViewById(R.id.recyclerViewArtistas);

        //chamada da nossa implementação
        ArtistaAdapter adapter = new ArtistaAdapter(listaMusicas);
        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewArtistas.setLayoutManager(layoutManager);
        recyclerViewArtistas.setHasFixedSize(true);
        recyclerViewArtistas.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewArtistas.setAdapter( adapter );

        criarArtistas();

    }
    public void criarArtistas(){
        Artista capitalInicial = new Artista("Capital Inicial", R.drawable.capital );
        listaMusicas.add(capitalInicial);
        Musica musica1 = new Musica("Não olhe pra trás");
        capitalInicial.addMusica(musica1);
        Musica musica2 = new Musica("Primeiros erros");
        capitalInicial.addMusica(musica2);
        Musica musica3 = new Musica("A sua maneira");
        capitalInicial.addMusica(musica3);
        Musica musica4 = new Musica("Primeiros erros");
        capitalInicial.addMusica(musica4);

        Artista acdc = new Artista("AC/DC", R.drawable.ac_dc);
        listaMusicas.add(acdc);
        Artista coldplay = new Artista("Coldplay", R.drawable.coldplay);
        listaMusicas.add(coldplay);
        Artista ImagineDragons = new Artista("Imagine Dragons",R.drawable.imagine_dragons);
        listaMusicas.add(ImagineDragons);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_busca, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.busca_menu) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
