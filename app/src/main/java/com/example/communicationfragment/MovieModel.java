package com.example.communicationfragment;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {

    String judul;  //deklarasi variable
    int poster;
    String genre;
    String ratingScore;
    String sinopsis;


    public MovieModel(String judul, int poster, String genre, String ratingScore, String sinopsis) // konstruktor : fungsi yang pertama kali di jalankan pada saat membuat objek
    {
        this.judul = judul;
        this.poster = poster;
        this.genre = genre;
        this.ratingScore = ratingScore;
        this.sinopsis = sinopsis;
    }


    protected MovieModel(Parcel in) {
        judul = in.readString();
        poster = in.readInt();
        genre = in.readString();
        ratingScore = in.readString();
        sinopsis = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(judul);
        parcel.writeInt(poster);
        parcel.writeString(genre);
        parcel.writeString(ratingScore);
        parcel.writeString(sinopsis);
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(String ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
