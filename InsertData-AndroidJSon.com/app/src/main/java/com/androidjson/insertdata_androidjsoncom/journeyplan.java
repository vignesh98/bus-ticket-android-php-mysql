package com.androidjson.insertdata_androidjsoncom;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class journeyplan extends AppCompatActivity {
    Button bookbut;
Button button;
EditText date;
Spinner spin,spin2;
String ServerURL="http://18.190.20.182/save_journey_details.php",str;
    String passengerusername = loginactivity.Tempuname;
    public static DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
    public static String date1 = df.format(Calendar.getInstance().getTime());
public static String fromadd,toadd,ticketdata,paymentamount;
//String[] fromitems = {"Marathahalli","Hebbal","Kengeri","Silkboard","TinFactory","Banashankari","IndiraNagar","K.R.Puram"};
 //   String[] toitems= {"Marathahalli","Hebbal","Kengeri","Silkboard","TinFactory","Banashankari","IndiraNagar","K.R.Puram"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journeyplan);
        bookbut=(Button)findViewById(R.id.bookbutton);
        button=(Button) findViewById(R.id.ticketbutton);
      //  date=(EditText) findViewById(R.id.editText10);

        spin = (Spinner) findViewById(R.id.spinner);
        spin2=(Spinner) findViewById(R.id.spinner2);

        //date1=date.getText().toString();
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyyHH:mm:ss");
//        final String date1 = df.format(Calendar.getInstance().getTime());

        bookbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fromadd=spin.getSelectedItem().toString();
                toadd=spin2.getSelectedItem().toString();
                ticketdata = fromadd+toadd+date1;
                InsertJourneyDetails(passengerusername,fromadd,toadd,ticketdata);
             //   Toast.makeText(journeyplan.this, paymentamount, Toast.LENGTH_LONG).show();


            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // Intent myInt = new Intent(journeyplan.this,ticketshow.class);
             //   startActivity(myInt);
                fromadd=spin.getSelectedItem().toString();
                toadd=spin2.getSelectedItem().toString();
                ticketdata = fromadd+toadd+date1;
                openFolder();
            }
        });
    }



    public void openFolder()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setType("*/*");
        startActivity(intent);
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
//                "content:/storage/emulated/0/Pictures"));
    }



    public void InsertJourneyDetails(final String name,final String fromadd,final String toadd, final String ticketdata){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NameHolder = name ;
                String fromHolder = fromadd;
                String toHolder=toadd;
                String ticketdataHolder= ticketdata;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);

                nameValuePairs.add(new BasicNameValuePair("name", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("fromadd", fromHolder));
                nameValuePairs.add(new BasicNameValuePair("toadd", toHolder));
                nameValuePairs.add(new BasicNameValuePair("ticketdata", ticketdataHolder));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();

                    str =  EntityUtils.toString(httpEntity);

                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return str;
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

               // paymentamount=result;
               // Toast.makeText(journeyplan.this, result, Toast.LENGTH_LONG).show();
                Intent myIntent3 = new Intent(journeyplan.this,paymentgate.class);
               myIntent3.putExtra("paymentfromjourney", result);
                startActivity(myIntent3);

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(name,fromadd,toadd,ticketdata);
    }
}
