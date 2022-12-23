package com.example.caculatetestjava;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Intent intent;
    MediaPlayer bckgrnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ImageButton btn = findViewById(R.id.AnsGameBtn);
        ImageButton btn2 = findViewById(R.id.SymGameBtn);
        ImageButton btn3 = findViewById(R.id.button);

        //封面動畫
        AnimationDrawable ani = (AnimationDrawable) getResources().getDrawable(R.drawable.symbol_animation);
        ImageView img_frame = findViewById(R.id.imageView3);
        img_frame.setImageDrawable(ani);
        ani.start();
        //背景音樂
        bckgrnd = MediaPlayer.create(MainActivity.this, R.raw.backgroundmusic);
        bckgrnd.setLooping(true);
        bckgrnd.start();

        //答案遊戲跳頁按鈕
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AnsGame.class);
                startActivity(intent);
            }
        });
        //符號遊戲跳頁按鈕
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SymGame.class);
                startActivity(intent);
            }
        });
        //計算機跳頁按鈕
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), caculator.class);
                startActivity(intent);
            }
        });



    }

}