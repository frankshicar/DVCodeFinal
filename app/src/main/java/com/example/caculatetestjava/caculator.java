package com.example.caculatetestjava;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class caculator extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{
    private int openParenthesis = 0;

    private boolean dotUsed = false;

    private boolean equalClicked = false;
    private String lastExpression = "";

    private final static int EXCEPTION = -1;
    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;
    private final static int IS_OPEN_PARENTHESIS = 2;
    private final static int IS_CLOSE_PARENTHESIS = 3;
    private final static int IS_DOT = 4;

    ImageButton buttonNumber0;
    ImageButton buttonNumber1;
    ImageButton buttonNumber2;
    ImageButton buttonNumber3;
    ImageButton buttonNumber4;
    ImageButton buttonNumber5;
    ImageButton buttonNumber6;
    ImageButton buttonNumber7;
    ImageButton buttonNumber8;
    ImageButton buttonNumber9;

    ImageButton buttonClear;
    ImageButton buttonParentheses;
    ImageButton buttonPercent;
    ImageButton buttonDivision;
    ImageButton buttonMultiplication;
    ImageButton buttonSubtraction;
    ImageButton buttonAddition;
    ImageButton buttonEqual;
    ImageButton buttonDot;

    ImageButton buttonBack;

    TextView textViewInputNumbers;

    ScriptEngine scriptEngine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);
        scriptEngine = new ScriptEngineManager().getEngineByName("rhino");



        initializeViewVariables();
        setOnClickListeners();
        setOnTouchListener();
    }

    private void initializeViewVariables()
    {
        buttonNumber0 = (ImageButton) findViewById(R.id.button_zero);
        buttonNumber1 = (ImageButton) findViewById(R.id.button_one);
        buttonNumber2 = (ImageButton) findViewById(R.id.button_two);
        buttonNumber3 = (ImageButton) findViewById(R.id.button_three);
        buttonNumber4 = (ImageButton) findViewById(R.id.button_four);
        buttonNumber5 = (ImageButton) findViewById(R.id.button_five);
        buttonNumber6 = (ImageButton) findViewById(R.id.button_six);
        buttonNumber7 = (ImageButton) findViewById(R.id.button_seven);
        buttonNumber8 = (ImageButton) findViewById(R.id.button_eight);
        buttonNumber9 = (ImageButton) findViewById(R.id.button_nine);

        buttonClear = (ImageButton) findViewById(R.id.button_clear);
        buttonParentheses = (ImageButton) findViewById(R.id.button_parentheses);
        buttonPercent = (ImageButton) findViewById(R.id.button_percent);
        buttonDivision = (ImageButton) findViewById(R.id.button_division);
        buttonMultiplication = (ImageButton) findViewById(R.id.button_multiplication);
        buttonSubtraction = (ImageButton) findViewById(R.id.button_subtraction);
        buttonAddition = (ImageButton) findViewById(R.id.button_addition);
        buttonEqual = (ImageButton) findViewById(R.id.button_equal);
        buttonDot = (ImageButton) findViewById(R.id.button_dot);
        textViewInputNumbers = (TextView) findViewById(R.id.textView_input_numbers);

        buttonBack = (ImageButton) findViewById(R.id.btn_back);
    }

    private void setOnClickListeners()
    {
        buttonNumber0.setOnClickListener((View.OnClickListener) this);
        buttonNumber1.setOnClickListener((View.OnClickListener) this);
        buttonNumber2.setOnClickListener((View.OnClickListener) this);
        buttonNumber3.setOnClickListener((View.OnClickListener) this);
        buttonNumber4.setOnClickListener((View.OnClickListener) this);
        buttonNumber5.setOnClickListener((View.OnClickListener) this);
        buttonNumber6.setOnClickListener((View.OnClickListener) this);
        buttonNumber7.setOnClickListener((View.OnClickListener) this);
        buttonNumber8.setOnClickListener((View.OnClickListener) this);
        buttonNumber9.setOnClickListener((View.OnClickListener) this);

        buttonClear.setOnClickListener((View.OnClickListener) this);
        buttonParentheses.setOnClickListener((View.OnClickListener) this);
        buttonPercent.setOnClickListener((View.OnClickListener) this);
        buttonDivision.setOnClickListener((View.OnClickListener) this);
        buttonMultiplication.setOnClickListener((View.OnClickListener) this);
        buttonSubtraction.setOnClickListener((View.OnClickListener) this);
        buttonAddition.setOnClickListener((View.OnClickListener) this);
        buttonEqual.setOnClickListener((View.OnClickListener) this);
        buttonDot.setOnClickListener((View.OnClickListener) this);

        buttonBack.setOnClickListener((View.OnClickListener) this);
    }

    private void setOnTouchListener()
    {
        buttonNumber0.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber1.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber2.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber3.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber4.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber5.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber6.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber7.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber8.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber9.setOnTouchListener((View.OnTouchListener) this);

        buttonClear.setOnTouchListener((View.OnTouchListener) this);
        buttonParentheses.setOnTouchListener((View.OnTouchListener) this);
        buttonPercent.setOnTouchListener((View.OnTouchListener) this);
        buttonDivision.setOnTouchListener((View.OnTouchListener) this);
        buttonMultiplication.setOnTouchListener((View.OnTouchListener) this);
        buttonSubtraction.setOnTouchListener((View.OnTouchListener) this);
        buttonAddition.setOnTouchListener((View.OnTouchListener) this);
        buttonDot.setOnTouchListener((View.OnTouchListener) this);

        buttonBack.setOnTouchListener((View.OnTouchListener) this);
    }


    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button_zero:
                if (addNumber("0")) equalClicked = false;
                break;
            case R.id.button_one:
                if (addNumber("1")) equalClicked = false;
                break;
            case R.id.button_two:
                if (addNumber("2")) equalClicked = false;
                break;
            case R.id.button_three:
                if (addNumber("3")) equalClicked = false;
                break;
            case R.id.button_four:
                if (addNumber("4")) equalClicked = false;
                break;
            case R.id.button_five:
                if (addNumber("5")) equalClicked = false;
                break;
            case R.id.button_six:
                if (addNumber("6")) equalClicked = false;
                break;
            case R.id.button_seven:
                if (addNumber("7")) equalClicked = false;
                break;
            case R.id.button_eight:
                if (addNumber("8")) equalClicked = false;
                break;
            case R.id.button_nine:
                if (addNumber("9")) equalClicked = false;
                break;
            case R.id.button_addition:
                if (addOperand("+")) equalClicked = false;
                break;
            case R.id.button_subtraction:
                if (addOperand("-")) equalClicked = false;
                break;
            case R.id.button_multiplication:
                if (addOperand("x")) equalClicked = false;
                break;
            case R.id.button_division:
                if (addOperand("\u00F7")) equalClicked = false;
                break;
            case R.id.button_percent:
                if (addOperand("%")) equalClicked = false;
                break;
            case R.id.button_dot :
                if (addDot()) equalClicked = false;
                break;
            case R.id.button_parentheses:
                if (addParenthesis()) equalClicked = false;
                break;
            case R.id.button_clear:
                textViewInputNumbers.setText("");
                openParenthesis = 0;
                dotUsed = false;
                equalClicked = false;
                break;
            case R.id.btn_back:
                finish();
            case R.id.button_equal:
                if (textViewInputNumbers.getText().toString() != null && !textViewInputNumbers.getText().toString().equals(""))
                    calculate(textViewInputNumbers.getText().toString());
                break;
        }

    }


    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                view.getBackground().clearColorFilter();
                view.invalidate();
                break;
            }
        }
        return false;
    }

    private boolean addDot()
    {
        boolean done = false;

        if (textViewInputNumbers.getText().length() == 0)
        {
            textViewInputNumbers.setText("0.");
            dotUsed = true;
            done = true;
        } else if (dotUsed == true)
        {
        } else if (defineLastCharacter(textViewInputNumbers.getText().charAt(textViewInputNumbers.getText().length() - 1) + "") == IS_OPERAND)
        {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + "0.");
            done = true;
            dotUsed = true;
        } else if (defineLastCharacter(textViewInputNumbers.getText().charAt(textViewInputNumbers.getText().length() - 1) + "") == IS_NUMBER)
        {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + ".");
            done = true;
            dotUsed = true;
        }
        return done;
    }

    private boolean addParenthesis()
    {
        boolean done = false;
        int operationLength = textViewInputNumbers.getText().length();

        if (operationLength == 0)
        {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
            dotUsed = false;
            openParenthesis++;
            done = true;
        } else if (openParenthesis > 0 && operationLength > 0)
        {
            String lastInput = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            switch (defineLastCharacter(lastInput))
            {
                case IS_NUMBER:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + ")");
                    done = true;
                    openParenthesis--;
                    dotUsed = false;
                    break;
                case IS_OPERAND:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
                    done = true;
                    openParenthesis++;
                    dotUsed = false;
                    break;
                case IS_OPEN_PARENTHESIS:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
                    done = true;
                    openParenthesis++;
                    dotUsed = false;
                    break;
                case IS_CLOSE_PARENTHESIS:
                    textViewInputNumbers.setText(textViewInputNumbers.getText() + ")");
                    done = true;
                    openParenthesis--;
                    dotUsed = false;
                    break;
            }
        } else if (openParenthesis == 0 && operationLength > 0)
        {
            String lastInput = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            if (defineLastCharacter(lastInput) == IS_OPERAND)
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + "(");
                done = true;
                dotUsed = false;
                openParenthesis++;
            } else
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + "x(");
                done = true;
                dotUsed = false;
                openParenthesis++;
            }
        }
        return done;
    }

    private boolean addOperand(String operand)
    {
        boolean done = false;
        int operationLength = textViewInputNumbers.getText().length();
        if (operationLength > 0)
        {
            String lastInput = textViewInputNumbers.getText().charAt(operationLength - 1) + "";

            if ((lastInput.equals("+") || lastInput.equals("-") || lastInput.equals("*") || lastInput.equals("\u00F7") || lastInput.equals("%")))
            {
                Toast.makeText(getApplicationContext(), "Wrong format", Toast.LENGTH_LONG).show();
            } else if (operand.equals("%") && defineLastCharacter(lastInput) == IS_NUMBER)
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            } else if (!operand.equals("%"))
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            }
        } else
        {
            Toast.makeText(getApplicationContext(), "Wrong Format. Operand Without any numbers?", Toast.LENGTH_LONG).show();
        }
        return done;
    }

    private boolean addNumber(String number)
    {
        boolean done = false;
        int operationLength = textViewInputNumbers.getText().length();
        if (operationLength > 0)
        {
            String lastCharacter = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            int lastCharacterState = defineLastCharacter(lastCharacter);

            if (operationLength == 1 && lastCharacterState == IS_NUMBER && lastCharacter.equals("0"))
            {
                textViewInputNumbers.setText(number);
                done = true;
            } else if (lastCharacterState == IS_OPEN_PARENTHESIS)
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
                done = true;
            } else if (lastCharacterState == IS_CLOSE_PARENTHESIS || lastCharacter.equals("%"))
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + "x" + number);
                done = true;
            } else if (lastCharacterState == IS_NUMBER || lastCharacterState == IS_OPERAND || lastCharacterState == IS_DOT)
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
                done = true;
            }
        } else
        {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
            done = true;
        }
        return done;
    }


    private void calculate(String input)
    {
        String result = "";
        try
        {
            String temp = input;
            if (equalClicked)
            {
                temp = input + lastExpression;
            } else
            {
                saveLastExpression(input);
            }
            result = scriptEngine.eval(temp.replaceAll("%", "/100").replaceAll("x", "*").replaceAll("[^\\x00-\\x7F]", "/")).toString();
            BigDecimal decimal = new BigDecimal(result);
            result = decimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString();
            equalClicked = true;

        } catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Wrong Format", Toast.LENGTH_SHORT).show();
            return;
        }

        if (result.equals("Infinity"))
        {
            Toast.makeText(getApplicationContext(), "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
            textViewInputNumbers.setText(input);

        } else if (result.contains("."))
        {
            result = result.replaceAll("\\.?0*$", "");
            textViewInputNumbers.setText(result);
        }
    }

    private void saveLastExpression(String input)
    {
        String lastOfExpression = input.charAt(input.length() - 1) + "";
        if (input.length() > 1)
        {
            if (lastOfExpression.equals(")"))
            {
                lastExpression = ")";
                int numberOfCloseParenthesis = 1;

                for (int i = input.length() - 2; i >= 0; i--)
                {
                    if (numberOfCloseParenthesis > 0)
                    {
                        String last = input.charAt(i) + "";
                        if (last.equals(")"))
                        {
                            numberOfCloseParenthesis++;
                        } else if (last.equals("("))
                        {
                            numberOfCloseParenthesis--;
                        }
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(input.charAt(i) + "") == IS_OPERAND)
                    {
                        lastExpression = input.charAt(i) + lastExpression;
                        break;
                    } else
                    {
                        lastExpression = "";
                    }
                }
            } else if (defineLastCharacter(lastOfExpression + "") == IS_NUMBER)
            {
                lastExpression = lastOfExpression;
                for (int i = input.length() - 2; i >= 0; i--)
                {
                    String last = input.charAt(i) + "";
                    if (defineLastCharacter(last) == IS_NUMBER || defineLastCharacter(last) == IS_DOT)
                    {
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(last) == IS_OPERAND)
                    {
                        lastExpression = last + lastExpression;
                        break;
                    }
                    if (i == 0)
                    {
                        lastExpression = "";
                    }
                }
            }
        }
    }

    private int defineLastCharacter(String lastCharacter)
    {
        try
        {
            Integer.parseInt(lastCharacter);
            return IS_NUMBER;
        } catch (NumberFormatException e)
        {
        }

        if ((lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("x") || lastCharacter.equals("\u00F7") || lastCharacter.equals("%")))
            return IS_OPERAND;

        if (lastCharacter.equals("("))
            return IS_OPEN_PARENTHESIS;

        if (lastCharacter.equals(")"))
            return IS_CLOSE_PARENTHESIS;

        if (lastCharacter.equals("."))
            return IS_DOT;

        return -1;
    }
}