package com.example.caculatetestjava;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SymGame extends AppCompatActivity {

    private Intent intent;

    Button answer1, answer2, answer3, answer4;

    TextView score, question;

    ImageButton btnBack,btnRule;

    MediaPlayer bckgrnd;

    int n = 0, u=0;

    private final SymQuestion SymQ = new SymQuestion();


    private String mSymAnswer;

    private int mSymScore = 0;
    //問題題目數
    private int mSymQuestionsLength = SymQ.SymQ.length;
    MediaPlayer bckgrnd3;

    Random r;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        btnBack = findViewById(R.id.btn_back);
        btnRule = findViewById(R.id.btn_rule);

        score.setText("Score: " + mSymScore);


        r = new Random();

        //隨機題目
        updateQuestion(r.nextInt(mSymQuestionsLength));

        //答案判斷
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer1.getText() == mSymAnswer) {
                    mSymScore++;
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    n++;
                }else {
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    n++;
                }
                if (n == 10){
                    endGame();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer2.getText() == mSymAnswer) {
                    mSymScore++;
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    n++;
                }else {
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    n++;
                }
                if (n == 10){
                    endGame();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer3.getText() == mSymAnswer) {
                    mSymScore++;
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    n++;
                }else {
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    u++;
                    n++;
                }
                if (n == 10){
                    endGame();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer4.getText() == mSymAnswer) {
                    mSymScore++;
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    n++;
                }else {
                    score.setText("Score: " + mSymScore);
                    updateQuestion(r.nextInt(mSymQuestionsLength));
                    n++;
                }
                if (n == 10){
                    endGame();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rule.class);
                startActivity(intent);
            }
        });

    }
    //從SymQuestion檔案抓取題目跟答案
    private void updateQuestion(int num) {
        
        question.setText(SymQ.getQuestion(num));
        answer1.setText(SymQ.getChoice1(num));
        answer2.setText(SymQ.getChoice2(num));
        answer3.setText(SymQ.getChoice3(num));
        answer4.setText(SymQ.getChoice4(num));

        mSymAnswer = SymQ.getCorrectAnswer(num);
    }


    //遊戲結束時的畫面
    private void endGame() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SymGame.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mSymScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), SymGame.class));
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                bckgrnd3.stop();

                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}