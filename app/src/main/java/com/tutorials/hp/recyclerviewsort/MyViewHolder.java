package com.tutorials.hp.recyclerviewsort;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oclemy on 7/24/2017 for ProgrammingWizards Channel and http://www.camposha.info.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nameTxt;
    ImageView imageViewMarvel;



    public MyViewHolder(View itemView) {
        super(itemView);

        nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        imageViewMarvel = (ImageView)itemView.findViewById(R.id.imageViewMarvel);

    }

}
