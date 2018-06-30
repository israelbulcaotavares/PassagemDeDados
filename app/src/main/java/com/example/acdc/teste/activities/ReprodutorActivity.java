package com.example.acdc.teste.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acdc.teste.R;
import com.example.acdc.teste.model.Artista;
import com.example.acdc.teste.model.Musica;


public class ReprodutorActivity extends AppCompatActivity {
    private static final String EXTRA_DADOS = "dados";
    private Artista artista;
    private Musica musica;
   private ImageView imageArtista;
    private TextView textNomeArtista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageArtista = findViewById(R.id.imageArtista);
        textNomeArtista = findViewById(R.id.textNomeArtista);


        //RECEBENDO OBJETOS DE OUTRA ACTIVITY
         Bundle dados2 = getIntent().getExtras();
        musica =(Musica)dados2.getParcelable(EXTRA_DADOS);

        //Recuperar dados
        textNomeArtista.setText(musica.getNome());
        //imageArtista.setImageResource(artista.getImagem());
    }

    public void irParaLista(View view){
        Intent intent = new Intent(ReprodutorActivity.this, MusicaActivity.class);
       // intent.putExtra(EXTRA_DADOS, new Musica());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

        if (id == R.id.lista_menu) {
            irParaLista();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

  private void irParaLista(){
      Intent intent = new Intent(ReprodutorActivity.this, ArtistaActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      startActivity(intent);
  }

}
