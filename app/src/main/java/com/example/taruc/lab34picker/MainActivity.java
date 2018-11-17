package com.example.taruc.lab34picker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    int age;
    EditText balance;
    TextView textViewAge,textViewEligibleAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        balance=findViewById(R.id.editTextAccountBalance);
        textViewAge =findViewById(R.id.textViewAge);
        textViewEligibleAmount =findViewById(R.id.textViewEligibleAmount);
    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),getString(R.string.datePicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);

        Date date=new Date();

        //display at button
        TextView buttonDOB = findViewById(R.id.buttonDOB);
        buttonDOB.setText(dateMessage);

        Toast.makeText(this, getString(R.string.date) + dateMessage,
                Toast.LENGTH_SHORT).show();

        Calendar calendar = Calendar.getInstance();
        int thisyear = calendar.get(Calendar.YEAR);
        age= thisyear-year;

        textViewAge.setText("Age : " + Integer.toString(age));
    }

    public void calculateEligibleAmount(View view){
        int accBalance= Integer.parseInt(balance.getText().toString());
        double amount;
        if(age>=16&&age<=20&&accBalance>=5000){
            amount=(accBalance-5000)*0.3;
        }else if(age>=21&&age<=25&&accBalance>=14000){
            amount=(accBalance-14000)*0.3;
        }else if(age>=26&&age<=30&&accBalance>=29000){
            amount=(accBalance-29000)*0.3;
        }else if(age>=31&&age<=35&&accBalance>=50000){
            amount=(accBalance-50000)*0.3;
        }else if(age>=36&&age<=40&&accBalance>=78000){
            amount=(accBalance-78000)*0.3;
        }else if(age>=41&&age<=45&&accBalance>=29000){
            amount=(accBalance-29000)*0.3;
        }else if(age>=46&&age<=50&&accBalance>=165000){
            amount=(accBalance-165000)*0.3;
        }else if(age>=51&&age<=55&&accBalance>=228000){
            amount=(accBalance-228000)*0.3;
        }else {
            amount=0;
        }
        textViewEligibleAmount.setText("Eligible Amount : " + amount);
    }
    public void resetData(View view){
        balance.setText("");
        textViewAge.setText("Age : ");
        textViewEligibleAmount.setText("Eligible Amount : ");
    }
}
