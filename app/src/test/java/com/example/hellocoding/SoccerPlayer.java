package com.example.hellocoding;

import java.util.ArrayList;
import java.util.List;

public class SoccerPlayer {
    public int skillLevel;
    public int age;
    public String name;
}

class SoccerTeam {
    public String teamName;
    public String country;
    public List<SoccerPlayer> soccerPlayers;
}

class Practice {
    public void practice() {
        SoccerPlayer player1 = new SoccerPlayer();
        player1.name = "Messi";
        player1.age = 28;
        player1.skillLevel = 5;

        SoccerPlayer player2 = new SoccerPlayer();
        player2.name = "Dempsy";
        player2.age = 35;
        player2.skillLevel = 2;

        SoccerPlayer player3 = new SoccerPlayer();
        player3.name = "Kyungmin";
        player3.age = 30;
        player3.skillLevel = -5;

        List<SoccerPlayer> soccerPlayers = new ArrayList<>();
        soccerPlayers.add(player1);
        soccerPlayers.add(player2);
        soccerPlayers.add(player3);

        SoccerTeam happyTuesdaySoccerTeam = new SoccerTeam();
        happyTuesdaySoccerTeam.country = "US";
        happyTuesdaySoccerTeam.teamName = "Happy Tuesday";
        happyTuesdaySoccerTeam.soccerPlayers = soccerPlayers;
    }
}