package edu.uci.swe264p.retrofit;


import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {
    private List<Movie> Data;


    MovieListAdapter(List<Movie> Data) {
        this.Data=Data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tTv;
        TextView rTv;
        TextView vTv;
        TextView oTv;

        ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.ivMovie);
            tTv = itemView.findViewById(R.id.tvTitle);
            rTv = itemView.findViewById(R.id.tvReleaseDate);
            vTv = itemView.findViewById(R.id.tvVote);
            oTv = itemView.findViewById(R.id.tvOverview);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = Data.get(position);

        String iString = movie.getPosterPath();
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+iString).into(holder.iv);
        holder.tTv.setText(movie.getTitle());
        holder.rTv.setText(movie.getReleaseDate());
        holder.vTv.setText(movie.getVoteAverage().toString());
        holder.oTv.setText(movie.getOverview());
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
