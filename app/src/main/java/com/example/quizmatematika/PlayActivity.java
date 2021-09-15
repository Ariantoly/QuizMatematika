package com.example.quizmatematika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmatematika.Model.User;

import java.util.ArrayList;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    public static final String EXTRA_OBJECT_USER = "extra_object_user";

    private Integer ans;
    private String question, answer = "";
    private TextView tv_question, tv_answer, tv_score;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_submit, btn_erase;
    Random rand = new Random();

    protected void onCreate(Bundle savedInstanceState) {
        Integer num1, num2;
        String question;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        initialize();

        num1 = Math.abs(rand.nextInt() % 101);
        num2 = Math.abs(rand.nextInt() % 101);
        ans = num1 + num2;
        question = num1 + " + " + num2 + " = ";
        tv_question.setText(question);

        User user = (User) getIntent().getSerializableExtra(EXTRA_OBJECT_USER);
        tv_score.setText("Score: " + user.getScore());

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "1";
                tv_answer.setText(answer);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "2";
                tv_answer.setText(answer);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "3";
                tv_answer.setText(answer);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "4";
                tv_answer.setText(answer);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "5";
                tv_answer.setText(answer);
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "6";
                tv_answer.setText(answer);
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "7";
                tv_answer.setText(answer);
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "8";
                tv_answer.setText(answer);
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "9";
                tv_answer.setText(answer);
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer += "0";
                tv_answer.setText(answer);
            }
        });

        btn_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer.length() > 0){
                    answer = answer.substring(0, answer.length() - 1);
                    tv_answer.setText(answer);
                }
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_answer.getText().toString().equals(ans.toString()))
                    user.setScore(user.getScore() + 10);
                else
                    user.setScore(user.getScore() - 10);
                MainActivity.listUser.set(MainActivity.listUser.size() - 1, user).setScore(user.getScore());
                Intent refresh = new Intent(PlayActivity.this, PlayActivity.class);
                refresh.putExtra(PlayActivity.EXTRA_OBJECT_USER, user);
                finish();
                startActivity(refresh);
            }

        });

    }

    private void initialize(){
        tv_question = findViewById(R.id.tv_question);
        tv_answer = findViewById(R.id.tv_answer);
        tv_score = findViewById(R.id.tv_score);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        btn_erase = findViewById(R.id.btn_erase);
        btn_submit = findViewById(R.id.btn_submit);
    }
}
