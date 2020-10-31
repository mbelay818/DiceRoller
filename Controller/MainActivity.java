package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Dice rDice = new Dice();
    private ImageView dice1, dice2, dice3;
    private ImageView[] DiceImageView;
    private Random ranNum = new Random();
    private MenuItem stopTrue;
    private MenuItem stopFalse;
    private boolean stop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DiceImageView = new ImageView[]{dice1, dice2, dice3};

        dice1 = (ImageView) findViewById(R.id.dice1);
        dice2 = (ImageView) findViewById(R.id.dice2);
        dice3 = (ImageView) findViewById(R.id.dice3);

        DiceImageView[0] = dice1;
        DiceImageView[1] = dice2;
        DiceImageView[2] = dice3;

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu, menu);
         stopTrue = menu.findItem(R.id.action_stop);
         stopFalse = menu.findItem(R.id.action_stop);
         stop = true;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_one:
                MakeDiceVisible(1);
                break;
            case R.id.action_two:
                MakeDiceVisible(2);
                break;
            case R.id.action_three:
                MakeDiceVisible(3);
                break;
            case R.id.action_roll:
                stop = true;
                rollDice();
                stopTrue.setVisible(true);
                break;
            case R.id.action_stop:
                stopFalse.setVisible(false);
                stop = false;
                break;
            default:
                break;
        }
        return true;
    }

    private void MakeDiceVisible(int numVisible) {
        // Make dice visible
        for (int i = 0; i < DiceImageView.length; i++) {
            if (i < numVisible) {
                DiceImageView[i].setVisibility(View.VISIBLE);
            } else {
                DiceImageView[i].setVisibility(View.GONE);

            }
        }
    }

    public void rollDice() {

        new CountDownTimer(5000, 100) {
            public void onTick(long millisUntilFinished) {
                    int num;
                for (int i = 0; i < DiceImageView.length; i++) {
                    num = ranNum.nextInt(6) + 1;
                    switch (num) {
                        case 1:
                            DiceImageView[i].setImageResource(rDice.setNumber(1));
                            break;
                        case 2:
                            DiceImageView[i].setImageResource(rDice.setNumber(2));
                            break;
                        case 3:
                            DiceImageView[i].setImageResource(rDice.setNumber(3));
                            break;
                        case 4:
                            DiceImageView[i].setImageResource(rDice.setNumber(4));
                            break;
                        case 5:
                            DiceImageView[i].setImageResource(rDice.setNumber(5));
                            break;
                        case 6:
                            DiceImageView[i].setImageResource(rDice.setNumber(6));
                            break;
                            }
                            if( stop == false){
                                cancel();
                            }
                }
            }
                public void onFinish() {
                    stopFalse.setVisible(false);
                }
            }.start();
        }
}