package com.example.pixeleffect;

import static com.example.pixeleffect.DesignActivity.bitmap123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Saveactivity extends AppCompatActivity {

    ImageView imagsave;
    TextView share,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveactivity);

        imagsave = findViewById(R.id.imagsave);
        share = findViewById(R.id.share);
        save = findViewById(R.id.save);


        imagsave.setImageBitmap(bitmap123);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Build.VERSION.SDK_INT>Build.VERSION_CODES.P){

                    try {
                        Uri uri = saveBitmap(Saveactivity.this, bitmap123, Bitmap.CompressFormat.PNG, "image/*", "photo.png");
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("image/*");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pixel Effecct App");
//                        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
//                        shareIntent.setPackage("com.instagram.android");
                        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                        startActivity(Intent.createChooser(shareIntent, "h"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }else {
                    String path = saveAndroid9(bitmap123);

                    Uri uri = Uri.parse(path);
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pixel Effecct App");
//                        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
//                        shareIntent.setPackage("com.instagram.android");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    startActivity(Intent.createChooser(shareIntent, "h"));
                }


            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                    try {
                        saveBitmap(Saveactivity.this, bitmap123, Bitmap.CompressFormat.PNG, "image/*", "photo.png");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    saveAndroid9(bitmap123);
                }
            }
        });


    }

    @NonNull
    public Uri saveBitmap(@NonNull final Context context, @NonNull final Bitmap bitmap, @NonNull final Bitmap.CompressFormat format, @NonNull final String mimeType, @NonNull final String displayName) throws IOException {

        final String relativeLocation = Environment.DIRECTORY_DCIM + File.separator + "PixelEffect11";
        final ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, displayName);
        values.put(MediaStore.MediaColumns.MIME_TYPE, mimeType);
        values.put(MediaStore.MediaColumns.RELATIVE_PATH, relativeLocation);

        final ContentResolver resolver = context.getContentResolver();
        Uri uri = null;

        try {
            final Uri contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            uri = resolver.insert(contentUri, values);

            if (uri == null)
                throw new IOException("Failed to create new MediaStore record.");

            try (final OutputStream stream = resolver.openOutputStream(uri)) {
                if (stream == null)
                    throw new IOException("Failed to open output stream.");

                if (!bitmap.compress(format, 95, stream))
                    throw new IOException("Failed to save bitmap.");
            }

            Toast.makeText(context, "" + uri, Toast.LENGTH_SHORT).show();

            return uri;
        } catch (IOException e) {

            if (uri != null) {
                // Don't leave an orphan entry in the MediaStore
                resolver.delete(uri, null, null);
            }
            Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_SHORT).show();


            throw e;
        }
    }

    String saveAndroid9(Bitmap bitmap) {
        File pictureFileDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "PixelEffect11");
        if (!pictureFileDir.exists()) {
            boolean isDirectoryCreated = pictureFileDir.mkdirs();
            if (!isDirectoryCreated)
                Log.i("ATG", "Can't create directory to save the image");
            return null;
        }
        String filename = pictureFileDir.getPath() + File.separator + System.currentTimeMillis() + ".jpg";
        File pictureFile = new File(filename);
        try {
            pictureFile.createNewFile();
            FileOutputStream oStream = new FileOutputStream(pictureFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, oStream);
            oStream.flush();
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("TAG", "There was an issue saving the image.");
        }
//        scanGallery( context,pictureFile.getAbsolutePath());
        return pictureFile.getAbsolutePath();
    }
}