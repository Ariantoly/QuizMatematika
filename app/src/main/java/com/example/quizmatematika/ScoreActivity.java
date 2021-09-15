package com.example.quizmatematika;

import android.os.Bundle;
import java.io.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmatematika.Model.User;
import com.example.quizmatematika.R;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreActivity extends AppCompatActivity {
    private RecyclerView rvListScore;
    private ScoreAdapter scoreAdapter;
    private ArrayList<User> listUser;
    public static final String EXTRA_OBJECT_USER = "extra_object_user";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        rvListScore = findViewById(R.id.rv_listScore);

        listUser = (ArrayList<User>) getIntent().getSerializableExtra(EXTRA_OBJECT_USER);

        scoreAdapter = new ScoreAdapter(listUser);
        rvListScore.setAdapter(scoreAdapter);
        rvListScore.setLayoutManager(new LinearLayoutManager(this));
        scoreAdapter.addUser();
    }
}
