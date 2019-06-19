package com.somwthing.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Amount;
    private EditText Person;
    private SeekBar Percntg;
    private Button Calc;
    private TextView Pettxt;
    private TextView result;
    private int seekbarPercentage;
    private TextView totalbill;
    private float enteredBillFloat;

    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Amount = (EditText) findViewById(R.id.billamountid);
        Percntg = (SeekBar) findViewById(R.id.seekBar);
        Calc = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.textView3);
        Pettxt = (TextView) findViewById(R.id.textView2);
        Person= (EditText) findViewById(R.id.personid);
        totalbill = (TextView) findViewById(R.id.textView4);

        Toast.makeText(getApplication(), "Hello", Toast.LENGTH_LONG).show();



        Calc.setOnClickListener((View.OnClickListener) this);


        Percntg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Pettxt.setText(String.valueOf(seekBar.getProgress()) + "%");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekbarPercentage = seekBar.getProgress();



            }
        });


    }
    @Override
    public void onClick(View v) {
        calculate();

        //TODO: Fix this code
        //TODO: Build amazing application with this somwthing

    }

    public void calculate() {

        float reult =  0.0f;

        float r1=0.0f;

        float r2=0.0f;

        if (!Amount.getText().toString().equals("")) {

            enteredBillFloat = Float.parseFloat(Amount.getText().toString());
            reult = ((enteredBillFloat * seekbarPercentage) / 100);

            r1= Float.parseFloat(Person.getText().toString());
            r2= reult / r1 ;
            result.setText("Tip per person will be" + " $" + String.valueOf(r2) );
            totalbill.setText("Total bill per person is "  + "$" + (((enteredBillFloat/r1))+ r2));
            //totalBillTv.setText("Total bill: " + " $"+String.valueOf(enteredBillFloat + result));

            Log.v(TAG, String.valueOf(result));


        }else {
            Toast.makeText(MainActivity.this, "Please enter a bill amount.", Toast.LENGTH_LONG).show();
        }





    }
}

