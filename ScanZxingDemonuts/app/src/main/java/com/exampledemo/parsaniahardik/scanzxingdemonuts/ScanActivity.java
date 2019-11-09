package com.exampledemo.parsaniahardik.scanzxingdemonuts;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {


   String str,ticketdata,checkticketurl="http://18.190.20.182/verify_ticket.php";
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        // Log.v("tag", rawResult.getText()); // Prints scan results
        // Log.v("tag", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        ticketdata= rawResult.getText();
        MainActivity.tvresult.setText(rawResult.getText());
        //Toast.makeText(ScanActivity.this, ticketdata, Toast.LENGTH_SHORT).show();
        checkticket(ticketdata);
        MainActivity.showticketstatus.setImageResource(R.drawable.searching_icon);
        onBackPressed( );


        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }

    private String checkticket(final String ticketdata) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String ticketHolder = ticketdata;


                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

                nameValuePairs.add(new BasicNameValuePair("ticketstring", ticketHolder));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(checkticketurl);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();

                    str =  EntityUtils.toString(httpEntity);

                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                //loginstatus=str;
                return str;
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                //Toast.makeText(login.this, result, Toast.LENGTH_LONG).show();
                // loginactivity.loginstat= "sds";
                if(result.equalsIgnoreCase("valid")){

                    //myIntent.putExtra("name", TempName); //Optional parameter
                   // Toast.makeText(ScanActivity.this, "Valid ticket", Toast.LENGTH_SHORT).show();
                    MainActivity.tvresult.setText(ticketdata);
                    MainActivity.showticketstatus.setImageResource(R.drawable.ok);
                    //  Intent myIntent2 = new Intent(ScanActivity.this,journeyplan.class);
                  // startActivity(myIntent2);

                }
                else{

                    //Toast.makeText(ScanActivity.this, "Invalid Ticket", Toast.LENGTH_SHORT).show();
                    MainActivity.tvresult.setText(ticketdata);
                    MainActivity.showticketstatus.setImageResource(R.drawable.no);
                }
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(ticketdata);

        return str;

    }
}