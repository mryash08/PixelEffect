package com.example.pixeleffect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.util.UUID;

public class Cropperactivity extends AppCompatActivity {



    String result;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropperactivity);

        readIntent();

        String uri1 = new StringBuilder(UUID.randomUUID().toString()).append(".jpg").toString();

        UCrop.Options options = new UCrop.Options();

//        options.setAspectRatioOptions(-1,);
        UCrop.of(uri,Uri.fromFile(new File(getCacheDir(),uri1)))
              .withOptions(options)
               .withAspectRatio(16,9)
                .withAspectRatio(4,3)
                 .useSourceImageAspectRatio()
                 .withMaxResultSize(2000,2000)
                  .start(Cropperactivity.this);



    }

    private void readIntent() {

        Intent intent = getIntent();
        if (intent.getExtras()!= null){
            result = intent.getStringExtra("Data");
            uri = Uri.parse(result);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode==RESULT_OK && requestCode==UCrop.REQUEST_CROP){
            final Uri resulturi =UCrop.getOutput(data);
            Intent returnIntent = new Intent();
            returnIntent.putExtra("result",resulturi+"");
            setResult(-1,returnIntent);
            finish();
        }else if(resultCode == UCrop.RESULT_ERROR){
            final Throwable croperror = UCrop.getError(data);
        }
    }
}