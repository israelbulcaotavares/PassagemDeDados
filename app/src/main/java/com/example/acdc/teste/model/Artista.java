package com.example.acdc.teste.model;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.acdc.teste.R;

import java.util.ArrayList;
import java.util.List;

public class Artista  implements Parcelable {
    public String nome;
    public int imagem;
    private List<Musica> listaMusicas = new ArrayList<>();

    public Artista(String nome, int imagem, List<Musica> listaMusicas) {
        this.nome = nome;
        this.imagem = imagem;
        this.listaMusicas = listaMusicas;
    }

    public Artista() {
    }

    public Artista(String nome,  int imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }

    protected Artista(Parcel in) {
        nome = in.readString();
        imagem = in.readInt();
        listaMusicas = in.createTypedArrayList(Musica.CREATOR);
    }

    public static final Creator<Artista> CREATOR = new Creator<Artista>() {
        @Override
        public Artista createFromParcel(Parcel in) {
            return new Artista(in);
        }

        @Override
        public Artista[] newArray(int size) {
            return new Artista[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(imagem);
        dest.writeTypedList(listaMusicas);
    }

    public void addMusica(Musica musica) {
            listaMusicas.add(musica);
        }

}
