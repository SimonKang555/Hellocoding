package com.example.hellocoding.ranking;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ranking_table")
public class Ranking {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    @ColumnInfo(name = "username")
    public String username;
    @NonNull
    @ColumnInfo(name = "timeTaken")
    public String timeTaken;

    public Ranking(@NonNull String username, @NonNull String timeTaken) {
        this.username = username;
        this.timeTaken = timeTaken;
    }
}