package com.game.mafia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;

import com.game.mafia.databinding.ActivityPlayerRoleBinding;

public class PlayerRoleActivity extends AppCompatActivity {

    ActivityPlayerRoleBinding binding;
    public int counter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerRoleBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){
                binding.textview.setText(String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                binding.textview.setText("You are Farmer!!");
            }
        }.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(PlayerRoleActivity.this,CloseEyesActivity.class));

            }
        },15000);
    }
}