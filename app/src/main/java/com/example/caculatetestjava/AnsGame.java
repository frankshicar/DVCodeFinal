package com.example.caculatetestjava;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AnsGame extends AppCompatActivity {

    Button answer01, answer02, answer03, answer04;

    TextView ANSscore, ANSquestion;

    private final AnsQuestion AnsQ = new AnsQuestion();

    // 問題答案
    private String mAnswer;
    // 初始分數
    private int mANSScore = 0;
    // 問題題目數
    private int mQuestionsLength = AnsQ.AnsQ.length;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_game);
        r = new Random();

        answer01 = findViewById(R.id.ANSanswer1);
        answer02 = findViewById(R.id.ANSanswer2);
        answer03 = findViewById(R.id.ANSanswer3);
        answer04 = findViewById(R.id.ANSanswer4);

        ANSscore = findViewById(R.id.ANSscore);
        ANSquestion = findViewById(R.id.ANSquestion);

        ANSscore.setText("Score: " + mANSScore);

        updateQuestion(r.nextInt(mQuestionsLength));

        answer01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer01.getText() == mAnswer) {
                    mANSScore++;
                    ANSscore.setText("Score: " + mANSScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });

        answer02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer02.getText() == mAnswer) {
                    mANSScore++;
                    ANSscore.setText("Score: " + mANSScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });

        answer03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer03.getText() == mAnswer) {
                    mANSScore++;
                    ANSscore.setText("Score: " + mANSScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });

        answer04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer04.getText() == mAnswer) {
                    mANSScore++;
                    ANSscore.setText("Score: " + mANSScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion(int num) {
        ANSquestion.setText(AnsQ.getQuestion(num));
        answer01.setText(AnsQ.getChoice1(num));
        answer02.setText(AnsQ.getChoice2(num));
        answer03.setText(AnsQ.getChoice3(num));
        answer04.setText(AnsQ.getChoice4(num));

        mAnswer = AnsQ.getCorrectAnswer(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AnsGame.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mANSScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), AnsGame.class));
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}