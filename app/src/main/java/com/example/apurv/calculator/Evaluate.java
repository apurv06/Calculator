package com.example.apurv.calculator;

import java.util.Stack;

public class Evaluate {
    final static String Num="0123456789";

    public static float evaluate(String expression) throws Exception {

        char[] exps = expression.toCharArray();


        Stack<Float> values = new Stack<Float>();


        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < exps.length; i++)
        {

            if (exps[i] == ' ')
                continue;


            if (Num.contains(Character.toString(exps[i])))
            {
                String s = new String();

                while (i < exps.length && (Num.contains(Character.toString(exps[i]))||exps[i]=='.'))
                    s=s+exps[i++];
                i--;
                values.push(Float.parseFloat(s));
            }


            else if (exps[i] == '(')
                ops.push(exps[i]);


            else if (exps[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(CalcOperand(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }


            else if (exps[i] == '+' || exps[i] == '-' ||
                    exps[i] == '*' || exps[i] == '/')
            {

                while (!ops.empty() && hasPrecedence(exps[i], ops.peek()))
                    values.push(CalcOperand(ops.pop(), values.pop(), values.pop()));


                ops.push(exps[i]);
            }
        }


        while (!ops.empty())
            values.push(CalcOperand(ops.pop(), values.pop(), values.pop()));


        return values.pop();
    }


    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op1 == '(')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }


    public static float CalcOperand(char op, float y, float x) throws Exception {
        switch (op)
        {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                if (y == 0)
                    throw new Exception();

                return x / y;
        }
        return 0;
    }
}
