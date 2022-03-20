package com.example.cryptocalculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, amount, value, percent1;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    double numAmount, numValue, numPercent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // try block to hide Action bar
        try {
            this.getSupportActionBar().hide();
        }
        // catch block to handle NullPointerException
        catch (NullPointerException e) {
        }
    }
    /*TODO
     * Name scrow
     * */
    public boolean getNumbers() {

        name = (EditText) findViewById(R.id.name);
        amount = (EditText) findViewById(R.id.amount);
        value = (EditText) findViewById(R.id.value);
        percent1 = (EditText) findViewById(R.id.percent1);

        t1 = (TextView) findViewById(R.id.result);
        t2 = (TextView) findViewById(R.id.result2);
        t3 = (TextView) findViewById(R.id.result3);
        t4 = (TextView) findViewById(R.id.result4);
        t5 = (TextView) findViewById(R.id.result5);
        t6 = (TextView) findViewById(R.id.weeklyAsset);
        t7 = (TextView) findViewById(R.id.yearlyAsset);
        t8 = (TextView) findViewById(R.id.amountName);
        t9 = (TextView) findViewById(R.id.weeklyAssetSymble);
        t10 = (TextView) findViewById(R.id.yearlyAssetSymble);

        String s1 = amount.getText().toString();
        String s2 = value.getText().toString();
        String s3 = percent1.getText().toString();
        String s4 = name.getText().toString();
        String s5 = name.getText().toString();
        String s6 = name.getText().toString();

        t8.setText(s4+"");
        t9.setText(s5+"");
        t10.setText(s6+"");


        // condition to check if box is not empty
        if ((s1.equals(null) || s2.equals(null) || s3.equals(null))
                || (s1.equals("") || (s2.equals("") || s3.equals("")))) {
            //String result = "Please enter a value";
            //t1.setText(result);
            Toast.makeText(MainActivity.this, "Make sure all fields are filled", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            // converting string to int.
            numAmount = Double.parseDouble(s1);
            numValue = Double.parseDouble(s2);
            numPercent1 = Double.parseDouble(s3);
        }
        return true;
    }
    // a public method to perform addition
    public void doSum(View v) {
        // get the input numbers

        if (getNumbers()) {
            double percentNum = numPercent1/100;
            double totalPrice = numAmount * numValue;
            double yearReward = totalPrice * percentNum;
            double weeklyReward = yearReward/52;

            double nameYearlyReward = numAmount * percentNum;
            double nameWeeklyReward = nameYearlyReward/52;
            //int sum = num1 + num2 + num3;
            if (numAmount >= 1) {
                t1.setText(Integer.toString((int) numAmount));
            } else {
                t1.setText(String.format("%.2f", numAmount));
            }
            //t1.setText(Integer.toString((int) numAmount)); //5 7 45
            //t1.setText(String.format("%i", numAmount));
            //String s4 = name.getText().toString();
            t2.setText(String.format("%.2f", numValue));
            t3.setText(String.format("%.2f", totalPrice));
            t4.setText(String.format("%.2f", yearReward));
            t5.setText(String.format("%.2f", weeklyReward));
            t6.setText(String.format("%.2f", nameWeeklyReward));
            t7.setText(String.format("%.2f", nameYearlyReward));

            //t6 = (TextView) findViewById(R.id.weeklyAsset);
            //t7 = (TextView) findViewById(R.id.yearlyAsset);
        }
    }
}
