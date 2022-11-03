package com.example.work2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    int redPoints, bluePoints;
    Intent gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);


        gi = getIntent();
        redPoints = gi.getIntExtra("redPoints", -1);
        bluePoints = gi.getIntExtra("bluePoints", -1);
        tv1.setText("Red=" + redPoints );
        tv2.setText("Blue=" + bluePoints);
        if(redPoints > bluePoints)
        {
            tv3.setText("Red Won!");
        }
        else if (bluePoints > redPoints)
        {
            tv3.setText("Blue Won!");
        }
        else
        {
            tv3.setText("TIE");
        }
    }

    public void returnTo(View view) {
        gi.putExtra("redPoints", 0);
        gi.putExtra("bluePoints", 0);
        setResult(RESULT_OK, gi);
        finish();
    }
}