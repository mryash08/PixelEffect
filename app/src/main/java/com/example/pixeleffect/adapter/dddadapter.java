package com.example.pixeleffect.adapter;

import static com.example.pixeleffect.DesignActivity.image12;
import static com.example.pixeleffect.R.id.image;
import static com.example.pixeleffect.R.id.image11;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixeleffect.DesignActivity;
import com.example.pixeleffect.R;
import com.squareup.picasso.Picasso;

public class dddadapter extends RecyclerView.Adapter<dddadapter.View11> {


    Activity  activity;
    int[]  ddd;


    public dddadapter(DesignActivity designActivity, int[] ddd) {
        activity = designActivity;
        this.ddd = ddd;

    }

    @NonNull
    @Override
    public View11 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              View view= LayoutInflater.from(activity).inflate(R.layout.ddd,parent,false);


        return new View11(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View11 holder, @SuppressLint("RecyclerView") int position) {
        holder.img.setImageResource(ddd[position]);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 image12.setImageResource(ddd[position]);
            }
        });


    }

    @Override
    public int getItemCount() {
        return ddd.length;
    }

    class View11 extends RecyclerView.ViewHolder {

        ImageView img;
        public View11(@NonNull android.view.View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
        }
    }
}
