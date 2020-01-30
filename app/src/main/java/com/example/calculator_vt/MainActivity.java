package com.example.calculator_vt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPercent,btnAdd, btnSub,btnMultiply,btnDivision,btnEqual,btnClear,btnDot,btnMinPlus;
    TextView text;
    String process;
    boolean percentClicked=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnDivision = findViewById(R.id.btn_div);
        btnMultiply = findViewById(R.id.btn_mult);
        btnEqual = findViewById(R.id.btn_equal);
        btnClear = findViewById(R.id.btn_ac);
        btnDot = findViewById(R.id.btn_point);
        btnPercent = findViewById(R.id.btn_percent);
        btnMinPlus = findViewById(R.id.btn_plus_minus);

        text = findViewById(R.id.resultText);


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("0");

            }
        });


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")){
                     process = text.getText().toString();
                     text.setText(process + "0");
            }
               else
                   text.setText("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")) {
                    process = text.getText().toString();
                    text.setText(process + "1");
                }
            else
                    text.setText("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")){
                    process = text.getText().toString();
                    text.setText(process + "2");
            }
                else
                    text.setText("0");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")){
                    process = text.getText().toString();
                    text.setText(process + "3");
                }
                else
                    text.setText("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")) {
                    process = text.getText().toString();
                    text.setText(process + "4");
                }
                else
                    text.setText("4");}
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")) {
                    process = text.getText().toString();
                    text.setText(process + "5");
                }
                else
                    text.setText("5");}
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")) {
                    process = text.getText().toString();
                    text.setText(process + "6");
                }
                else
                    text.setText("6");}
        });


        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")) {
                    process = text.getText().toString();
                    text.setText(process + "7");
                }
                else
                    text.setText("7");}
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")) {
                    process = text.getText().toString();
                    text.setText(process + "8");
                }
                else
                    text.setText("8");}
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!text.getText().equals("0")) {
                    process = text.getText().toString();
                    text.setText(process + "9");
                }
                else
                    text.setText("9");}
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                process = text.getText().toString();
                text.setText(process + "+");
            }
        });


        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = text.getText().toString();
                text.setText(process + "-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = text.getText().toString();
                text.setText(process + "×");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = text.getText().toString();
                text.setText(process + "÷");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = text.getText().toString();
                text.setText(process + ".");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = text.getText().toString();
                text.setText(process + "%");
                percentClicked=true;
            }
        });

        btnMinPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = text.getText().toString();
                float processF = Float.parseFloat(process);
                processF = - processF;
                text.setText(processF + "");
            }
        });


        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                process = text.getText().toString();
                process = process.replaceAll("×", " * ");
                process = process.replaceAll("÷", " / ");

                float finalResult = EvaluateString.evaluate(process);
                text.setText(finalResult + "");


            }
        });




    }
}