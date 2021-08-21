package com.example.stupidgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.Bidi;
import java.util.ArrayList;
import java.util.Random;

public class ChooseBird extends AppCompatActivity {
    GridView gvChooseBirds;
    public ArrayList<Bird> arrayBird, arrayBirdRandom;
    birdAdapter adapter;
    Bird unknownBird1, unknownBird2, unknownBird3;
    int numberIsChosen = 0;
    ImageView imgChosenBird1, imgChosenBird2, imgChosenBird3;
    int RESULT_CODE_BIRD1 = 1,
        RESULT_CODE_BIRD2 = 2,
        RESULT_CODE_BIRD3 = 3;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_bird);

        anhXa();
        Intent intent = getIntent();
        Bundle bundleGet = intent.getBundleExtra("bundleSend");
        unknownBird1 = (Bird) bundleGet.getSerializable("unknownBird1");
        unknownBird2 = (Bird) bundleGet.getSerializable("unknownBird2");
        unknownBird3 = (Bird) bundleGet.getSerializable("unknownBird3");

        randomArray();
        adapter = new birdAdapter(ChooseBird.this, R.layout.each_bird, arrayBirdRandom);
        gvChooseBirds.setAdapter(adapter);
        gvChooseBirds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent toMainActivity = new Intent();
                Bird bird = arrayBirdRandom.get(i);
                switch (numberIsChosen) {
                    case 0: {
                        imgChosenBird1.setImageResource(bird.getImgRes());
                        bundle.putSerializable("chosenBird1", bird);
                        break;
                    }
                    case 1: {
                        imgChosenBird2.setImageResource(bird.getImgRes());
                        bundle.putSerializable("chosenBird2", bird);
                        break;
                    }
                    case 2: {
                        imgChosenBird3.setImageResource(bird.getImgRes());
                        bundle.putSerializable("chosenBird3", bird);
                        toMainActivity.putExtra("bundle", bundle);
                        setResult(RESULT_OK, toMainActivity);
                        finish();
                    }
                }
                numberIsChosen++;
            }
        });

    }
    private void randomArray() {
        arrayBirdRandom = new ArrayList<>();
        int i;
        Bird bird;
        Random random = new Random();
        for (i = 0; i < arrayBird.size(); i++) {
            bird = arrayBird.get(random.nextInt(arrayBird.size()));
            arrayBirdRandom.add(i, bird);
        }
        int ran1 = -1, ran2 = -1, ran3 = -1;
        while (ran1 == ran2 || ran1 == ran3 || ran2 == ran3) {
            ran1 = random.nextInt(arrayBird.size());
            ran2 = random.nextInt(arrayBird.size());
            ran3 = random.nextInt(arrayBird.size());
        }
        arrayBirdRandom.set(ran1, unknownBird1);
        arrayBirdRandom.set(ran2, unknownBird2);
        arrayBirdRandom.set(ran3, unknownBird3);
    }
    private void anhXa() {
        gvChooseBirds = findViewById(R.id.gvBirds);
        imgChosenBird1 = findViewById(R.id.imgChosenBird1);
        imgChosenBird2 = findViewById(R.id.imgChosenBird2);
        imgChosenBird3 = findViewById(R.id.imgChosenBird3);

        anhXa addArray = new anhXa();
        arrayBird = addArray.getArrayList();
    }
}