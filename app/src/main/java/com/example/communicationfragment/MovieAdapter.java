package com.example.communicationfragment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private List<MovieModel> listMovieModel;
    private FragmentManager fragmentManager;
    private Context mContext;
    public MovieAdapter(Context context, List<MovieModel> listMovieModel,
                        FragmentManager fragmentManager) {
        mContext = context;
        this.fragmentManager = fragmentManager;
        this.listMovieModel = listMovieModel;
    }
    public void SetListModel(List<MovieModel> listMovieModel){
        this.listMovieModel = listMovieModel;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_satuan,parent,
                        false);
        ViewHolder mViewHolder = new ViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Resources res = holder.itemView.getContext().getResources();
        final MovieModel movieModel = listMovieModel.get(position);
        holder.tvJudul.setText(movieModel.getJudul());
        holder.tvRating.setText(mContext.getResources().getString(R.string.rating)
                +" : "+movieModel.getRatingScore());
        Glide.with (holder.itemView.getContext()).load(movieModel.getPoster()).into(
                holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener()  // ketika di klik bisa menampilkan detail
        {
            @Override
            public void onClick(View view) {
                Bundle mBundle = new Bundle();
                DetailFragment mDetailFragment = new DetailFragment();
                mBundle.putParcelable(MainActivity.class.getSimpleName(),movieModel); // untuk get movieModel
                mDetailFragment.setArguments(mBundle);
                fragmentManager.popBackStackImmediate();
                FragmentTransaction mFragmentTransaction;
                if(res.getBoolean(R.bool.twoPaneMode)){
                    mFragmentTransaction =
                            fragmentManager.beginTransaction()
                                    .replace(R.id.frameDetail,mDetailFragment).addToBackStack(null);
                }else{
                    mFragmentTransaction =
                            fragmentManager.beginTransaction()
                                    .replace(R.id.frameLayout,mDetailFragment).addToBackStack(null);
                }
                mFragmentTransaction.commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return listMovieModel.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvJudul;
        private TextView tvRating;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvRating = itemView.findViewById(R.id.tvRating);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}