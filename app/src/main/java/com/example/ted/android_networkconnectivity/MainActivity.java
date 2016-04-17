package com.example.ted.android_networkconnectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnstart = (Button) findViewById(R.id.btnCheck);
    final TextView txtlabel = (TextView) findViewById(R.id.textView);

    assert btnstart != null;
    btnstart.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        ConnectivityManager conman = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = conman.getActiveNetworkInfo();
        String networkconn = "";

        switch(networkinfo.getType()) {
          case ConnectivityManager.TYPE_MOBILE:
            networkconn = "Mobile";
            break;
          case ConnectivityManager.TYPE_WIFI:
            networkconn = "Wifi";
            break;
          case ConnectivityManager.TYPE_WIMAX:
            networkconn = "WiMax";
            break;
          case ConnectivityManager.TYPE_ETHERNET:
            networkconn = "LAN";
            break;
          case ConnectivityManager.TYPE_BLUETOOTH:
            networkconn = "BlueTooth";
            break;
          default:
            networkconn = "Not Connnected";
        }
        txtlabel.setText(networkconn);
      }
    });

  }
}
