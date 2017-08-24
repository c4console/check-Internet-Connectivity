package com.c4console.internet_connectivity_check;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button internetButton;
    private TextView internetStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internetButton = (Button) findViewById(R.id.internetButton);
        internetStatus = (TextView) findViewById(R.id.internetText);
        internetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cn=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo status=cn.getActiveNetworkInfo();
                if(status != null && status.isConnected()==true )
                {
                    internetStatus.setText("Network Available");
                }
                else
                {
                    internetStatus.setText("Network Not Available");
                }
            }
        });

    }
}
