package com.geeks.salkynbek_u_a_hw_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.geeks.salkynbek_u_a_hw_calculator.ui.home.HomeFragment;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    String oldNumber;
    String operator = "";
    Boolean isNew = true;
    private TextView textView;

    private MaterialButton btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        btn_next = findViewById(R.id.btn_next);


        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                String result = ((TextView) findViewById(R.id.text_view)).getText().toString();
                intent.putExtra("result", result);
                startActivity(intent);
            }
        });
    }

    public void onNumberClick(View view) {

        if (isNew)
            textView.setText("");
        isNew = false;
        String number = textView.getText().toString();
        switch (view.getId()) {
            case R.id.btn_one:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "1";
                break;
            case R.id.btn_two:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "2";
                break;
            case R.id.btn_three:
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "3";
                break;
            case R.id.btn_four:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "4";
                break;
            case R.id.btn_five:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "5";
                break;
            case R.id.btn_six:
                btn_next.setVisibility(View.INVISIBLE);

                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "6";
                break;
            case R.id.btn_seven:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "7";
                break;
            case R.id.btn_eight:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "8";
                break;
            case R.id.btn_nine:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = number.substring(1);
                }
                number = number + "9";
                break;
            case R.id.btn_zero:
                btn_next.setVisibility(View.INVISIBLE);
                if (onlyOneZero(number) && number.length() == 1) {
                    number = "0";
                } else {
                    number = number + "0";
                }
                break;


            case R.id.btn_plus_minus:
                if (isNumberZero(number)) {
                    number = "0";
                } else {
                    if (isMinusPresent(number)) {
                        number = number.substring(1);
                    } else {
                        number = "-" + number;
                    }
                }
                break;


            case R.id.btn_dote:

                if (isDotePresent(number)) {

                } else if (onlyOneZero(number)) {
                    number = "0.";
                } else {
                    number = number + ".";
                }
                break;
        }
        textView.setText(number);
    }

    private boolean onlyOneZero(String number) {
        if (number.equals("")) {
            return true;
        }
        if (number.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }

    }

    private boolean isNumberZero(String number) {

        if (number.equals("0") || number.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMinusPresent(String number) {
        if (number.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }
    }

    public void onClickOperation(View view) {
        isNew = true;
        oldNumber = textView.getText().toString();
        switch (view.getId()) {
            case R.id.btn_devide:
                operator = "/";
                break;
            case R.id.btn_multiply:
                operator = "*";
                break;
            case R.id.btn_minus:
                operator = "-";
                break;
            case R.id.btn_plus:
                operator = "+";
                break;
        }
    }

    public void onClickEqual(View view) {
        String newNumber = textView.getText().toString();
        Double result = 0.0;

        btn_next.setVisibility(view.getVisibility());


        if (operator.isEmpty()) {
            // No operator is selected, do nothing or display an error message
            return;
        }

        if (Double.parseDouble(newNumber) < 0.00000001 && operator == "/"
                || newNumber.equals("") && operator == "/") {
            Toast.makeText(MainActivity.this, "На ноль делить нельзя!",
                    Toast.LENGTH_LONG).show();
        } else {
            switch (operator) {
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                    break;
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                    break;
            }
            textView.setText(result + "");
        }
    }

    public void onAcClick(View view) {
        textView.setText("0");
        isNew = true;
    }

    public boolean isDotePresent(String number) {
        if (number.indexOf(".") == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void onClickPercent(View view) {

        if (operator == "") {
            String number = textView.getText().toString();
            double temp = Double.parseDouble(number) / 100;
            number = temp + "";
            textView.setText(number);
        } else {
            String newNumber = textView.getText().toString();
            Double result = 0.0;
            switch (operator) {
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100;
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber)
                            * Double.parseDouble(newNumber) / 100;
                    break;
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber)
                            * Double.parseDouble(newNumber) / 100;
                    break;
            }

            textView.setText(result + "");
            operator = "";
        }
    }
}
