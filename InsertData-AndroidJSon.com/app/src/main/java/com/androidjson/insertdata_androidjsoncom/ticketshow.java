package com.androidjson.insertdata_androidjsoncom;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ticketshow extends AppCompatActivity {
    ImageView imview;
    String ticketid = journeyplan.ticketdata;


    String datefromjourney = journeyplan.date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticketshow);
        imview = (ImageView) findViewById(R.id.imageView);
        String ticketqr = ticketid;
        int height = 500;
        int width = 500;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(ticketqr, BarcodeFormat.QR_CODE, width, height);

            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            imview.setImageBitmap(bitmap);

           saveImageBitmap(bitmap,datefromjourney);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }
    public boolean isStoragePermissionGranted() {
        String TAG = "Storage Permission";
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {
                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

    public void saveImageBitmap(Bitmap image_bitmap, String image_name) {
//        String root = Environment.getExternalStorageDirectory().toString();
        String root = "/storage/emulated/0/Pictures";
        Toast.makeText(ticketshow.this, "Saved QR in /storage/emulated/0/Pictures/Smart_Bus_QRs", Toast.LENGTH_SHORT).show();
        if (isStoragePermissionGranted()) { // check or ask permission
            File myDir = new File(root, "/Smart_Bus_QRs");
            if (!myDir.exists()) {
                myDir.mkdirs();
            }
            String fname = image_name + ".jpg";
            File file = new File(myDir, fname);
            if (file.exists()) {
                file.delete();
            }
            try {
                file.createNewFile(); // if file already exists will do nothing
                FileOutputStream out = new FileOutputStream(file);
                image_bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            MediaScannerConnection.scanFile(this, new String[]{file.toString()}, new String[]{file.getName()}, null);
        }
    }
}





