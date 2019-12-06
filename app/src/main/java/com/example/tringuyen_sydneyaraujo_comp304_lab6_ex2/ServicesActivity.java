package com.example.tringuyen_sydneyaraujo_comp304_lab6_ex2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ServicesActivity extends AppCompatActivity {
    private TextView textView;
    //replace with your package name
    public static final String INFO_INTENT = "com.example.tringuyen_sydneyaraujo_com304_lab6_ex2.INFO_UPDATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        textView = (TextView) findViewById(R.id.textView);
    }

    //This will handle the broadcast
    public BroadcastReceiver receiver = new BroadcastReceiver() {
        //@Override
        public void onReceive(Context context, Intent intent) {
            //textView.setText("Here");
            String action = intent.getAction();
            if (action.equals(SimpleService.INFO_INTENT)) {
                String info = intent.getStringExtra(INFO_INTENT);
                textView.setText(info);
            }
        }

    };
    //
    public void startService(View view) {
        startService(new Intent(getBaseContext(), SimpleService.class));
    }
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(),
                SimpleService.class));
    }

    public void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(INFO_INTENT));
    }

}