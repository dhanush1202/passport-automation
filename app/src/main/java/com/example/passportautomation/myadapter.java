package com.example.passportautomation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.MyViewHolder>
{
    Context context;
    ArrayList<ArrayList<String>> list;

    public myadapter(Context context, ArrayList<ArrayList<String>> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.MyViewHolder holder, int position) {
        ArrayList<String> user=list.get(position);
        holder.name.setText(users.getName());
        holder.mail.setText(users.getEmail());
        holder.pan.setText(users.getPan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,mail,pan;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Name1);
            mail=itemView.findViewById(R.id.mail);
            pan=itemView.findViewById(R.id.Pan);


        }
    }
}
