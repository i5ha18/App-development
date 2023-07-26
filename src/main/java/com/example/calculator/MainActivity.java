package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText display;
    String currentNumber;
    double operand1;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display =findViewById(R.id.et1);
        currentNumber="";
        operand1 =0;
        operator="";

        Button b0=findViewById(R.id.b0);
        Button b1=findViewById(R.id.b1);
        Button b2=findViewById(R.id.b2);
        Button b3=findViewById(R.id.b3);
        Button b4=findViewById(R.id.b4);
        Button b5=findViewById(R.id.b5);
        Button b6=findViewById(R.id.b6);
        Button b7=findViewById(R.id.b7);
        Button b8=findViewById(R.id.b8);
        Button b9=findViewById(R.id.b9);
        Button b00=findViewById(R.id.b00);
        Button badd=findViewById(R.id.badd);
        Button bsub=findViewById(R.id.bsub);
        Button bmul=findViewById(R.id.bmul);
        Button bdiv=findViewById(R.id.bdiv);
        Button bpoint=findViewById(R.id.bpoint);
        Button bc=findViewById(R.id.bc);
        Button bresult=findViewById(R.id.bresult);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b00.setOnClickListener(this);
        badd.setOnClickListener(this);
        bsub.setOnClickListener(this);
        bmul.setOnClickListener(this);
        bdiv.setOnClickListener(this);
        bpoint.setOnClickListener(this);
        bc.setOnClickListener(this);
        bresult.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.b0:
                updatedisplay("0");
                break;
            case R.id.b1:
                updatedisplay("1");
                break;
            case R.id.b2:
                updatedisplay("2");
                break;
            case R.id.b3:
                updatedisplay("3");
                break;
            case R.id.b4:
                updatedisplay("4");
                break;
            case R.id.b5:
                updatedisplay("5");
                break;
            case R.id.b6:
                updatedisplay("6");
                break;
            case R.id.b7:
                updatedisplay("7");
                break;
            case R.id.b8:
                updatedisplay("8");
                break;
            case R.id.b9:
                updatedisplay("9");
                break;
            case R.id.b00:
                updatedisplay("00");
                break;
            case R.id.bpoint:
                if (!currentNumber.contains(".")){
                    updatedisplay(".");
                }
                break;
            case R.id.bresult:
                calculateresult();
                break;
            case R.id.badd:
                setoperator("+");
                break;
            case R.id.bsub:
                setoperator("-");
                break;
            case R.id.bmul:
                setoperator("*");
                break;
            case R.id.bdiv:
                setoperator("/");
                break;
            case R.id.bc:
                clearDisplay();
                break;

        }
    }

    private void updatedisplay(String digit){
        currentNumber += digit;
        display.setText(currentNumber);
    }

    private void calculateresult(){
        double result=0;
        double operand2=Double.parseDouble(currentNumber);

        switch(operator){
            case "+":
                result=operand1 + operand2;
                break;
            case "-":
                result=operand1 - operand2;
                break;
            case "*":
                result=operand1 * operand2;
                break;
            case "/":
                if (operand2!=0){
                    result=operand1/operand2;
                }else{
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(String.valueOf(result));
        currentNumber="";
        operand1=result;
    }

    private void setoperator(String op){
        operand1=Double.parseDouble(currentNumber);
        operator=op;
        currentNumber="";
    }

    private void clearDisplay(){
        display.setText("");
        currentNumber="";
        operand1=0;
        operator="";
    }
}