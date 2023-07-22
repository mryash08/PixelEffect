package com.example.pixeleffect;

import static com.example.pixeleffect.Textactivity.mcurrentview12;
import static com.example.pixeleffect.adapter.stickeradapter.mcurrentView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.pixeleffect.adapter.dddadapter;
import com.example.pixeleffect.adapter.filteradapter;
import com.example.pixeleffect.adapter.glareadapter;
import com.example.pixeleffect.adapter.stickeradapter;
import com.example.pixeleffect.sticker.StickerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import yuku.ambilwarna.AmbilWarnaDialog;

public class DesignActivity extends AppCompatActivity {

    public static ImageView image;
    private RecyclerView recy;
    int sticker1[] = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a15,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a12,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a28,R.drawable.a29,R.drawable.a30,R.drawable.a34,R.drawable.a35,R.drawable.a36,R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b6,R.drawable.b7,R.drawable.b8,R.drawable.b9,R.drawable.b9,R.drawable.b10,R.drawable.b12,R.drawable.b14,R.drawable.b15,R.drawable.b16,R.drawable.b17,R.drawable.b18,R.drawable.b19,R.drawable.b20,R.drawable.cm_sticker_10,R.drawable.cm_sticker_11,R.drawable.cm_sticker_12,R.drawable.cm_sticker_13};
    int glare[] = {R.drawable.flare_01,R.drawable.flare_02,R.drawable.flare_03,R.drawable.flare_04,R.drawable.flare_05,R.drawable.flare_06};
    int efffect[] = {R.drawable.pixel_01,R.drawable.pixel_02,R.drawable.pixel_05,R.drawable.pixel_13,R.drawable.pixel_14,R.drawable.pixel_15,R.drawable.pixel_16,R.drawable.pixel_17,R.drawable.pixel_18,R.drawable.pixel_19,R.drawable.pixel_2,R.drawable.pixel_20,R.drawable.pixel_21,R.drawable.pixel_22,R.drawable.pixel_23,R.drawable.pixel_24,R.drawable.pixel_25,R.drawable.pixel_26,R.drawable.pixel_27,R.drawable.pixel_28,R.drawable.pixel_3,R.drawable.pixel_31,R.drawable.pixel_32,R.drawable.pixel_33,R.drawable.pixel_34,R.drawable.pixel_4,R.drawable.pixel_6,R.drawable.pixel_7,R.drawable.pixel_8,R.drawable.pixel_9};
    int ddd[] = {R.drawable.ddd_1,R.drawable.ddd_2,R.drawable.ddd_3,R.drawable.ddd_4,R.drawable.ddd_5,R.drawable.ddd_6,R.drawable.ddd_7,R.drawable.ddd_8,R.drawable.ddd_9,R.drawable.ddd_10,R.drawable.ddd_11,R.drawable.ddd_12,R.drawable.ddd_13,R.drawable.ddd_14};
    private LinearLayout ddd1;
    private LinearLayout effect;
    private LinearLayout glare1;
    public static ImageView image12,image111;
    private LinearLayout color1;
    private int mDefaultColor = 0;
    private LinearLayout sticker;
    public static BottomSheetDialog bottomSheetDialog;
    private RecyclerView stickerrecy;
    public static FrameLayout frammla1;
    private LinearLayout rotate;
    private LinearLayout text;
    private LinearLayout effect11;
    public Uri uri;
    ImageView savebtn;
    public  static Bitmap bitmap123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        image12 = findViewById(R.id.image11);
        savebtn = findViewById(R.id.savebtn);
        text = findViewById(R.id.text);
        frammla1 = findViewById(R.id.frammla);
        image = findViewById(R.id.image);
        image111 = findViewById(R.id.image1);
        recy = findViewById(R.id.recy);
       ddd1 = findViewById(R.id.ddd);
        effect = findViewById(R.id.effect);
        glare1 = findViewById(R.id.glare);
        color1 = findViewById(R.id.color);
        sticker = findViewById(R.id.sticker);
        rotate = findViewById(R.id.rotate);
        effect11 = findViewById(R.id.effect11);


        String uri23 = getIntent().getStringExtra("uri");
        uri = Uri.parse(uri23);
        image.setImageURI(uri);

        dddadapter ad = new dddadapter(DesignActivity.this,ddd);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DesignActivity.this,LinearLayoutManager.HORIZONTAL,false);
        recy.setLayoutManager(layoutManager);
        recy.setAdapter(ad);


        effect11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filteradapter fd = new filteradapter(DesignActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DesignActivity.this,LinearLayoutManager.HORIZONTAL,false);
                recy.setLayoutManager(layoutManager);
                recy.setAdapter(fd);
            }
        });


        ddd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dddadapter ad = new dddadapter(DesignActivity.this,ddd);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DesignActivity.this,LinearLayoutManager.HORIZONTAL,false);
                recy.setLayoutManager(layoutManager);
                recy.setAdapter(ad);
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                frammla1.setDrawingCacheEnabled(true);
                frammla1.buildDrawingCache();
                 bitmap123= frammla1.getDrawingCache();

                 Intent intent = new Intent(DesignActivity.this,Saveactivity.class);
                 startActivity(intent);
            }
        });

        effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dddadapter ad = new dddadapter(DesignActivity.this,efffect);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DesignActivity.this,LinearLayoutManager.HORIZONTAL,false);
                recy.setLayoutManager(layoutManager);
                recy.setAdapter(ad);
            }
        });

        glare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                glareadapter ad = new glareadapter(DesignActivity.this,glare);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DesignActivity.this,LinearLayoutManager.HORIZONTAL,false);
                recy.setLayoutManager(layoutManager);
                recy.setAdapter(ad);
            }
        });

        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AmbilWarnaDialog colorPickerDialogue = new AmbilWarnaDialog(DesignActivity.this, mDefaultColor,
                        new AmbilWarnaDialog.OnAmbilWarnaListener() {
                            @Override
                            public void onCancel(AmbilWarnaDialog dialog) {

                            }
                            @Override
                            public void onOk(AmbilWarnaDialog dialog, int color) {

                                mDefaultColor = color;
                                image12.setColorFilter(mDefaultColor);
                            }
                        });
                colorPickerDialogue.show();
            }
        });

        sticker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bottomsheetdialog();
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DesignActivity.this,Textactivity.class);
                startActivity(intent);
            }
        });

        frammla1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(mcurrentView != null){
                    mcurrentView.setInEdit(false);
                }

                if (mcurrentview12 != null ){
                    mcurrentview12.setInEdit(false);
                }

                return false;
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (image.getRotation()==0){
                    image.setRotation(90);
                }else if (image.getRotation()==90){
                    image.setRotation(180);
                }else if(image.getRotation()==180){
                    image.setRotation(360);
                }else if (image.getRotation()==360){
                    image.setRotation(0);
                }


            }
        });



    }

    void Bottomsheetdialog(){

        bottomSheetDialog = new BottomSheetDialog(DesignActivity.this,R.style.BottomSheetDialogTheme);
         View bottom =LayoutInflater.from(DesignActivity.this).inflate(R.layout.stickerres,findViewById(R.id.stickerline));
        stickerrecy = bottom.findViewById(R.id.stickerrecy);

        stickeradapter st = new stickeradapter(DesignActivity.this,sticker1);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(DesignActivity.this,3);

        stickerrecy.setLayoutManager(layoutManager);
        stickerrecy.setAdapter(st);


        bottomSheetDialog.setContentView(bottom);
        bottomSheetDialog.show();






    }


}