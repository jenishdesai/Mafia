package com.game.mafia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import com.game.mafia.databinding.ActivityCloseEyesBinding;
import com.game.mafia.databinding.ActivityPlayerRoleBinding;

import java.util.Locale;

public class CloseEyesActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    String text = "सभी खिलाड़ी अपनी आंखें बंद करें";

    ActivityCloseEyesBinding binding;

    int counter = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCloseEyesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {

                    binding.text.setText("All Players Close Your Eyes");
                    textToSpeech.setLanguage(new Locale ("hi","IN"));
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);


                }
            }
        });

        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){
                binding.textview.setText(String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){

                startActivity(new Intent(CloseEyesActivity.this,MainActivity.class));
            }
        }.start();






    }
}