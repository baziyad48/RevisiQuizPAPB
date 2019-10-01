package com.example.android.revisiquizpapb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;

public class Proses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses);

        final TextView num1 = (TextView) findViewById(R.id.tv_intent_num1);
        final TextView num2 = (TextView) findViewById(R.id.tv_intent_num2);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            num1.setText(extras.getString("num1"));
            num2.setText(extras.getString("num2"));
        }
        final int temp1 = Integer.valueOf(num1.getText().toString());
        final int temp2 = Integer.valueOf(num2.getText().toString());

        Button plus = (Button) findViewById(R.id.btn_plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.putExtra("message", String.valueOf(temp1 + temp2));
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });

        Button minus = (Button) findViewById(R.id.btn_minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.putExtra("message", String.valueOf(temp1 - temp2));
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });

        Button multiple = (Button) findViewById(R.id.btn_multiple);
        multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.putExtra("message", String.valueOf(temp1 * temp2));
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });

        Button divide = (Button) findViewById(R.id.btn_divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent();
                myIntent.putExtra("message", String.valueOf(temp1 / temp2));
                setResult(RESULT_OK, myIntent);
                finish();
            }
        });
    }
}
