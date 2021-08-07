package com.example.hellocoding.ranking;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hellocoding.MyApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Ranking.class}, version = 1, exportSchema = false)
public abstract class RankingRoomDatabase extends RoomDatabase {

    public abstract RankingDao diaryDao();

    private static volatile RankingRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RankingRoomDatabase getDatabase() {
        if (INSTANCE == null) {
            synchronized (RankingRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(MyApplication.getInstance(),
                            RankingRoomDatabase.class, "ranking_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}