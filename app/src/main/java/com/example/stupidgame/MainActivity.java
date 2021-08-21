package com.example.stupidgame;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Bird> arrayBird;
    ImageView imgUBird1, imgUBird2, imgUBird3,
            imgChosenBird1, imgChosenBird2, imgChosenBird3;
    TextView txtHint;
    Bird unknownBird1, unknownBird2, unknownBird3,
        chosenBird1, chosenBird2, chosenBird3;
    LinearLayout linearTouchable;
    int CHOOSE_BIRD_REQUEST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        reset();

        linearTouchable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChooseBird.class);
                Bundle bundleSend = new Bundle();
                bundleSend.putSerializable("unknownBird1", unknownBird1);
                bundleSend.putSerializable("unknownBird2", unknownBird2);
                bundleSend.putSerializable("unknownBird3", unknownBird3);
                intent.putExtra("bundleSend", bundleSend);
                startActivityForResult(intent, CHOOSE_BIRD_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CHOOSE_BIRD_REQUEST &&
            resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getBundleExtra("bundle");
            chosenBird1 = (Bird) bundle.getSerializable("chosenBird1");
            chosenBird2 = (Bird) bundle.getSerializable("chosenBird2");
            chosenBird3 = (Bird) bundle.getSerializable("chosenBird3");
            setChosenBirdImg();
            checkBird();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void checkBird() {
        if (unknownBird1.getId() == chosenBird1.getId()
            && unknownBird2.getId() == chosenBird2.getId()
            && unknownBird2.getId() == chosenBird2.getId()) {

            txtHint.setText("Correct, Congratulation!!!");
        }
        else {
            txtHint.setText("Incorrect, please choose again!");
        }

    }
    private void setChosenBirdImg() {
        imgChosenBird1.setImageResource(chosenBird1.getImgRes());
        imgChosenBird2.setImageResource(chosenBird2.getImgRes());
        imgChosenBird3.setImageResource(chosenBird3.getImgRes());
    }
    private void reset() {
        txtHint.setText("Choose the birds in right order!");
        unknownBird1 = arrayBird.get(ranDomIndex());
        unknownBird2 = arrayBird.get(ranDomIndex());
        unknownBird3 = arrayBird.get(ranDomIndex());
        chosenBird1 = arrayBird.get(ranDomIndex());
        chosenBird2 = arrayBird.get(ranDomIndex());
        chosenBird3 = arrayBird.get(ranDomIndex());

        imgUBird1.setImageResource(unknownBird1.getImgRes());
        imgUBird2.setImageResource(unknownBird2.getImgRes());
        imgUBird3.setImageResource(unknownBird3.getImgRes());
        imgChosenBird1.setImageResource(chosenBird1.getImgRes());
        imgChosenBird2.setImageResource(chosenBird2.getImgRes());
        imgChosenBird3.setImageResource(chosenBird3.getImgRes());
    }
    private int ranDomIndex() {
        Random random = new Random();
        int index = random.nextInt(arrayBird.size());
        return index;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh) {
            reset();
        }
        return super.onOptionsItemSelected(item);

    }

    private void anhXa() {
        linearTouchable = findViewById(R.id.linearTouchable);
        imgUBird1 = findViewById(R.id.imgUBird1);
        imgUBird2 = findViewById(R.id.imgUBird2);
        imgUBird3 = findViewById(R.id.imgUBird3);
        imgChosenBird1 = findViewById(R.id.imgMainChosenBird1);
        imgChosenBird2 = findViewById(R.id.imgMainChosenBird2);
        imgChosenBird3 = findViewById(R.id.imgMainChosenBird3);
        txtHint = findViewById(R.id.txtHint);

        anhXa addArray = new anhXa();
        arrayBird = addArray.getArrayList();

    }
}