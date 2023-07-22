package com.example.pixeleffect;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.cast.framework.media.ImagePicker;

public class MainActivity extends AppCompatActivity {

    private ImageView start;
    ActivityResultLauncher<String> mgetcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                      mgetcontent.launch("image/*");

            }
        });

        mgetcontent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                Intent intent = new Intent(MainActivity.this,Cropperactivity.class);
                intent.putExtra("Data",result.toString());
                startActivityForResult(intent,101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==-1 && requestCode == 101){
            String result = data.getStringExtra("result");
            Uri resultUri = null;
            if(result!=null){
                resultUri = Uri.parse(result);
            }

            Intent intent = new Intent(MainActivity.this,DesignActivity.class);
            intent.putExtra("uri",resultUri+"");
            startActivity(intent);
        }
    }


}