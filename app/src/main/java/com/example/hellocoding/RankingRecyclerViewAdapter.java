package com.example.hellocoding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellocoding.ranking.Ranking;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RankingRecyclerViewAdapter extends RecyclerView.Adapter<RankingRecyclerViewHolder> {

    public List<Ranking> data = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public RankingRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_item, parent, false);
        return new RankingRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RankingRecyclerViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        holder.rankingNumber.setText( data.get(position).rankingNumber);
        holder.rankingUserName.setText(data.get(position).username);
        holder.rankingTimeTaken.setText(data.get(position).timeTaken);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updateData(List<Ranking> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}

class RankingRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView rankingNumber;
    public TextView rankingUserName;
    public TextView rankingTimeTaken;

    public RankingRecyclerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        rankingNumber = itemView.findViewById(R.id.rankingNumber);
        rankingUserName = itemView.findViewById(R.id.rankingUserName);
        rankingTimeTaken = itemView.findViewById(R.id.rankingTimeTaken);
    }
}