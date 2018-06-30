package com.example.acdc.teste.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.acdc.teste.R;
import com.example.acdc.teste.activities.MusicaActivity;
import com.example.acdc.teste.model.Artista;
import com.example.acdc.teste.model.Musica;

import java.util.List;

public class ArtistaAdapter extends RecyclerView.Adapter<ArtistaAdapter.MyViewHolder> {
    private static final String EXTRA_DADOS = "dados";
    private List<Artista> listaArtistas;
    private Musica musica;

    public ArtistaAdapter(List<Artista> lista) {
        this.listaArtistas = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.celula_artista_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Artista artista = listaArtistas.get(position);
        holder.nomeDoArtista.setText(artista.getNome());
        holder.imagem.setImageResource(artista.getImagem());

        holder.nomeDoArtista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity(v);
                Intent intent = new Intent(activity, MusicaActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra(EXTRA_DADOS, artista);
                activity.startActivity(intent);
            }
        });

    }

    private Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return listaArtistas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nomeDoArtista;
        ImageView imagem;

        public MyViewHolder(View itemView) {
            super(itemView);

            nomeDoArtista = itemView.findViewById(R.id.textNomeArtista);
            imagem = itemView.findViewById(R.id.imagemArtista);
        }
    }

}
