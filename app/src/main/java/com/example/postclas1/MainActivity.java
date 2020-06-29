package com.example.postclas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Values
    public String firstValue = "";
    public String secondValue = "";
    public String operator = "";
    public boolean willClear = false;
    //Components
    EditText txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    public void initComponents(){
        txtResult  = findViewById(R.id.txtResult);
        txtResult.setText("0");
    }

    public void concatVal(String val){
        String text = String.valueOf(txtResult.getText());
        txtResult.setText(
                  text.equals("0") ?  val : text + val
        );
    }

    public void revealResult(){
        switch (operator){
            case "sum":
                txtResult.setText(
                        String.valueOf(
                                Double.parseDouble(firstValue)
                                +
                                Double.parseDouble(secondValue)
                        )
                );
                break;
            case "div":
                txtResult.setText(
                        String.valueOf(
                                Double.parseDouble(firstValue)
                                        /
                                Double.parseDouble(secondValue)
                        )
                );
                break;
            case "sub":
                txtResult.setText(
                        String.valueOf(
                                Double.parseDouble(firstValue)
                                        -
                                Double.parseDouble(secondValue)
                        )
                );
                break;
            case "mul":
                txtResult.setText(
                        String.valueOf(
                                Double.parseDouble(firstValue)
                                        *
                                Double.parseDouble(secondValue)
                        )
                );
                break;
        }
    }

    public void saveValues(){
        if (operator.equals("")){
            firstValue = String.valueOf(txtResult.getText());
            willClear = true;
        }else{
            secondValue = String.valueOf(txtResult.getText());
            revealResult();
            operator = "";
        }
    }

    public void clearChange(){
        if (willClear) {
            txtResult.setText("");
            willClear  = false;
        }
    }


    public void handleClick(View view){
        switch (view.getId()){
            case R.id.btnOne:
                clearChange();
                concatVal("1");
                break;
            case R.id.btnTwo:
                clearChange();
                concatVal("2");
                break;
            case R.id.btnThree:
                clearChange();
                concatVal("3");
                break;
            case R.id.btnFour:
                clearChange();
                concatVal("4");
                break;
            case R.id.btnFive:
                clearChange();
                concatVal("5");
                break;
            case R.id.btnSix:
                clearChange();
                concatVal("6");
                break;
            case R.id.btnSeven:
                clearChange();
                concatVal("7");
                break;
            case R.id.btnEight:
                clearChange();
                concatVal("8");
                break;
            case R.id.btnNine:
                clearChange();
                concatVal("9");
                break;
            case R.id.btnZero:
                clearChange();
                concatVal("0");
                break;
            case R.id.btnClear:
                txtResult.setText("0");
                break;
            case R.id.btnEqual:
                saveValues();
                break;
            case R.id.btnSum:
                saveValues();
                operator = "sum";
                break;
            case R.id.btnSub:
                saveValues();
                operator = "sub";
                break;
            case R.id.btnMul:
                saveValues();
                operator = "mul";
                break;
            case R.id.btnDiv:
                saveValues();
                operator = "div";
                break;
            default:
                break;
        }
    }
}