package com.game.mafia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.game.mafia.databinding.ActivityPlayerNameBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlayerNameActivity extends AppCompatActivity {

    ActivityPlayerNameBinding binding;

    DatabaseReference databaseReference;


    List<ModelClass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerNameBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        databaseReference = FirebaseDatabase.getInstance().getReference("Player");

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference = FirebaseDatabase.getInstance().getReference("Player");
                arrayList = new ArrayList<>();

                PlayerName();
                startActivity(new Intent(PlayerNameActivity.this,PlayerListActivity.class));

            }
        });

    }

    private void PlayerName() {
        String username = binding.edtUsername.getText().toString();

        if(!username.isEmpty()){

            String id = databaseReference.push().getKey();

            ModelClass model = new ModelClass(id,username);

            databaseReference.child(id).setValue(model);

            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show();
        }
        else{
            binding.edtUsername.setError("Enter Your Username");
            Toast.makeText(this, "Enter Your Name", Toast.LENGTH_SHORT).show();
        }
    }

}