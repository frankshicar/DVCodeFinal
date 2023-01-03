package com.example.caculatetestjava;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class AnsGame extends AppCompatActivity {

    EditText answer;
    TextView score, question;
    Button btn;
    ImageButton btnBack,btnRule;
    private Intent intent;


    int i = 0;

    private AnsQuestion mQuestions = new AnsQuestion();

    MediaPlayer bckgrnd2;

    String Answer, mAnswer;

    private int mScore = 0;
    //問題題目數
    private int mQuestionsLength = mQuestions.AnsQ.length;

    Random r;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_game);




        answer = findViewById(R.id.Ans);
        btn = findViewById(R.id.button);
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);
        Answer = String.valueOf(answer.getText());
        score.setText("Score: " + mScore);
        btnBack=findViewById(R.id.btn_back);
        btnRule=findViewById(R.id.btn_rule);


        r = new Random();

        //隨機題目
        updateQuestion(r.nextInt(mQuestionsLength));

        //答案判斷
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });
        //回到主畫面
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //規則頁面
        btnRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rule.class);
                startActivity(intent);
            }
        });



    }

    //從AnsQuestion檔案抓取題目跟答案
    private void updateQuestion(int num) {
        question.setText(mQuestions.getQuestion(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }


    //遊戲結束時的畫面
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
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                                bckgrnd2.stop();
                                bckgrnd2.release();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}