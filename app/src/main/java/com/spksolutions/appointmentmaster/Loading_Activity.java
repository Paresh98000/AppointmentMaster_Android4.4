package com.spksolutions.appointmentmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Loading_Activity extends AppCompatActivity {

    Loading_Activity l = this;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_);
        i = new Intent(this,MainActivity.class);
    }

    @Override
    protected void onResume() {
        super.onResume();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                while(MainActivity.flag_loading_done){
                    startActivity(i);
                    l.finish();
                }
            }
        });

    }

}
