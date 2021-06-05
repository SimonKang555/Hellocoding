package com.example.hellocoding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    public List<Person> data = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewHolder holder, int position) {
        holder.textViewName.setText( data.get(position).name);
        holder.textViewGrade.setText(data.get(position).grade);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List<Person> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}

class Person {
    public String name;
    public String grade;

    public Person(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewName;
    public TextView textViewGrade;

    public RecyclerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        this.textViewName = itemView.findViewById(R.id.textViewName);
        this.textViewGrade = itemView.findViewById(R.id.textViewGrade);
    }
}