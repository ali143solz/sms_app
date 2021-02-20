package com.example.sms_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS},
        PackageManager.PERMISSION_GRANTED);
        SMS();
    }
    public void SMS(){

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               EditText phnmbr = (EditText) findViewById(R.id.number);
               EditText sms = (EditText) findViewById(R.id.msg);

                String ph = phnmbr.getText().toString().trim();
                String Sms = sms.getText().toString().trim();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(ph, null, Sms, null, null);

                Toast.makeText(getApplicationContext(), "Message send Successfully", Toast.LENGTH_SHORT).show();

            }
        });

    }
}