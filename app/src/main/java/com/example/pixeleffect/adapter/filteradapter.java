package com.example.pixeleffect.adapter;

import static com.example.pixeleffect.DesignActivity.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixeleffect.DesignActivity;
import com.example.pixeleffect.Effects;
import com.example.pixeleffect.R;

public class filteradapter extends RecyclerView.Adapter<filteradapter.view> {

    Activity activity;


    public filteradapter(DesignActivity designActivityClass) {
        activity = designActivityClass;
    }

    @NonNull
    @Override
    public view onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.filter,parent,false);
        return new view(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view holder, @SuppressLint("RecyclerView") int position) {
//        Effects.applyEffect1(holder.filterimg);
//        Effects.applyEffect2(holder.filterimg);
//        Effects.applyEffect3(holder.filterimg);
//        Effects.applyEffect4(holder.filterimg);
//        Effects.applyEffect5(holder.filterimg);
//        Effects.applyEffect6(holder.filterimg);
//        Effects.applyEffect7(holder.filterimg);
//        Effects.applyEffect8(holder.filterimg);
//        Effects.applyEffect9(holder.filterimg);
//        Effects.applyEffect10(holder.filterimg);
//        Effects.applyEffect11(holder.filterimg);
//        Effects.applyEffect12(holder.filterimg);
//        Effects.applyEffect13(holder.filterimg);
//        Effects.applyEffect14(holder.filterimg);
//        Effects.applyEffect15(holder.filterimg);
//        Effects.applyEffect16(holder.filterimg);
//        Effects.applyEffect17(holder.filterimg);
//        Effects.applyEffect18(holder.filterimg);
//        Effects.applyEffect19(holder.filterimg);
//        Effects.applyEffect20(holder.filterimg);
//        Effects.applyEffect21(holder.filterimg);
//        Effects.applyEffect22(holder.filterimg);
//        Effects.applyEffect1(holder.filterimg);

        switch (position){
            case 0 : Effects.applyEffect1(holder.filterimg);
                break;
            case 1 : Effects.applyEffect2(holder.filterimg);
                break;
            case 2 : Effects.applyEffect3(holder.filterimg);
                break;
            case 3 : Effects.applyEffect4(holder.filterimg);
                break;
            case 4 : Effects.applyEffect5(holder.filterimg);
                break;
            case 5  : Effects.applyEffect6(holder.filterimg);
                break;
            case 6 : Effects.applyEffect7(holder.filterimg);
                break;
            case 7 : Effects.applyEffect8(holder.filterimg);
                break;
            case 8 : Effects.applyEffect9(holder.filterimg);
                break;
            case 9 : Effects.applyEffect10(holder.filterimg);
                break;
            case 10 : Effects.applyEffect11(holder.filterimg);
                break;
            case 11 : Effects.applyEffect12(holder.filterimg);
                break;
            case 12 : Effects.applyEffect13(holder.filterimg);
                break;
            case 13 : Effects.applyEffect14(holder.filterimg);
                break;
            case 14 : Effects.applyEffect15(holder.filterimg);
                break;
            case 15 : Effects.applyEffect16(holder.filterimg);
                break;
            case 16 : Effects.applyEffect17(holder.filterimg);
                break;
            case 17 : Effects.applyEffect18(holder.filterimg);
                break;
            case 18 : Effects.applyEffect19(holder.filterimg);
                break;
            case 19 : Effects.applyEffect20(holder.filterimg);
                break;
            case 20 : Effects.applyEffect21(holder.filterimg);
                break;
            case 21 : Effects.applyEffect22(holder.filterimg);
                break;

        }

        holder.filterimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0 : Effects.applyEffect1(image);
                        break;
                    case 1 : Effects.applyEffect2(image);
                        break;
                    case 2 : Effects.applyEffect3(image);
                        break;
                    case 3 : Effects.applyEffect4(image);
                        break;
                    case 4 : Effects.applyEffect5(image);
                        break;
                    case 5  : Effects.applyEffect6(image);
                        break;
                    case 6 : Effects.applyEffect7(image);
                        break;
                    case 7 : Effects.applyEffect8(image);
                        break;
                    case 8 : Effects.applyEffect9(image);
                        break;
                    case 9 : Effects.applyEffect10(image);
                        break;
                    case 10 : Effects.applyEffect11(image);
                        break;
                    case 11 : Effects.applyEffect12(image);
                        break;
                    case 12 : Effects.applyEffect13(image);
                        break;
                    case 13 : Effects.applyEffect14(image);
                        break;
                    case 14 : Effects.applyEffect15(image);
                        break;
                    case 15 : Effects.applyEffect16(image);
                        break;
                    case 16 : Effects.applyEffect17(image);
                        break;
                    case 17 : Effects.applyEffect18(image);
                        break;
                    case 18 : Effects.applyEffect19(image);
                        break;
                    case 19 : Effects.applyEffect20(image);
                        break;
                    case 20 : Effects.applyEffect21(image);
                        break;
                    case 21 : Effects.applyEffect22(image);
                        break;

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return 22;
    }

    class view extends RecyclerView.ViewHolder {
        public ImageView filterimg;
        public view(@NonNull View itemView) {
            super(itemView);

            filterimg = itemView.findViewById(R.id.filterimg);
        }
    }
}
