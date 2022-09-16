package com.game.mafia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.game.mafia.databinding.ActivityPlayerListBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlayerListActivity extends AppCompatActivity {

    ActivityPlayerListBinding binding;

    DatabaseReference databaseReference;


    List<ModelClass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        databaseReference = FirebaseDatabase.getInstance().getReference("Player");
        arrayList = new ArrayList<>();

        onClick();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                arrayList.clear();

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    ModelClass model = dataSnapshot.getValue(ModelClass.class);

                    arrayList.add(model);
                }
                binding.recycler.setLayoutManager(new LinearLayoutManager(PlayerListActivity.this));
                RecyclerAdapter adapter = new RecyclerAdapter(PlayerListActivity.this,arrayList);
                binding.recycler.setAdapter(adapter);

                adapter.notifyDataSetChanged();



            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(PlayerListActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

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