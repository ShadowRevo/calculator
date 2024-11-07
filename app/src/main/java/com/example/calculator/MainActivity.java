package com.example.calculator;

import static com.example.calculator.R.id.btnMinus;
import static com.example.calculator.R.id.btnPlus;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_num1, et_num2;
    private TextView tvResult = findViewById(R.id.tvResult);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num1 = findViewById(R.id.etNum1);
        et_num2 = findViewById(R.id.etNum2);
        Button btnPlus = findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener((View.OnClickListener) this);
        Button btnMinus = findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);
    }
    public void onClick(View view) {
        if(!(et_num1.getText().toString().isEmpty() || et_num2.getText().toString().isEmpty() )) {
            int num1 = Integer.parseInt(et_num1.getText().toString());
            int num2 = Integer.parseInt(et_num2.getText().toString());
            et_num1.setText(null);
            et_num2.setText("");
            if (view.getId() == R.id.btnPlus) {
                tvResult.setText(String.valueOf(num1 + num2));
            }
            if (view.getId() == R.id.btnMinus) {
                tvResult.setText(String.valueOf(num1 - num2));
            }
        }
        else {
            if(et_num1.getText().toString().isEmpty()) {
                et_num1.setError("Please enter a number");
            }
            if(et_num2.getText().toString().isEmpty()) {
                et_num2.setError("Please enter a number");
            }
        }
    }
}