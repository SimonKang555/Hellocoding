package com.example.hellocoding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.text.BreakIterator;
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
        Context context = holder.itemView.getContext();
        holder.textViewName.setText( data.get(position).name);
        holder.textViewGrade.setText(data.get(position).grade);
        holder.textViewHairColor.setText(data.get(position).hairColor);
        holder.textViewFood.setText(data.get(position).food);
        if (data.get(position).hairColor == "Black") {
            holder.textViewHairColor.setTextColor(context.getColor(R.color.black));
        } if (data.get(position).hairColor == "Red") {
            holder.textViewHairColor.setTextColor(context.getColor(R.color.purple_200));
        }
        holder.imageView.setImageResource(data.get(position).foodImage);
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
    public String hairColor;
    public String food;
    public int foodImage;
}

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewName;
    public TextView textViewGrade;
    public TextView textViewHairColor;
    public TextView textViewFood;
    public ImageView imageView;

    public RecyclerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        this.textViewName = itemView.findViewById(R.id.textViewName);
        this.textViewGrade = itemView.findViewById(R.id.textViewGrade);
        this.textViewHairColor = itemView.findViewById(R.id.textViewHairColor);
        this.textViewFood = itemView.findViewById(R.id.textViewFood);
        this.imageView = itemView.findViewById(R.id.imageView);
    }
}