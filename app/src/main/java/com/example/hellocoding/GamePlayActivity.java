package com.example.hellocoding;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GamePlayActivity extends AppCompatActivity {
    int currentAttackPower = 1;
    int timesClicked = 0;
    int currentSeconds = 0;
    int opponentsHP = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayactivity);

        Button button3 = findViewById(R.id.button3);
        TextView resultTextView = findViewById(R.id.textView4);
        TextView timerTextView = findViewById(R.id.textView5);
        TextView opponentsHpTextView = findViewById(R.id.opponentsHP);
        ImageView warrior = findViewById(R.id.imageView2);
        ImageView opponent = findViewById(R.id.imageView5);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timesClicked = timesClicked + 1;
                if (timesClicked == 11) {
                    // Can you explain me why we need to create a new variable?
                    timesClicked = 1;
                    currentAttackPower = currentAttackPower + 1;
                    String Powe45 = "Current Attack Power: " + currentAttackPower;
                    resultTextView.setText(Powe45);
                }
            }
        });

        CountDownTimer countDownTimer = new CountDownTimer(999999999, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentSeconds = currentSeconds + 1;
                timerTextView.setText(currentSeconds + " Seconds");
                opponentsHP = opponentsHP - currentAttackPower;
                opponentsHpTextView.setText("HP: " + opponentsHP);
                if (opponentsHP <= 0) {
                    Toast.makeText(getApplicationContext(), " You won in " + currentSeconds + " seconds. Congrats! ", Toast.LENGTH_LONG).show();
                    cancel();
                }
            }

            @Override
            public void onFinish() { }
        };

        warrior.post(() -> {
            TranslateAnimation animation = new TranslateAnimation(0, opponent.getX() - warrior.getWidth() - opponent.getWidth(),0 , 0);
            animation.setDuration(5000);
            animation.setFillAfter(true);
            warrior.startAnimation(animation);
        });

        warrior.postDelayed(() -> {
            countDownTimer.start();
            warrior.setX((opponent.getX() - warrior.getWidth()));

            Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
            warrior.startAnimation(aniRotate);
        }, 5000);

    }
}