package com.example.pixeleffect;

import static com.example.pixeleffect.DesignActivity.frammla1;
import static com.example.pixeleffect.adapter.patternadapter.bitmap11;
import static com.example.pixeleffect.adapter.stickeradapter.mcurrentView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.pixeleffect.adapter.fontadapter;
import com.example.pixeleffect.adapter.patternadapter;
import com.example.pixeleffect.adapter.stickeradapter;
import com.example.pixeleffect.sticker.StickerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Textactivity extends AppCompatActivity {

    private ImageView done;
    private LinearLayout addtext,txtsize,txtcolor,txtstyle,txtblur;
    public static TextView txt;
    private CardView inputtext;
    private ImageView txtdone;
    private TextInputEditText txtedit;
    public static BottomSheetDialog bottomSheetDialog;

    int pattern11[] = {R.mipmap.pattern_01,R.mipmap.pattern_02,R.mipmap.pattern_03,R.mipmap.pattern_04,R.mipmap.pattern_05,R.mipmap.pattern_06,R.mipmap.pattern_07,R.mipmap.pattern_08,R.mipmap.pattern_09,R.mipmap.pattern_10,R.mipmap.thumb_pattern_01,R.mipmap.thumb_pattern_02,R.mipmap.pattern_03,R.mipmap.thumb_pattern_04,R.mipmap.thumb_pattern_05,R.mipmap.thumb_pattern_06,};

    String font11[] = {"font1.ttf","font2.ttf","font3.ttf","font4.TTF","font5.ttf","font6.TTF","font7.ttf","font8.ttf","font9.ttf","font10.TTF","font11.ttf","font12.ttf","font14.TTF","font16.TTF","font17.ttf","font18.ttf","font19.ttf"};

    int font111[] = {R.font.font1,R.font.font2,R.font.font3,R.font.font4,R.font.font5,R.font.font6,R.font.font7,R.font.font8,R.font.font9,R.font.font10,R.font.font11,R.font.font12,R.font.font16,R.font.font14};

    String textview;

    int progress;
    private SeekBar seek_bar;
    private TextView done_btn;
    private int mDefaultColor = 0;
    private LinearLayout font;
    private RecyclerView recyfont;
    private LinearLayout txtpattern;
    private RecyclerView recypattern;
    private RadioGroup blurgroup;
    public  static Bitmap b;
    public static StickerView mcurrentview12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textactivity);

        done = findViewById(R.id.done);
        addtext = findViewById(R.id.addtext);
        txt = findViewById(R.id.txt);
        inputtext = findViewById(R.id.inputtext);
        txtdone = findViewById(R.id.txtdone);
        txtedit = findViewById(R.id.txtedit);
        txtsize = findViewById(R.id.txtsize);
        txtcolor = findViewById(R.id.txtcolor);
        txtstyle = findViewById(R.id.txtstyle);
        font = findViewById(R.id.font);
        txtpattern = findViewById(R.id.txtpattern);
        txtblur = findViewById(R.id.txtblur);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setDrawingCacheEnabled(true);
                txt.buildDrawingCache(true);
                b = Bitmap.createBitmap(txt.getDrawingCache());
                stickeredit(b);
                finish();
            }
        });

        addtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputtext.setVisibility(View.VISIBLE);
            }
        });

        txtdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview = txtedit.getText().toString();
                inputtext.setVisibility(View.GONE);
                txt.setText(textview);
                txt.setVisibility(View.VISIBLE);
            }
        });

        txtcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AmbilWarnaDialog colorPickerDialogue = new AmbilWarnaDialog(Textactivity.this, mDefaultColor,
                        new AmbilWarnaDialog.OnAmbilWarnaListener() {
                            @Override
                            public void onCancel(AmbilWarnaDialog dialog) {

                            }
                            @Override
                            public void onOk(AmbilWarnaDialog dialog, int color) {

                                mDefaultColor = color;
                                txt.setTextColor(mDefaultColor);
                            }
                        });
                colorPickerDialogue.show();
            }
        });
        txtsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   Bottomsheetdialog();

                seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        progress = i;
                        txt.setTextSize(progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }

                });

                done_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });

            }
        });

        txtstyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bottomsheet();
            }
        });

        txtpattern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             patternBottomsheet();
            }
        });

        txtblur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   blurbottom();
            }
        });

    }



    void blurbottom(){
        bottomSheetDialog = new BottomSheetDialog(Textactivity.this,R.style.BottomSheetDialogTheme);
        View bottom = LayoutInflater.from(Textactivity.this).inflate(R.layout.blurbottom,findViewById(R.id.blur));
        blurgroup = bottom.findViewById(R.id.blurgroup);
        done_btn = bottom.findViewById(R.id.done_btn);

        blurgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (blurgroup.getCheckedRadioButtonId()==R.id.noblur){

                    txt.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
                    txt.getPaint().setMaskFilter(null);

                }else if (blurgroup.getCheckedRadioButtonId()==R.id.innerblur){
                    applyblur(BlurMaskFilter.Blur.INNER);


                } else if (blurgroup.getCheckedRadioButtonId() == R.id.outerblur) {
                    applyblur(BlurMaskFilter.Blur.OUTER);


                }else if (blurgroup.getCheckedRadioButtonId()==R.id.solidblur){
                    applyblur(BlurMaskFilter.Blur.SOLID);


                }else if (blurgroup.getCheckedRadioButtonId()==R.id.normalblur){
                    applyblur(BlurMaskFilter.Blur.NORMAL);

                }
            }
        });

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

