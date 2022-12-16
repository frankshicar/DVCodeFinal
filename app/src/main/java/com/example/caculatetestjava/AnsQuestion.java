package com.example.caculatetestjava;

public class AnsQuestion {
    public String AnsQ[] = {
            "33+12=45",
            "120/4=30",
            "130-34=96",
            "130*2=260",
            "65*3=315"
    };
    private String mAnsChoices[][] = {
            {"+","-","*","/"},
            {"+","-","*","/"},
            {"+","-","*","/"},
            {"+","-","*","/"}
    };
    private  String AnsCorrectAns[]={
            "+", "/", "-", "*", "*"
    };

    public String getQuestion(int a){
        String question = AnsQ[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mAnsChoices[a][0];
        return  choice;
    };

    public String getChoice2(int a) {
        String choice = mAnsChoices[a][1];

        return  choice;
    };

    public String getChoice3(int a) {
        String choice = mAnsChoices[a][2];
        return  choice;
    };

    public String getChoice4(int a) {
        String choice = mAnsChoices[a][3];
        return  choice;
    };

    public String getCorrectAnswer(int a) {
        String answer = AnsCorrectAns[a];
        return answer;
    }
}
