package com.tutorials.hp.recyclerviewsort;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;


public class HerosAdapter extends RecyclerView.Adapter<HerosAdapter.ViewHolder> {

    private Activity context;
    List<Heros> list;
    int size;

    public HerosAdapter(Activity context, List<Heros> list) {
        this.context = context;
        this.size = size;
        this.list = list;

    }

    @NonNull
    @Override
    public HerosAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model, viewGroup, false);
        HerosAdapter.ViewHolder viewHolder = new HerosAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final HerosAdapter.ViewHolder viewHolder, final int position) {

        final Heros hero = list.get(position);

        viewHolder.nameTxt.setText(hero.getName());
        Picasso.with(context).load(hero.getImageurl())
                .into(viewHolder.imageViewMarvel);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTxt;
        ImageView imageViewMarvel;


        public ViewHolder(View itemView) {
            super(itemView);


            nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
            imageViewMarvel = (ImageView)itemView.findViewById(R.id.imageViewMarvel);

        }
    }
}


