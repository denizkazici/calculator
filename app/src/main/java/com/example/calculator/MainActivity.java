package com.example.calculator;

import static com.example.calculator.R.id.ButtonMultiply;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity<bool> extends AppCompatActivity {
    private EditText EditTextNumber;
    private TextView pastResult;
    private Button ButtonDelete;
    private Button Button7;
    private Button Button8;
    private Button Button9;
    private Button ButtonDivision;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button ButtonMultiply;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button ButtonSubstract;
    private Button Button0;
    private Button ButtonEqual;
    private Button ButtonDot;
    private Button ButtonAdd;
    private Button ButtonPercent;
    private int firstNo = 0;
    private int secondNo = 0;
    private double firstN = 0.0;
    private double secondN = 0.0;
    private double resultD=0.0;
    private String  symbol = "";
    boolean check_double = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditTextNumber = findViewById(R.id.EditTextNumber);
        pastResult = findViewById(R.id.pastResult);
        ButtonDelete =findViewById(R.id.ButtonDelete);
        Button7 = findViewById(R.id.Button7);
        Button8 = findViewById(R.id.Button8);
        Button9 =findViewById(R.id.Button9);
        ButtonDivision =findViewById(R.id.ButtonDivision);
        Button4 =findViewById(R.id.Button4);
        Button5 =findViewById(R.id.Button5);
        Button6 =findViewById(R.id.Button6);
        ButtonMultiply =findViewById(R.id.ButtonMultiply);
        Button1 = findViewById(R.id.Button1);
        Button2 = findViewById(R.id.Button2);
        Button3 =findViewById(R.id.Button3);
        ButtonSubstract =findViewById(R.id.ButtonSubstract);
        Button0 = findViewById(R.id.Button0);
        ButtonEqual =findViewById(R.id.ButtonEqual);
        ButtonDot =findViewById(R.id.ButtonDot);
        ButtonAdd =findViewById(R.id.ButtonAdd);
        ButtonPercent = findViewById(R.id.ButtonPercent);
    }
    public void onClick(View view)
    {


        if(EditTextNumber.getText().toString().equals("0")) {
            EditTextNumber.setText("");
        }

        switch(view.getId()){
            case R.id.ButtonDelete:
                EditTextNumber.setText("");
                firstNo=0;
                secondNo=0;
                firstN=0.0;
                secondN=0.0;
                resultD=0;
                symbol="";
                check_double=false;
                break;
            case R.id.Button7:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "7");
                break;
            case R.id.Button8:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "8");
                break;
            case R.id.Button9:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "9");
                break;
            case R.id.ButtonDivision:
                symbol="/";
                if(check_double){
                    firstN = Double.parseDouble(EditTextNumber.getText().toString());
                    pastResult.setText(Double.toString(firstN));
                }
                else {
                    if (firstNo == 0) {
                        firstNo = Integer.parseInt(EditTextNumber.getText().toString());
                    }
                    pastResult.setText(Integer.toString(firstNo));
                }
                EditTextNumber.setText("");
                check_double=false;
                break;

            case R.id.Button4:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "4");
                break;
            case R.id.Button5:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "5");
                break;
            case R.id.Button6:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "6");
                break;
            case R.id.ButtonMultiply:
                symbol="*";
                if(check_double){
                    firstN = Double.parseDouble(EditTextNumber.getText().toString());
                    pastResult.setText(Double.toString(firstN));
                }
                else {
                    if (firstNo == 0) {
                        firstNo = Integer.parseInt(EditTextNumber.getText().toString());
                    }
                    pastResult.setText(Integer.toString(firstNo));
                }

                EditTextNumber.setText("");

                check_double=false;
                break;
            case R.id.Button1:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "1");
                break;
            case R.id.Button2:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "2");
                break;
            case R.id.Button3:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "3");
                break;
            case R.id.ButtonSubstract:
                symbol="-";
                if(check_double){
                    firstN = Double.parseDouble(EditTextNumber.getText().toString());
                    pastResult.setText(Double.toString(firstN));
                }
                else {
                    if (firstNo == 0) {
                        firstNo = Integer.parseInt(EditTextNumber.getText().toString());
                    }
                    pastResult.setText(Integer.toString(firstNo));
                }

                EditTextNumber.setText("");

                check_double=false;
                break;
            case R.id.Button0:
                EditTextNumber.setText(EditTextNumber.getText().toString() + "0");
                break;
            case R.id.ButtonEqual:
               if(symbol.equals("")){
                   if(check_double){
                       firstN = Double.parseDouble(EditTextNumber.getText().toString());
                       EditTextNumber.setText(Double.toString(firstN));
                   }
                   else {
                       firstNo = Integer.parseInt(EditTextNumber.getText().toString());
                       EditTextNumber.setText(Integer.toString(firstNo));
                   }
               }
               else{
                   if(EditTextNumber.getText().toString().equals("")) {
                       secondNo=firstNo;
                   }
                   else{
                       secondNo = Integer.parseInt(EditTextNumber.getText().toString());
                   }
                   if(firstN == 0.0) {
                       firstN = (double) firstNo;
                   }
                   secondN = (double) secondNo;
                   resultD =calculate(firstN,secondN,symbol);
                   EditTextNumber.setText(Double.toString(resultD));
               }
                pastResult.setText("");
                break;
            case R.id.ButtonDot:
                if(check_double == false) {
                    check_double=true;
                    if(EditTextNumber.getText().toString() == ""){

                        EditTextNumber.setText("0");
                    }
                    EditTextNumber.setText(EditTextNumber.getText().toString() + ".");
                }
                break;
            case R.id.ButtonAdd:
                symbol = "+";
                if(check_double){
                    firstN = Double.parseDouble(EditTextNumber.getText().toString());
                    pastResult.setText(Double.toString(firstN));
                }
                else {
                    if (firstNo == 0) {
                        firstNo = Integer.parseInt(EditTextNumber.getText().toString());
                    }
                    pastResult.setText(Integer.toString(firstNo));
                }
                EditTextNumber.setText("");

                check_double=false;
                break;
            case R.id.ButtonPercent:
                if(EditTextNumber.getText().toString().equals("")){
                    EditTextNumber.setText("0");
                }
                else{
                    firstNo = Integer.parseInt(EditTextNumber.getText().toString());
                    double num = (double) firstNo;
                    resultD = num / 100;
                    EditTextNumber.setText(Double.toString(resultD));
                }
                break;
        }
    }
    public double calculate (double num1, double num2, String symbol){
        if(symbol == "+"){
            return num1 + num2;
        }
        else if(symbol == "-"){
            return num1-num2;
        }
        else if (symbol == "*"){
            return num1 * num2;
        }
        else if (symbol == "/"){
            return num1 / num2;
        }
        return 0;
    }
}