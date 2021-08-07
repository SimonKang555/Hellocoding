package com.example.hellocoding;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class GamePlayActivity extends AppCompatActivity {
    int currentAttackPower = 1;
    int timesClicked = 0;
    int currentSeconds = 0;
    int opponentsHP = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayactivity);

        showDialog().show();

        Button button3 = findViewById(R.id.button3);
        TextView resultTextView = findViewById(R.id.textView4);
        Button Restart = findViewById(R.id.Restart);

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

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
    }

    private void initiate() {
        TextView timerTextView = findViewById(R.id.textView5);
        TextView opponentsHpTextView = findViewById(R.id.opponentsHP);
        ImageView warrior = findViewById(R.id.imageView2);
        ImageView ourBase = findViewById(R.id.imageView4);
        ImageView opponent = findViewById(R.id.imageView5);
        TextView userName = findViewById(R.id.userName);
        CountDownTimer countDownTimer = new CountDownTimer(999999999, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentSeconds = currentSeconds + 1;
                timerTextView.setText(currentSeconds + " Seconds");
                opponentsHP = opponentsHP - currentAttackPower;
                opponentsHpTextView.setText("HP: " + opponentsHP);

                if (currentSeconds % 2 == 0) {
                    warrior.setImageResource(R.drawable.warriorattack);
                } else if (currentSeconds % 2 == 1) {
                    warrior.setImageDrawable(getDrawable(R.drawable.warriorattack2));
                }

                if (opponentsHP <= 0) {
                    Toast.makeText(getApplicationContext(), " You won in " + currentSeconds + " seconds. Congrats! ", Toast.LENGTH_LONG).show();
                    cancel();
                }
            }

            @Override
            public void onFinish() { }
        };

        warrior.post(() -> {
            TranslateAnimation animation = new TranslateAnimation(0, opponent.getX() - warrior.getWidth() - ourBase.getWidth(),0 , 0);
            animation.setDuration(5000);
            animation.setFillAfter(true);
            warrior.startAnimation(animation);
        });

        warrior.postDelayed(() -> {
            countDownTimer.start();
            warrior.postOnAnimation(warrior::clearAnimation);
            warrior.setX((opponent.getX() - warrior.getWidth() + 20));

        }, 5000);

    }

    private Dialog showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = getLayoutInflater();

        builder.setCancelable(false);

        View view = inflater.inflate(R.layout.dialog, null);
        EditText userNameEditText = view.findViewById(R.id.username);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String userName = userNameEditText.getText().toString();

                        if (userName.length() < 1) {
                            Toast.makeText(getApplicationContext(), "Enter Username", Toast.LENGTH_SHORT).show();
                            showDialog().show();
                        } else if (userName.length() > 0) {
                            initiate();
                        }
                    }
                });
        return builder.create();
    }

//    public static class UsernameDialog extends DialogFragment {
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//            // Get the layout inflater
//            LayoutInflater inflater = requireActivity().getLayoutInflater();
//
//            // Inflate and set the layout for the dialog
//            // Pass null as the parent view because its going in the dialog layout
//            builder.setView(inflater.inflate(R.layout.dialog, null))
//                    // Add action buttons
//                    .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int id) {
//                        }
//                    });
//            return builder.create();
//        }
//    }
}