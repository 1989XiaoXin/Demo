package com.example.demo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x123);
            }
        },0,500);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,SplashActivity.class);
                startActivity(intent);
            }
        });
    }
    int imgids[] = new int[]{
            R.drawable.rb1,R.drawable.rb2,R.drawable.rb3};
    int imgstart = 0;
    final ImageView imgchange = findViewById(R.id.imgchange);
    final Handler myHandler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == 0x123){
                imgchange.setImagResource(imgids[imgstart ++ ]);
            }
        }
    };
}


