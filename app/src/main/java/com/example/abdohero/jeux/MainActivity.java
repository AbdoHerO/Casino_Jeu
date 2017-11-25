package com.example.abdohero.jeux;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button cancel;
    private Button restart;
    private Button go;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView textscoor;
    private EditText editgo;
    private CountDownTimer timer;
    private Random random = new Random();
    int number=random.nextInt(9);
    int r=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // textscoor.setText("");
        //editgo.setText("");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(btnClickListner);
        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(btnClickListner);
        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(btnClickListner);
        go = (Button) findViewById(R.id.go);
        go.setOnClickListener(btnClickListner);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        textscoor = (TextView) findViewById(R.id.textscoor);
        editgo = (EditText) findViewById(R.id.editgo);
    }

    public void start() {
        timer=new CountDownTimer(60 * 1000, 300) {

            @Override
            public void onTick(long millisUntilFinished) {
                int number1=random.nextInt(9);
                int number2=random.nextInt(9);
                int number3=random.nextInt(9);

                text1.setText(Integer.toString(number1));
                text2.setText(Integer.toString(number2));
                text3.setText(Integer.toString(number3));
            }

            @Override
            public void onFinish() {
                text1.setText("-");
                text2.setText("-");
                text3.setText("-");
            }
        };
        timer.start();
    }



    public void go(){
        timer=new CountDownTimer(60 * 1000, 300) {

            @Override
            public void onTick(long millisUntilFinished) {
                int number1=random.nextInt(9);
                int number2=random.nextInt(9);
                int number3=random.nextInt(9);

                text1.setText(Integer.toString(number1));
                text2.setText(Integer.toString(number2));
                text3.setText(Integer.toString(number3));
            }

            @Override
            public void onFinish() {
                text1.setText("-");
                text2.setText("-");
                text3.setText("-");
            }
        };
        timer.start();

    }
    /*public void cancel(){
        if(timer!=null) {
            timer = null;
            if(editgo.equals(""+text1.getText()+text2.getText()+text3.getText())){
                int scoor = Integer.valueOf((String) textscoor.getText())+1;
                textscoor.setText(""+scoor);
            }

            //r+=1;
            //textscoor.setText(""+r);
            timer.cancel();

        }

    }*/




    private View.OnClickListener btnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.start:
                    start();
                    start.setClickable(false);
                    break;
                case R.id.cancel:
                    timer.cancel();
                    r+=1;
                    textscoor.setText(""+r);
                    break;
                case R.id.restart:
                    editgo.setText("");
                    timer.cancel();
                    start.setClickable(true);
                    go.setClickable(true);
                    break;
                case R.id.go:
                    go();
                    go.setClickable(false);
                    break;
            }
        }
    };



}

