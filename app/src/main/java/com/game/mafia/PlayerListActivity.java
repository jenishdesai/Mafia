package com.game.mafia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.game.mafia.databinding.ActivityPlayerListBinding;

public class PlayerListActivity extends AppCompatActivity {

    ActivityPlayerListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        onClick();

    }

    private void onClick() {

        binding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(PlayerListActivity.this,PlayerRoleActivity.class));
            }
        });
    }
}