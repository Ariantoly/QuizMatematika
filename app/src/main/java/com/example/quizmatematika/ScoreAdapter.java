package com.example.quizmatematika;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizmatematika.Model.User;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder> {

    ArrayList<User> listUser;

    public ScoreAdapter(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.score_layout, parent, false);
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        User user = listUser.get(position);

        holder.tv_listScore.setText(user.getName() + " - " + user.getScore());
    }

    public void addUser(){
        notifyItemInserted(listUser.size());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class ScoreViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_listScore;

        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_listScore = itemView.findViewById(R.id.tv_listScore);
        }
    }
}
