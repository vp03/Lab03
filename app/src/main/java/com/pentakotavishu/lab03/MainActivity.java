package com.pentakotavishu.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView one;
    TextView two;
    TextView three;
    TextView four;
    SeekBar seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one=findViewById(R.id.textBox1);
        two=findViewById(R.id.textBox2);
        three=findViewById(R.id.textBox3);
        four=findViewById(R.id.textBox4);
        seekbar=findViewById(R.id.seekbar);

        one.setOnClickListener(this); // calling onClick() method
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

                one.setTextSize(progress);
                two.setTextSize(progress);
                three.setTextSize(progress);
                four.setTextSize(progress);

            }

        });
    }

    @Override
    public void onClick(View v) {

        TextView tv = (TextView) v;
        String str = tv.getText().toString();
        String message = "";

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int value = sharedPreferences.getInt(str, 0);
        int finished = value + 1;
        editor.putInt(str, finished);
        editor.apply();

        message = str + " " + finished;


        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

}
