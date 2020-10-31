package com.example.diceroller;


public class Dice {
    private int number;

    public Dice(){
        setNumber(number);
    }

    public int setNumber(int number){
        switch(number){
            case 1:
                return R.drawable.dice_1;
            case 2:
                return R.drawable.dice_2;
            case 3:
                return R.drawable.dice_3;
            case 4:
               return R.drawable.dice_4;
            case 5:
                return R.drawable.dice_5;
            case 6:
               return  R.drawable.dice_6;
            default:
                return 0;
        }
    }
}
