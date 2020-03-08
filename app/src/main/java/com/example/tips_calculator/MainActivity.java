package com.example.tips_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calculateBtn;
    EditText getUser_total_bill,getCustomized_tip;
    TextView show_15,show_18,show_20,show_22,show_custom_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //initiate a button
        calculateBtn = findViewById(R.id.calculateBtn);

        //initiate EditTexts
        getUser_total_bill = findViewById(R.id.total_bill);
        getCustomized_tip = findViewById(R.id.customized_tip);

        //initiate TextViews
        show_15 = findViewById(R.id.result_15);
        show_18 = findViewById(R.id.result_18);
        show_20 = findViewById(R.id.result_20);
        show_22 = findViewById(R.id.result_22);
        show_custom_tip = findViewById(R.id.result_custom_tip);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getUser_total_bill_tmp = getUser_total_bill.getText().toString();
                double user_total_bill_value = 0;

                String getCustomized_tip_tmp = getCustomized_tip.getText().toString();
                double user_custom_percentage = 0;

                if(getUser_total_bill_tmp.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Enter Your Total Bill",Toast.LENGTH_LONG).show();
                }else {

                    user_total_bill_value = Double.parseDouble(getUser_total_bill_tmp);  //parse to Double
                    calculate_tip(user_total_bill_value);   //call regular calculate function

                    user_custom_percentage = Double.parseDouble(getCustomized_tip_tmp);
                    custom_calculate(user_total_bill_value,user_custom_percentage);

                }

            }
        });



    }

    private void calculate_tip(Double value){

        double fiveteen_perct = value*0.15; //cal 15%
        //show_15.setText(String.valueOf(fiveteen_perct));
        show_15.setText(String.format("%.2f = $%.2f ",fiveteen_perct,fiveteen_perct+value));

        double eightteen_perct = value*0.18; //cal 18%
        show_18.setText(String.format("%.2f = $%.2f",eightteen_perct,eightteen_perct+value));

        double twenty_perct = value*0.20; //cal 20%
        show_20.setText(String.format("%.2f = $%.2f",twenty_perct,twenty_perct+value));

        double twentytwo_perct = value*0.22; //cal 22%
        show_22.setText(String.format("%.2f = $%.2f",twentytwo_perct,twentytwo_perct+value));

    }

    private void custom_calculate(Double total_bill,Double user_perct){

        double custom_perct = total_bill*(user_perct/100);
        show_custom_tip.setText(String.format("%.2f",custom_perct));
    }



}
