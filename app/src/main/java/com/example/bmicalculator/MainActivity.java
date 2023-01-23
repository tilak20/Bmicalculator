package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int age;
    float height, weight, sum;
    String dAge, dHeight, dWeight, data;
    EditText edtAge, edtHeight, edtWeight;
    Button btnShow;
    TextView txtage,txtResult,txtAge,txtWeight,txtHeight;
    SeekBar seekAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBinding();
        initClick();
    }

    void initBinding() {
        txtage = findViewById(R.id.txtage);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        btnShow = findViewById(R.id.btnShow);
        txtResult = findViewById(R.id.txtResult);
        txtAge= findViewById(R.id.txtAge);
        seekAge = findViewById(R.id.seekAge);
        txtWeight = findViewById(R.id.txtWeight);
        txtHeight = findViewById(R.id.txtHeight);
    }

    void initClick() {

        seekAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtage.setText(""+ i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnShow.setOnClickListener(view -> {

            dAge = txtage.getText().toString();
            dHeight = edtHeight.getText().toString();
            dWeight = edtWeight.getText().toString();


            age = Integer.parseInt(dAge);
            height = Integer.parseInt(dHeight);
            weight = Integer.parseInt(dWeight);

            height = (float) (height*0.3048);

            sum = weight / (height * height);

            Toast.makeText(this, "Age is: " + age + "\nResult is: " + sum, Toast.LENGTH_SHORT).show();

            data = txtResult.getText().toString();
            txtResult.setText(""+sum);
            data = txtAge.getText().toString();
            txtAge.setText(""+age);
            data = txtHeight.getText().toString();
            txtHeight.setText(""+height);
            data = txtWeight.getText().toString();
            txtWeight.setText(""+weight);
        });
    }
}