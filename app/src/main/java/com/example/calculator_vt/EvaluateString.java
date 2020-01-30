package com.example.calculator_vt;

import java.util.*;
import java.lang.*;

class EvaluateString
{
    public static float evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
        Stack<Float> values = new Stack<Float>();

        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {

            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                if(tokens[i]=='-'){
                    sbuf.append(tokens[i]+ tokens[i+1]);
                    i++;
                }
                while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9' ) || (tokens[i]=='.')))
                    sbuf.append(tokens[i++]);
                values.push(Float.parseFloat(sbuf.toString()));
            }


            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '%' )
            {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));


        return values.pop();
    }


    public static boolean hasPrecedence(char op1, char op2)
    {

        if ((op1 == '*' || op1 == '/') && (op2 == '+' /*|| op2 == '-'*/))
            return false;
        else if((op1== '%') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static float applyOp(char op, float b, float a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '%':
                return a * b/100;
        }
        return 0;
    }
}