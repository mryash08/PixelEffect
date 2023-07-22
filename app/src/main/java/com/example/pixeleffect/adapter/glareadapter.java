package com.example.pixeleffect.adapter;

import static com.example.pixeleffect.DesignActivity.image111;
import static com.example.pixeleffect.DesignActivity.image12;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixeleffect.DesignActivity;
import com.example.pixeleffect.R;

public class glareadapter extends RecyclerView.Adapter<glareadapter.View12> {

Activity activity;
int[] glare;
    public glareadapter(DesignActivity designActivity, int[] glare) {

        activity = designActivity;
        this.glare = glare;

    }

    @NonNull
    @Override
    public View12 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.glare,parent,false);


        return new View12(view);

    }

    @Override
    public void onBindViewHolder(@NonNull View12 holder, @SuppressLint("RecyclerView") int position) {
        holder.img11.setImageResource(glare[position]);
        holder.img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image111.setImageResource(glare[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return glare.length;
    }

    class View12 extends RecyclerView.ViewHolder {

        public ImageView img11;
        public View12(@NonNull View itemView) {
            super(itemView);


            img11 = itemView.findViewById(R.id.img11);

        }
    }
}
