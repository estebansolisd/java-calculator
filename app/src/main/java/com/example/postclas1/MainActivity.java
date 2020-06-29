package com.example.postclas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
        operator = "";
        willClear = true;
    }

    public void saveValues(){
        if (operator.equals("")){
            firstValue = String.valueOf(txtResult.getText());
        }else{
            secondValue = String.valueOf(txtResult.getText());
        }
    }

    public void setEnabledOperations(boolean flag){
        findViewById(R.id.btnSub).setEnabled(flag);
        findViewById(R.id.btnSum).setEnabled(flag);
        findViewById(R.id.btnDiv).setEnabled(flag);
        findViewById(R.id.btnMul).setEnabled(flag);
    }

    public void setEnabledEqual(boolean flag){
        findViewById(R.id.btnEqual).setEnabled(flag);
    }

    public void handleClick(View view){
        switch (view.getId()){
            case R.id.btnOne:
            case R.id.btnTwo:
            case R.id.btnThree:
            case R.id.btnFour:
            case R.id.btnFive:
            case R.id.btnSix:
            case R.id.btnSeven:
            case R.id.btnEight:
            case R.id.btnNine:
            case R.id.btnZero:
                if (willClear){
                    txtResult.setText("");
                    willClear = false;
                }
                concatVal(String.valueOf(view.getTag()));
                setEnabledEqual(!operator.equals(""));
                setEnabledOperations(operator.equals(""));
                saveValues();
                break;
            case R.id.btnClear:
                txtResult.setText("0");
                operator = "";
                willClear = true;
                break;
            case R.id.btnEqual:
                revealResult();
                break;
            case R.id.btnSum:
            case R.id.btnDiv:
            case R.id.btnMul:
            case R.id.btnSub:
                setEnabledOperations(false);
                operator = String.valueOf(view.getTag());
                willClear = true;
                break;
            default:
                break;
        }
    }
}