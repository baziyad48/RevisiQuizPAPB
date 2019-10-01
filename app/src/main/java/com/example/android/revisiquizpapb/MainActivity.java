package com.example.android.revisiquizpapb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText num1 = (EditText) findViewById(R.id.et_num1);
        final EditText num2 = (EditText) findViewById(R.id.et_num2);

        Button proses = (Button) findViewById(R.id.btn_proses);
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Proses.class);
                myIntent.putExtra("num1", num1.getText().toString());
                myIntent.putExtra("num2", num2.getText().toString());
                startActivityForResult(myIntent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView result = (TextView) findViewById(R.id.tv_hasil);
        if(requestCode == 0 && resultCode == Activity.RESULT_OK){
            result.setText(data.getExtras().getString("message"));
        }
    }
}
