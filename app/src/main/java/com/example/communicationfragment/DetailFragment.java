package com.example.communicationfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments(); // get argument
        MovieModel movie = getArguments().getParcelable(MainActivity.class.getSimpleName()); // get data dari movieadapter

        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        TextView tvJudul = view.findViewById(R.id.tvJudul);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvRating = view.findViewById(R.id.tvRating);
        TextView tvGenre = view.findViewById(R.id.tvGenre);
        TextView tvSinopsis = view.findViewById(R.id.tvSinopsis);
        TextView tvContentSinopsis = view.findViewById(R.id.tvContentSinopsis);

        tvJudul.setText(movie.judul); // mengambil dari model
        Glide.with (view.getContext()).load(movie.getPoster()).into(imageView); //untuk detail image
        tvRating.setText(movie.ratingScore);
        tvGenre.setText(movie.genre);
        tvSinopsis.setText("Review");
        tvContentSinopsis.setText(movie.sinopsis);
        return view;
    }

}
