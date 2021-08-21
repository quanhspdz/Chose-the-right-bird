package com.example.stupidgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class wellcome_activity extends AppCompatActivity {
    ConstraintLayout cstrainMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        cstrainMain = findViewById(R.id.cstrainMain);
        Intent intent = new Intent(wellcome_activity.this, MainActivity.class);
        cstrainMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}