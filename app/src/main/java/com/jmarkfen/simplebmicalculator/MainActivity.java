package com.jmarkfen.simplebmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radio;
        radio = findViewById(R.id.radioGroup);
        TextInputEditText age, height, weight;
        age = findViewById(R.id.textInputAge);
        height = findViewById(R.id.textInputHeight);
        weight = findViewById(R.id.textInputWeight);
        Button calc;
        calc = findViewById(R.id.buttonCalculate);
        TextView result;
        result = findViewById(R.id.textViewResult);

        calc.setOnClickListener(v -> {
            double bmi = calculateBMI(
                    Integer.parseInt(height.getText().toString()),
                    Double.parseDouble(weight.getText().toString())
            );
            String status = "";
            int selected = radio.getCheckedRadioButtonId();
            if (selected == R.id.radioButtonMale) {
                status = classifyMaleBMI(bmi);
            } else if (selected == R.id.radioButtonFemale) {
                status = classifyFemaleBMI(bmi);
            }
            String msg = "Your BMI is: " + String.format(Locale.ENGLISH, "%.1f", bmi) + " (" + status + ")";
            result.setText(msg);
        });
    }

    private double calculateBMI(int cm, double kg) {
        double m2 = (double) (cm * cm) / 10000;
        double res = kg / m2;
        return res;
    }

    private String classifyMaleBMI(double bmi) {
        String res = "";
        if (bmi < 18.5) {
            res = "Underweight";
        } else if (bmi < 25) {
            res = "Normal";
        } else if (bmi < 30) {
            res = "Overweight";
        } else if (bmi < 35) {
            res = "Obese";
        } else {
            res = "Severely Obese";
        }
        return res;
    }

    private String classifyFemaleBMI(double bmi) {
        String res = "";
        if (bmi < 18.5) {
            res = "Underweight";
        } else if (bmi < 24) {
            res = "Normal";
        } else if (bmi < 30) {
            res = "Overweight";
        } else if (bmi < 35) {
            res = "Obese";
        } else {
            res = "Severely Obese";
        }
        return res;
    }
}