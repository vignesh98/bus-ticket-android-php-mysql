package com.androidjson.insertdata_androidjsoncom;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.ArrayList;
import java.util.List;

public class loginactivity extends AppCompatActivity {
Button button4;
public static String Tempuname;
String loginstatus,TempPassword,loginstat,str;
EditText uname,pass;
String ServerURL = "http://18.190.20.182/verify_user_login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        uname= (EditText)findViewById(R.id.usernamelogin);
        pass = (EditText)findViewById(R.id.passwordlogin);
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getlogindetails();

               verifylogin(Tempuname,TempPassword);

              // Toast.makeText(loginactivity.this, str, Toast.LENGTH_LONG).show();


            }
        });
    }

    private String verifylogin(final String tempuname, final String tempPassword) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String UNameHolder = tempuname;
                String PassHolder = tempPassword;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);

                nameValuePairs.add(new BasicNameValuePair("username", UNameHolder));
                nameValuePairs.add(new BasicNameValuePair("password", PassHolder));

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
                //loginstatus=str;
                return str;
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                //Toast.makeText(login.this, result, Toast.LENGTH_LONG).show();
                // loginactivity.loginstat= "sds";
                if(result.equalsIgnoreCase("truephp")){

                    //myIntent.putExtra("name", TempName); //Optional parameter
                  Toast.makeText(loginactivity.this, "Successful Login", Toast.LENGTH_SHORT).show();
                    Intent myIntent2 = new Intent(loginactivity.this,journeyplan.class);
                    startActivity(myIntent2);

                }
                else{

                  Toast.makeText(loginactivity.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();

                }
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(Tempuname,TempPassword);

        return str;
    }



    private void getlogindetails() {
        Tempuname = uname.getText().toString();
        TempPassword = pass.getText().toString();
    }
}
