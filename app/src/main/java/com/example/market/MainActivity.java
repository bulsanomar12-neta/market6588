package com.example.market;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/////

public class MainActivity extends AppCompatActivity {

    EditText etHeigh, etWeight;
    Button btCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        connectComponents();
    }

    public void gotoNext(View view) {
        Intent i = new Intent(this,NestActivity.class);
        startActivity(i);

    }

    private void connectComponents(){
        etHeigh = findViewById(R.id.etHeigh);
        etWeight = findViewById(R.id.etWeight);
        btCalculate = findViewById(R.id.btCalculate);
    }

    public void calculate (View view) {
        String weight = etWeight.getText().toString();
        String heigh = etHeigh.getText().toString();

        if (weight.isEmpty() || heigh.isEmpty() ) {
            Toast.makeText(this, "must only contain numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double w,h,bmi;
        w = Double.parseDouble(weight);
        h = Double.parseDouble(heigh);
        bmi = w / (h*h);

        Toast.makeText(this, "your bmi is" + bmi, Toast.LENGTH_LONG).show();
    }
}