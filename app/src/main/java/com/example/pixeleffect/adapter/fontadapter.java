package com.example.pixeleffect.adapter;

import static com.example.pixeleffect.Textactivity.bottomSheetDialog;
import static com.example.pixeleffect.Textactivity.txt;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixeleffect.R;
import com.example.pixeleffect.Textactivity;

public class fontadapter extends RecyclerView.Adapter<fontadapter.View1111> {

    Activity activity;
    String[]   font11;


    public fontadapter(Textactivity textactivity, String[] font11) {
        activity = textactivity;
        this.font11 = font11;
    }

    @NonNull
    @Override
    public View1111 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.font11style,parent,false);
        return new View1111(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View1111 holder, int position) {
        Typeface face = Typeface.createFromAsset(activity.getAssets(), font11[position]);
        holder.txtstyle1.setTypeface(face);
        holder.txtstyle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setTypeface(face);
                bottomSheetDialog.dismiss();
            }
        });

    }

    @Override
    public int getItemCount() {
        return font11.length;
    }

    class View1111 extends RecyclerView.ViewHolder {
        private final TextView txtstyle1;

        public View1111(@NonNull View itemView) {
            super(itemView);

            txtstyle1 = itemView.findViewById(R.id.txtstyle1);
        }
    }
}
