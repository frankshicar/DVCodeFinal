package com.example.caculatetestjava;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class AnsGame extends AppCompatActivity {

    EditText answer;
    TextView score, question;
    Button btn;
    int i = 0;

    private AnsQuestion mQuestions = new AnsQuestion();

    // 問題答案

    String Answer, mAnswer;
    // 初始分數
    private int mScore = 0;
    // 問題題目數
    private int mQuestionsLength = mQuestions.AnsQ.length;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_game);

        r = new Random();

        answer = findViewById(R.id.Ans);
        btn = findViewById(R.id.button);
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);
        Answer = String.valueOf(answer.getText());
        score.setText("Score: " + mScore);


        updateQuestion(r.nextInt(mQuestionsLength));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    question.setText(answer.getText());
                if (mAnswer.compareTo(String.valueOf(answer.getText())) == 0) {
                    mScore++;
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    i++;
                    answer.setText("");
                }else {
                    score.setText("Score: " + mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                    i++;
                    answer.setText("");
                }
                if (i == 10){
                    endGame();
                }
//                updateQuestion(r.nextInt(mQuestionsLength));
            }
        });


    }

    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }



    private void endGame(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AnsGame.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points.")
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
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}