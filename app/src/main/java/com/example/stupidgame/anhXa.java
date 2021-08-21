package com.example.stupidgame;

import java.util.ArrayList;

public class anhXa {
    private ArrayList<Bird> arrayBird = new ArrayList<>();

    public ArrayList<Bird> getArrayBird() {
        return arrayBird;
    }

    public void setArrayBird(ArrayList<Bird> arrayBird) {
        this.arrayBird = arrayBird;
    }
    private void addItemToArray() {
        arrayBird.add(new Bird(0, R.drawable.red1));
        arrayBird.add(new Bird(1, R.drawable.red2));
        arrayBird.add(new Bird(2, R.drawable.red3));
        arrayBird.add(new Bird(3, R.drawable.blue1));
        arrayBird.add(new Bird(4, R.drawable.blue2));
        arrayBird.add(new Bird(5, R.drawable.blue3));
        arrayBird.add(new Bird(6, R.drawable.black1));
        arrayBird.add(new Bird(7, R.drawable.black2));
        arrayBird.add(new Bird(8, R.drawable.black3));
        arrayBird.add(new Bird(9, R.drawable.white1));
        arrayBird.add(new Bird(10, R.drawable.white2));
        arrayBird.add(new Bird(11, R.drawable.white3));
        arrayBird.add(new Bird(12, R.drawable.pink1));
        arrayBird.add(new Bird(13, R.drawable.pink2));
        arrayBird.add(new Bird(14, R.drawable.pink3));
        arrayBird.add(new Bird(15, R.drawable.green1));
        arrayBird.add(new Bird(16, R.drawable.green2));
        arrayBird.add(new Bird(17, R.drawable.green3));
        arrayBird.add(new Bird(18, R.drawable.yellow1));
        arrayBird.add(new Bird(19, R.drawable.yellow2));
        arrayBird.add(new Bird(20, R.drawable.yellow3));
    }
    public ArrayList<Bird> getArrayList() {
        addItemToArray();
        return this.arrayBird;
    }
}
