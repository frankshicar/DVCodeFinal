package com.example.caculatetestjava;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SymGame extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView score, question;

    int n = 0;

    private final SymQuestion SymQ = new SymQuestion();

    // 問題答案
    private String mSymAnswer;
    // 初始分數
    private int mSymScore = 0;
    // 問題題目數
    private int mSymQuestionsLength = SymQ.SymQ.length;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        r = new Random();

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        score = findViewById(R.id.score);
        question = findViewById(R.id.question);

        score.setText("Score: " + mSymScore);

        updateQuestion(r.nextInt(mSymQuestionsLength));

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
    }

    private void updateQuestion(int num) {
        
        question.setText(SymQ.getQuestion(num));
        answer1.setText(SymQ.getChoice1(num));
        answer2.setText(SymQ.getChoice2(num));
        answer3.setText(SymQ.getChoice3(num));
        answer4.setText(SymQ.getChoice4(num));

        mSymAnswer = SymQ.getCorrectAnswer(num);
    }

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
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}