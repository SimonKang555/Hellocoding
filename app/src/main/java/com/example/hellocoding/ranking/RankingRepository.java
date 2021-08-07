package com.example.hellocoding.ranking;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RankingRepository {

    private RankingDao rankingDao;
    private LiveData<List<Ranking>> ranking;

    // Note that in order to unit test the DiaryRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public RankingRepository() {
        RankingRoomDatabase db = RankingRoomDatabase.getDatabase();
        rankingDao = db.diaryDao();
        ranking = rankingDao.getRanking();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Ranking>> getRankings() {
        return ranking;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Ranking ranking) {
        RankingRoomDatabase.databaseWriteExecutor.execute(() -> {
            rankingDao.insert(ranking);
        });
    }
}