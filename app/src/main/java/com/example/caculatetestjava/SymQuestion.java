package com.example.caculatetestjava;

public class SymQuestion {
    public String SymQ[] = {
            "33+12=45",
            "120/4=30",
            "130-34=96",
            "130*2=260",
            "65*3=315"
    };
    private String mChoices[][] = {
            {"+","-","*","/"},
            {"+","-","*","/"},
            {"+","-","*","/"},
            {"+","-","*","/"},
            {"+","-","*","/"}
    };
    private  String CorrectAns[]={
            "+", "/", "-", "*", "*"
    };

    public String getQuestion(int a){
        String question = SymQ[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return  choice;
    };

    public String getChoice2(int a) {
        String choice = mChoices[a][1];

        return  choice;
    };

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return  choice;
    };

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return  choice;
    };

    public String getCorrectAnswer(int a) {
        String answer = CorrectAns[a];
        return answer;
    }
}
