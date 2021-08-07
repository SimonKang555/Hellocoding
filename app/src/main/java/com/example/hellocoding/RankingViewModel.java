package com.example.hellocoding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.hellocoding.ranking.Ranking;
import com.example.hellocoding.ranking.RankingRepository;

import java.util.List;

public class RankingViewModel extends ViewModel {

    private RankingRepository repository = new RankingRepository();

    private final LiveData<List<Ranking>> rankings = repository.getRankings();

    LiveData<List<Ranking>> getRankings() { return rankings; }

    public void insert(Ranking ranking) { repository.insert(ranking); }
}