package com.androidjson.insertdata_androidjsoncom;
import android.content.Entity;
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
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import  org.apache.http.conn.BasicManagedEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    String ServerURL = "http://18.190.20.182/user_register.php" ;
    EditText name,email,age,password ;
    Button button,button2;
    String TempName,Tempemail,Tempage,TempPassword,str ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.editText2);
        email = (EditText)findViewById(R.id.editText4);
        age = (EditText)findViewById(R.id.editText5);
        password = (EditText)findViewById(R.id.editText3);
        button = (Button)findViewById(R.id.button);
        button2= (Button)findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetData();

                InsertData(TempName,Tempemail,Tempage,TempPassword);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, loginactivity.class);
                myIntent.putExtra("name", TempName); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

   public void GetData(){

       TempName = name.getText().toString();
       Tempemail=email.getText().toString();
       Tempage=age.getText().toString();
       TempPassword = password.getText().toString();

    }

    public void InsertData(final String reg_name,final String reg_email,final String reg_age, final String reg_password){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NameHolder = reg_name ;
                String EmailHolder = reg_email;
                String AgeHolder=reg_age;
                String PasswordHolder = reg_password ;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);

                nameValuePairs.add(new BasicNameValuePair("regname", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("regemail", EmailHolder));
                nameValuePairs.add(new BasicNameValuePair("regage", AgeHolder));
                nameValuePairs.add(new BasicNameValuePair("regpassword", PasswordHolder));

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

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(reg_name,reg_email,reg_age,reg_password);
    }

}