//        blurgroup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (blurgroup.getCheckedRadioButtonId()==R.id.noblur){
//
//                    txt.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
//                    txt.getPaint().setMaskFilter(null);
//                    bottomSheetDialog.dismiss();
//                }else if (blurgroup.getCheckedRadioButtonId()==R.id.innerblur){
//                    applyblur(BlurMaskFilter.Blur.INNER);
//                    bottomSheetDialog.dismiss();
//
//                } else if (blurgroup.getCheckedRadioButtonId() == R.id.outerblur) {
//                    applyblur(BlurMaskFilter.Blur.OUTER);
//                    bottomSheetDialog.dismiss();
//
//                }else if (blurgroup.getCheckedRadioButtonId()==R.id.solidblur){
//                    applyblur(BlurMaskFilter.Blur.SOLID);
//                    bottomSheetDialog.dismiss();
//
//                }else if (blurgroup.getCheckedRadioButtonId()==R.id.normalblur){
//                    applyblur(BlurMaskFilter.Blur.NORMAL);
//                    bottomSheetDialog.dismiss();
//
//                }
//            }
//        });







        bottomSheetDialog.setContentView(bottom);
        bottomSheetDialog.show();


    }

    void applyblur(BlurMaskFilter.Blur b1){

        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(10,b1);
        txt.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        txt.getPaint().setMaskFilter(blurMaskFilter);

    }

    void patternBottomsheet(){
        bottomSheetDialog = new BottomSheetDialog(Textactivity.this,R.style.BottomSheetDialogTheme);
        View bottom = LayoutInflater.from(Textactivity.this).inflate(R.layout.stylepattern,findViewById(R.id.pattern));
        recypattern = bottom.findViewById(R.id.recypattern);
        done_btn = bottom.findViewById(R.id.done_btn);

        patternadapter pattern = new patternadapter(Textactivity.this,pattern11);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Textactivity.this,3);
        recypattern.setLayoutManager(layoutManager);
        recypattern.setAdapter(pattern);



        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.setContentView(bottom);
        bottomSheetDialog.show();
    }

    void Bottomsheet(){
        bottomSheetDialog = new BottomSheetDialog(Textactivity.this,R.style.BottomSheetDialogTheme);
        View bottom = LayoutInflater.from(Textactivity.this).inflate(R.layout.styletxt,findViewById(R.id.font));
        recyfont = bottom.findViewById(R.id.recyfont);

        fontadapter font = new fontadapter(Textactivity.this,font11);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(Textactivity.this,3);
        recyfont.setLayoutManager(layoutManager);
        recyfont.setAdapter(font);



        bottomSheetDialog.setContentView(bottom);
        bottomSheetDialog.show();
    }

    void Bottomsheetdialog(){

        bottomSheetDialog = new BottomSheetDialog(Textactivity.this,R.style.BottomSheetDialogTheme);
        View bottom = LayoutInflater.from(Textactivity.this).inflate(R.layout.sizetext,findViewById(R.id.stickerline));
        seek_bar = bottom.findViewById(R.id.seek_bar);
        done_btn = bottom.findViewById(R.id.done_btn);



        bottomSheetDialog.setContentView(bottom);
        bottomSheetDialog.show();



    }

    void stickeredit(Bitmap b){
        StickerView stickerView12 = new StickerView(Textactivity.this);
        stickerView12.setBitmap(b);
        RelativeLayout.LayoutParams layoutParams= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        frammla1.addView(stickerView12,layoutParams);
        setCurrentEdit(stickerView12);
        stickerView12.setOperationListener(new StickerView.OperationListener() {
            @Override
            public void onDeleteClick() {
                frammla1.removeView(stickerView12);


            }

            @Override
            public void onEdit(StickerView stickerView) {
                mcurrentview12.setInEdit(false);
                mcurrentview12 = stickerView;
                mcurrentview12.setInEdit(true);
            }

            @Override
            public void onTop(StickerView stickerView) {

            }
        });

    }

    private void setCurrentEdit(StickerView stickerView12){
        if(mcurrentview12 != null){
            mcurrentview12.setInEdit(false);
        }
        mcurrentview12 = stickerView12;
        stickerView12.setInEdit(true);
    }
}