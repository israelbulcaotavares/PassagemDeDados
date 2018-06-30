package com.example.acdc.teste.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acdc.teste.R;
import com.example.acdc.teste.activities.ReprodutorActivity;
import com.example.acdc.teste.model.Musica;

import java.util.List;

public class MusicaAdapter extends RecyclerView.Adapter<MusicaAdapter.MyViewHolder> {
    private static final String EXTRA_DADOS = "dados";
    private List<Musica> listaMusica;

    public MusicaAdapter(List<Musica> lista) {
        this.listaMusica = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.celula_musica_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Musica musica = listaMusica.get( position );

       holder.nomeDaMusica.setText( musica.getNome() );
       holder.nomeDaMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity(v);
                Intent intent = new Intent(activity, ReprodutorActivity.class);

               intent.putExtra(EXTRA_DADOS, musica);
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
        return listaMusica.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nomeDaMusica;

        public MyViewHolder(View itemView) {
            super(itemView);
            nomeDaMusica = itemView.findViewById(R.id.textNomeDaMusica);

        }
    }

}
