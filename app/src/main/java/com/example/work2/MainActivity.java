package com.example.work2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button btnSingle, btnDouble, buttonWinner;
    int countS, countD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSingle = (Button) findViewById(R.id.button2);
        btnDouble = (Button) findViewById(R.id.button);
        buttonWinner = (Button) findViewById(R.id.button3);
        countD = 0;
        countS = 0;


        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countS++;

            }
        });

        btnDouble.setOnLongClickListener(this);
    }


    @Override
    public boolean onLongClick(View view) {
        countD+=2;
        return true;
    }

    public void MoveNext(View view) {
        Intent si = new Intent(this, MainActivity2.class);
        si.putExtra("bluePoints", countS);
        si.putExtra("redPoints", countD);
        startActivityForResult(si, 1);

    }

    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (source == 1) {
            countS = data_back.getIntExtra("bluePoints", -1);
            countD = data_back.getIntExtra("redPoints", -1);
        }
    }
}