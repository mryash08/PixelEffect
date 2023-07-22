package com.example.pixeleffect.adapter;

import static com.example.pixeleffect.Textactivity.bottomSheetDialog;
import static com.example.pixeleffect.Textactivity.txt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixeleffect.R;
import com.example.pixeleffect.Textactivity;

public class patternadapter extends RecyclerView.Adapter<patternadapter.View1233> {

    Activity activity;
    int[] pattern11;
    public  static Bitmap bitmap11;


    public patternadapter(Textactivity textactivity, int[] pattern11) {

        activity = textactivity;
        this.pattern11 = pattern11;
    }

    @NonNull
    @Override
    public View1233 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.stylepattern1,parent,false);
        return new View1233(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View1233 holder, @SuppressLint("RecyclerView") int position) {
        holder.imgstyle1.setImageResource(pattern11[position]);
        bitmap11= BitmapFactory.decodeResource(activity.getResources(),pattern11[position]);
//        BitmapShader bitmapShader =
        holder.imgstyle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BitmapShader bitmapShader = new BitmapShader(bitmap11, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                txt.getPaint().setShader(bitmapShader);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pattern11.length;
    }

    class View1233 extends RecyclerView.ViewHolder {
        public ImageView imgstyle1;

        public View1233(@NonNull View itemView) {
            super(itemView);
            imgstyle1  = itemView.findViewById(R.id.imgstyle1);
        }
    }
}
