package com.example.binoypaul.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyService abc = new MyService();
    TextView binoText;
    EditText num1;
    EditText num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binoText = (TextView) findViewById(R.id.binoText );
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        Intent i = new Intent(this, MyService.class);
        bindService(i, BinoServiceConnect, Context.BIND_AUTO_CREATE);
    }

    public ServiceConnection BinoServiceConnect = new ServiceConnection() {
     @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("bTest", "Hi Binoy ");
            Log.i("bTest", String.valueOf(abc.MyServiceTrialMethod(1,2)));

        // SetText();
        }


        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("bTest", "The service is disconnected");
        }
    };

    public void SetText(View v)
    {
        Integer number1 = Integer.valueOf(num1.getText().toString());
        Integer number2 = Integer.valueOf(num2.getText().toString());

        binoText.setText(String.valueOf(abc.MyServiceTrialMethod( number1,number2)));
       // binoText.setText( String.valueOf(123));
    }


}
