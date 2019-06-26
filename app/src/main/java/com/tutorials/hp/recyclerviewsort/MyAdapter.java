package com.tutorials.hp.recyclerviewsort;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oclemy on 7/24/2017 for ProgrammingWizards Channel and http://www.camposha.info.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Heros> list;

    public MyAdapter(Context context, List<Heros> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.model, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        //BIND DATA
        final List<Heros> hero = (List<Heros>) list.get(position);

        holder.nameTxt.setText(hero.get(0).getName());
        Picasso.with(context).load(hero.get(0).getImageurl())
                .into(holder.imageViewMarvel);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
