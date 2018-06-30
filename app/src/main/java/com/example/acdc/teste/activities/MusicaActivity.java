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
import com.example.acdc.teste.adapter.MusicaAdapter;
import com.example.acdc.teste.model.Musica;
import com.example.acdc.teste.model.Artista;

import java.util.ArrayList;
import java.util.List;


public class MusicaActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMusicas;
    private List<Musica> listaMusicas = new ArrayList<>();

    Musica musica;
    Artista artista;

    private static final String EXTRA_DADOS = "dados";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        recyclerViewMusicas = findViewById(R.id.recyclerViewMusicas);

        //RECEBENDO OBJETOS DE OUTRA ACTIVITY
        Bundle dados = getIntent().getExtras();
        artista =(Artista) dados.getParcelable(EXTRA_DADOS);

        //chamada da nossa implementação
        MusicaAdapter adapter = new MusicaAdapter(listaMusicas);

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewMusicas.setLayoutManager(layoutManager);
        recyclerViewMusicas.setHasFixedSize(true);
        recyclerViewMusicas.addItemDecoration( new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerViewMusicas.setAdapter( adapter );

    }

}
