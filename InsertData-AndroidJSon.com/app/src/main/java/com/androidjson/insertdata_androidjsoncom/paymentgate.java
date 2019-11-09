package com.androidjson.insertdata_androidjsoncom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class paymentgate extends AppCompatActivity {
    TextView tcost,wallet;
    String walletbalance="500";
    Button paybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentgate);
        final String paymenttobemade = getIntent().getStringExtra("paymentfromjourney");
       tcost=(TextView) findViewById(R.id.textView10);

       tcost.setText(paymenttobemade);

       wallet=(TextView) findViewById(R.id.wallettextview);
       wallet.setText(walletbalance);

        paybutton = (Button) findViewById(R.id.paymentbutton);

        paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int cost = Integer.valueOf(paymenttobemade);
//                int wallet = Integer.valueOf(walletbalance);
//                int balance = wallet - cost;
                int balance=1;
                Intent myInt = new Intent(paymentgate.this,ticketshow.class);
                startActivity(myInt);

            }
        });

    }
}
