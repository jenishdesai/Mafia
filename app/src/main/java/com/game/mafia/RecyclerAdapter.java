package com.game.mafia;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewholder> {

    Activity activity;
    List<ModelClass> arrayList;

    public RecyclerAdapter(Activity activity, List<ModelClass> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout_playerlist,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        ModelClass model = arrayList.get(position);

        holder.username.setText(model.getPlayerName());




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView username;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.player_name);

        }
    }
}
