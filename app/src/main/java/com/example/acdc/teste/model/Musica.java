package com.example.acdc.teste.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Musica  implements Parcelable {
    public String nome;

    public Musica() {
    }

    public Musica(String nome) {
        this.nome = nome;
    }

    protected Musica(Parcel in) {
        nome = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Musica> CREATOR = new Creator<Musica>() {
        @Override
        public Musica createFromParcel(Parcel in) {
            return new Musica(in);
        }

        @Override
        public Musica[] newArray(int size) {
            return new Musica[size];
        }
    };

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
