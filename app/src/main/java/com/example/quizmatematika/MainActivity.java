package com.example.quizmatematika;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizmatematika.Model.User;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_name;
    private Button btn_play, btn_viewScore;
    public static ArrayList<User> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        btn_play = findViewById(R.id.btn_play);
        btn_viewScore = findViewById(R.id.btn_viewScore);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateName()){
                    Intent intent = new Intent(MainActivity.this, PlayActivity.class);

                    User user = new User();
                    user.setName(et_name.getText().toString());
                    user.setScore(0);
                    listUser.add(user);
                    intent.putExtra(PlayActivity.EXTRA_OBJECT_USER, user);
                    startActivity(intent);
//                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please input your name", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn_viewScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);

                intent.putExtra(ScoreActivity.EXTRA_OBJECT_USER, listUser);
                startActivity(intent);
//                finish();
            }
        });
    }

    private boolean validateName(){
        if(et_name.getText().toString().equals("")) return false;

        return true;
    }
}