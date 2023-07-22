package com.example.pixeleffect.adapter;

import static com.example.pixeleffect.DesignActivity.bottomSheetDialog;
import static com.example.pixeleffect.DesignActivity.frammla1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaDrm;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixeleffect.DesignActivity;
import com.example.pixeleffect.R;
import com.example.pixeleffect.sticker.StickerView;

public class stickeradapter extends RecyclerView.Adapter<stickeradapter.View123> {
Activity activity;
int[] sticker;
public static StickerView mcurrentView;

    public stickeradapter(DesignActivity designActivity, int[] sticker1) {

        activity = designActivity;
        sticker = sticker1;
    }

    @NonNull
    @Override
    public View123 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(activity).inflate(R.layout.stickerrs1,parent,false);
        return new View123(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View123 holder, @SuppressLint("RecyclerView") int position) {
           holder.imgsticker.setImageResource(sticker[position]);
           holder.imgsticker.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   stickeredit(sticker[position]);
                   bottomSheetDialog.dismiss();
               }
           });

    }

    @Override
    public int getItemCount() {
        return sticker.length;
    }

    class View123 extends RecyclerView.ViewHolder {

        ImageView imgsticker;
        public View123(@NonNull View itemView) {
            super(itemView);

            imgsticker=itemView.findViewById(R.id.imgsticker);
        }
    }


    void stickeredit(int ps){
        StickerView stickerView = new StickerView(activity);
        stickerView.setImageResource(ps);
        RelativeLayout.LayoutParams layoutParams= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        frammla1.addView(stickerView,layoutParams);
        setCurrentEdit(stickerView);
        stickerView.setOperationListener(new StickerView.OperationListener() {
            @Override
            public void onDeleteClick() {
                frammla1.removeView(stickerView);


            }

            @Override
            public void onEdit(StickerView stickerView) {
mcurrentView.setInEdit(false);
mcurrentView = stickerView;
mcurrentView.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {

            }
        });

    }

    private void setCurrentEdit(StickerView stickerView){
        if(mcurrentView != null){
            mcurrentView.setInEdit(false);
        }
        mcurrentView = stickerView;
        stickerView.setInEdit(true);
    }
}
